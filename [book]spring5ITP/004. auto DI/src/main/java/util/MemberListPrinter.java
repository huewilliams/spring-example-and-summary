package util;

import dao.MemberDao;
import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public class MemberListPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    public MemberListPrinter() {

    }

    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
        this.memberDao = memberDao;
        this.printer = printer;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> printer.print(m));
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    // 자동 주입 가능한 빈이 두 개 이상이면 @Qualifier 어노테이션을 사용하여 자동 주입 대상 빈을 한정할 수 있다.
    // 한정자가 printer인 빈을 의존 주입한다.
    @Qualifier("printer")
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }
}
