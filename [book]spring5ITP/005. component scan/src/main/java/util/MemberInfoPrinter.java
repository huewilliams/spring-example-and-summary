package util;

import dao.MemberDao;
import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음");
            return;
        }
        memberPrinter.print(member);
        System.out.println();
    }

    // Bean 객체의 메서드에 @Autowired 어노테이션을 붙이면 스프링은 해당 메서드를 호출한다.
    // 이때 메서드 파라미터 타입에 해당하는 Bean 객체를 찾아 주입한다.
    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    @Qualifier("printer")
    // 자동 주입 가능한 빈이 두 개 이상이면 @Qualifier 어노테이션을 사용하여 자동 주입 대상 빈을 한정할 수 있다.
    // 한정자가 printer인 빈을 의존 주입한다.
    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }
}
