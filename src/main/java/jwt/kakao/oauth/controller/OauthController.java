package jwt.kakao.oauth.controller;

import jwt.kakao.oauth.dto.KakaoUserInfo;
import jwt.kakao.oauth.service.OauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
        String accesstoken = oauthService.getKakaoAccessToken(code);
        System.out.println(accesstoken);
        KakaoUserInfo kakaoUserInfo = oauthService.getKakaoUserInfo(accesstoken);
    }

}
