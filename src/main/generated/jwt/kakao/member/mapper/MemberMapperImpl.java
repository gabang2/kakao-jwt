package jwt.kakao.member.mapper;

import javax.annotation.processing.Generated;
import jwt.kakao.member.dto.MemberRequestDto.Patch;
import jwt.kakao.member.dto.MemberRequestDto.Post;
import jwt.kakao.member.dto.MemberResponseDto.Response;
import jwt.kakao.member.entity.Member;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-07T00:51:16+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(Post post) {
        if ( post == null ) {
            return null;
        }

        Member member = new Member();

        member.setId( post.getId() );
        member.setKakaoId( post.getKakaoId() );
        member.setNickname( post.getNickname() );
        member.setLevel( post.getLevel() );
        member.setBadge( post.getBadge() );
        member.setChallengeCnt( post.getChallengeCnt() );
        member.setRefreshToken( post.getRefreshToken() );

        return member;
    }

    @Override
    public Member memberPatchDtoToMember(Patch patch) {
        if ( patch == null ) {
            return null;
        }

        Member member = new Member();

        member.setId( patch.getId() );
        member.setKakaoId( patch.getKakaoId() );
        member.setNickname( patch.getNickname() );
        member.setLevel( patch.getLevel() );
        member.setBadge( patch.getBadge() );
        member.setChallengeCnt( patch.getChallengeCnt() );
        member.setRefreshToken( patch.getRefreshToken() );

        return member;
    }

    @Override
    public Response memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        Response response = new Response();

        response.setId( member.getId() );
        response.setKakaoId( member.getKakaoId() );
        response.setNickname( member.getNickname() );
        response.setLevel( member.getLevel() );
        response.setBadge( member.getBadge() );
        response.setChallengeCnt( member.getChallengeCnt() );
        response.setRefreshToken( member.getRefreshToken() );

        return response;
    }
}
