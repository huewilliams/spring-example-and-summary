package config;

import dao.MemberDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.ChangePasswordService;
import service.MemberRegisterService;
import util.*;

@Configuration
public class AppContext {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

//    @Bean
//    public MemberPrinter memberPrinter() {
//        return new MemberPrinter();
//    }

    @Bean
    // 한정자를 printer로 지정한다. 이렇게 지정한 한정자는 @Autowired에서 자동 주입할 빈을 한정할 때 사용된다.
    // @Qualifier로 한정자를 지정하지 않으면 빈 이름이 한정자가 된다.
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    public MemberPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService();
    }

    // 의존을 주입하지 않아도 스프링이 @Autowired가 붙은 필드에 해당 타입의 Bean 객체를 찾아서 주입한다.
    @Bean
    public ChangePasswordService changePasswordService() {
        return new ChangePasswordService();
    }

    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        return new MemberInfoPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
