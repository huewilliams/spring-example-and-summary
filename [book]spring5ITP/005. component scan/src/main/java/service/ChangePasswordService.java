package service;

import dao.MemberDao;
import domain.Member;
import exception.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component 어노테이션에 값을 주었는 지에 따라 사용할 이름이 결정된다.
// @Component 어노테이션에 값을 주지 않으면 클래스 이름의 첫 글자를 소문자로 바꾼 이름을 빈 이름으로 사용한다.
@Component
public class ChangePasswordService {

    // 자동으로 의존을 주입한다. 필드에 @Autowired가 있으면 스프링이 해당 타입의 Bean 객체를 찾아서 필드에 할당한다.
    @Autowired
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
