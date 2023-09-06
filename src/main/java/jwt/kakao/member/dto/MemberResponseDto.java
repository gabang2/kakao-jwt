package jwt.kakao.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MemberResponseDto {
    @AllArgsConstructor
    @Setter
    @Getter
    public static class Response {
        private Long id;

        private Long kakaoId;

        private String nickname;

        private int level;

        private String badge;

        private int challengeCnt;
    }
}
