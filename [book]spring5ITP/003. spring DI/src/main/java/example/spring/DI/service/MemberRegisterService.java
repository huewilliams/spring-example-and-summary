package example.spring.DI.service;

import example.spring.DI.dao.MemberDao;
import example.spring.DI.domain.Member;
import example.spring.DI.dto.RegisterRequest;
import example.spring.DI.exception.DuplicateMemberException;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest request) {
        Member member = memberDao.selectByEmail(request.getEmail());

        if (member != null)
            throw new DuplicateMemberException("duplicate email" + request.getEmail());

        Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(),
                LocalDateTime.now());
        memberDao.insert(newMember);

        return newMember.getId();
    }

}
