package jwt.kakao.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
