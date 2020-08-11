package util;

import dao.MemberDao;
import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

// @Component 어노테이션에 값을 주었는 지에 따라 사용할 이름이 결정된다.
// @Component 어노테이션에 값을 주면 그 값을 빈 이름으로 사용한다.
@Component("listPrinter")
public class MemberListPrinter {

    private MemberDao memberDao;
    private MemberSummaryPrinter printer;

    public MemberListPrinter() {

    }

    public MemberListPrinter(MemberDao memberDao, MemberSummaryPrinter printer) {
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
    public void setPrinter(MemberSummaryPrinter printer) {
        this.printer = printer;
    }
}
