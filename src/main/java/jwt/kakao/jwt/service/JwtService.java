package jwt.kakao.jwt.service;

import jwt.kakao.jwt.provider.JwtProvider;
import jwt.kakao.member.entity.Member;
import jwt.kakao.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final MemberService memberService;

    @Value("${jwt.secret}")
    private String secretKey;

    public String getAccessToken(Member member){

        String refreshToken = JwtProvider.createRefreshToken(member.getId(), secretKey);
        member.setRefreshToken(refreshToken);
        memberService.patchMember(member);

        return "Bearer " + JwtProvider.createAccessToken(member.getId(), secretKey);
    }

    public Member getMemberFromAccessToken(String accessToken) {
        accessToken = accessToken.split(" ")[2];
        Long userId = JwtProvider.getUserId(accessToken, secretKey);
        return memberService.verifiedMember(userId);
    }
}
