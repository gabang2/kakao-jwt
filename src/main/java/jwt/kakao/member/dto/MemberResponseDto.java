package jwt.kakao.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MemberResponseDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class Response {
        private Long id;

        private Long kakaoId;

        private String nickname;

        private int level;

        private String badge;

        private int challengeCnt;
        private String refreshToken;

    }
}
