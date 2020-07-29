package example.spring.DI.assembler;

import example.spring.DI.dao.MemberDao;
import example.spring.DI.service.ChangePasswordService;
import example.spring.DI.service.MemberRegisterService;

// 조립기는 객체를 생성하고 의존 객체를 주입하는 기능을 제공한다.
// 또한 특정 객체가 필요한 곳에 객체를 제공한다.
public class Assembler {

    private MemberDao memberDao;
    private MemberRegisterService registerService;
    private ChangePasswordService passwordService;

    public Assembler() {
        memberDao = new MemberDao();
        // 생성자를 통한 의존성 주입
        registerService = new MemberRegisterService(memberDao);
        passwordService = new ChangePasswordService();
        // Setter를 통한 의존성 주입
        passwordService.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getRegisterService() {
        return registerService;
    }

    public ChangePasswordService getPasswordService() {
        return passwordService;
    }
}
