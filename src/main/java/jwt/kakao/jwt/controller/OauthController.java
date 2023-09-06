package jwt.kakao.jwt.controller;

import jwt.kakao.jwt.dto.KakaoUserInfo;
import jwt.kakao.jwt.provider.JwtProvider;
import jwt.kakao.jwt.service.JwtService;
import jwt.kakao.jwt.service.OauthService;
import jwt.kakao.member.dto.MemberResponseDto;
import jwt.kakao.member.entity.Member;
import jwt.kakao.member.mapper.MemberMapper;
import jwt.kakao.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api")
@Validated
@AllArgsConstructor
public class OauthController {

    private final OauthService oauthService;
    private final MemberService memberService;
    private final JwtService jwtService;
    private final MemberMapper memberMapper;

    @GetMapping("/oauth/kakao")
    public ResponseEntity kakaoCallback(@RequestParam String code) {

        // 유저 정보 얻기
        String kakaoAccessToken = oauthService.getKakaoAccessToken(code);
        KakaoUserInfo kakaoUserInfo = oauthService.getKakaoUserInfo(kakaoAccessToken);

        // 해당 kakao ID를 가진 Member 반환
        Member member = memberService.findMemberByKakaoId(kakaoUserInfo.getId());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", jwtService.getAccessToken(member));
        return new ResponseEntity<>(jwtService.getAccessToken(member), responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/getMember")
    public ResponseEntity returnMemberDetail(@RequestHeader("Authorization") String accessToken) {
        Member member = jwtService.getMemberFromAccessToken(accessToken.split(" ")[1]);
        MemberResponseDto.Response response = memberMapper.memberToMemberResponseDto(member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
