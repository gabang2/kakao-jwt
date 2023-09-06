package jwt.kakao.member.mapper;

import jwt.kakao.member.dto.MemberRequestDto;
import jwt.kakao.member.dto.MemberResponseDto;
import jwt.kakao.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberRequestDto.Post post);
    Member memberPatchDtoToMember(MemberRequestDto.Patch patch);
    MemberResponseDto.Response memberToMemberResponseDto(Member member);
}