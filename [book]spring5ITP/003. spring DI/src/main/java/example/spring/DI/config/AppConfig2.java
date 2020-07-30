package example.spring.DI.config;

import example.spring.DI.dao.MemberDao;
import example.spring.DI.service.ChangePasswordService;
import example.spring.DI.service.MemberRegisterService;
import example.spring.DI.util.MemberInfoPrinter;
import example.spring.DI.util.MemberListPrinter;
import example.spring.DI.util.MemberPrinter;
import example.spring.DI.util.VersionPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    // @Autowired : 스프링 빈 자동 주입 기능 (해당 타입의 빈을 찾아서 필드에 할당한다.)
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    @Bean
    public MemberRegisterService registerService() {
        return new MemberRegisterService(memberDao);
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService passwordService = new ChangePasswordService();
        passwordService.setMemberDao(memberDao);
        return passwordService;
    }
    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao, memberPrinter);
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDao);
        infoPrinter.setMemberPrinter(memberPrinter);
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
