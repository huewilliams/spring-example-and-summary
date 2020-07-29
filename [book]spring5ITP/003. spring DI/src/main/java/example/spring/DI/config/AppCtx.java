package example.spring.DI.config;

import example.spring.DI.dao.MemberDao;
import example.spring.DI.service.ChangePasswordService;
import example.spring.DI.service.MemberRegisterService;
import example.spring.DI.util.MemberListPrinter;
import example.spring.DI.util.MemberPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService registerService() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService passwordService = new ChangePasswordService();
        passwordService.setMemberDao(memberDao());
        return passwordService;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter());
    }
}
