package example.spring.DI.service;

import example.spring.DI.dao.MemberDao;
import example.spring.DI.domain.Member;
import example.spring.DI.exception.MemberNotFoundException;

public class ChangePasswordService {

    private MemberDao memberDao;

    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);

        if(member == null)
            throw new MemberNotFoundException();

        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

}
