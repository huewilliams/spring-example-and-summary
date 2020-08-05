package service;

import dao.MemberDao;
import domain.Member;
import dto.RegisterRequest;
import exception.DuplicateMemberException;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDao memberDao;

    // 생성자를 통해 의존 객체를 주입 받음
    public MemberRegisterService(MemberDao memberDao) {
        // 주입 받은 객체를 필드에 할당
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest request) {
        // 주입 받은 의존 객체의 메서드를 사용
        Member member = memberDao.selectByEmail(request.getEmail());

        if (member != null)
            throw new DuplicateMemberException("duplicate email" + request.getEmail());

        Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(),
                LocalDateTime.now());
        memberDao.insert(newMember);

        return newMember.getId();
    }

}
