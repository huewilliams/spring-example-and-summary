package util;

import dao.MemberDao;
import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

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
