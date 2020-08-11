package service;

import dao.MemberDao;
import domain.Member;
import dto.RegisterRequest;
import exception.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// @Component 어노테이션에 값을 주었는 지에 따라 사용할 이름이 결정된다.
// @Component 어노테이션에 값을 주지 않으면 클래스 이름의 첫 글자를 소문자로 바꾼 이름을 빈 이름으로 사용한다.
@Component
public class MemberRegisterService {
    @Autowired
    private MemberDao memberDao;

    public MemberRegisterService() {

    }

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
