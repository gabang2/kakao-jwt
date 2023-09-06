package jwt.kakao.member.service;

import jwt.kakao.exception.BusinessLogicException;
import jwt.kakao.exception.ExceptionCode;
import jwt.kakao.member.entity.Member;
import jwt.kakao.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRespository;

    // CREATE
    public Member createMember(Member member) {
        return memberRespository.save(member);
    }

    // READ
    public Member findMember(long memberPk) {
        Member member = verifiedMember(memberPk);
        return member;
    }

    // UPDATE
    public Member patchMember(Member member) {
        Member findMember = verifiedMember(member.getId());
        Optional.ofNullable(member.getKakaoId()).ifPresent(findMember::setKakaoId);
        Optional.ofNullable(member.getNickname()).ifPresent(findMember::setNickname);
        Optional.ofNullable(member.getBadge()).ifPresent(findMember::setBadge);

        return memberRespository.save(findMember);
    }

    // DELETE
    public void deleteMember(long memberPk) {
        Member member = verifiedMember(memberPk);
        memberRespository.delete(member);
    }

    // 검증
    public Member verifiedMember(long memberPk) {
        Optional<Member> member = memberRespository.findById(memberPk);
        return member.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}
