package jwt.kakao.member.mapper;

import javax.annotation.processing.Generated;
import jwt.kakao.member.dto.MemberRequestDto;
import jwt.kakao.member.dto.MemberResponseDto;
import jwt.kakao.member.entity.Member;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T17:15:05+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberRequestDto.Post post) {
        if ( post == null ) {
            return null;
        }

        Member member = new Member();

        return member;
    }

    @Override
    public Member memberPatchDtoToMember(MemberRequestDto.Patch patch) {
        if ( patch == null ) {
            return null;
        }

        Member member = new Member();

        return member;
    }

    @Override
    public MemberResponseDto.Response memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto.Response response = new MemberResponseDto.Response();

        return response;
    }
}
