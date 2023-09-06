package jwt.kakao.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

public class MemberRequestDto {
    @AllArgsConstructor
    @Setter
    @Getter
    public static class Post {
        private Long id;

        private Long kakaoId;

        private String nickname;

        private int level;

        private String badge;

        private int challengeCnt;
    }

    @AllArgsConstructor
    @Setter
    @Getter
    public static class Patch {
        private Long id;

        private Long kakaoId;

        private String nickname;

        private int level;

        private String badge;

        private int challengeCnt;
    }
}
