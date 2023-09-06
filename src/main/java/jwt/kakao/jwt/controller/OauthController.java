package jwt.kakao.jwt.controller;

import jwt.kakao.jwt.dto.KakaoUserInfo;
import jwt.kakao.jwt.service.OauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OauthController {

    private final OauthService oauthService;

    @ResponseBody
    @GetMapping("/api/oauth/kakao")
    public void kakaoCallback(@RequestParam String code) {
        log.info("code : " + code);

        // 유저 정보 얻기
        String kakaoAccessToken = oauthService.getKakaoAccessToken(code);
        KakaoUserInfo kakaoUserInfo = oauthService.getKakaoUserInfo(kakaoAccessToken);

        // Member 만들기

    }

}
