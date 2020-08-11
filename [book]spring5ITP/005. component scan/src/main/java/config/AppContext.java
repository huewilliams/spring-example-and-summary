package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import util.*;

@Configuration
// @Component 어노테이션을 붙인 클래스를 스캔해서 스프링 빈으로 등록하려면 설정 클래스에 @ComponentScan 어노테이션을 적용해야 한다.
// basePackages 속성 값은 스캔 대상 패키지 목록을 지정한다. 대상 패키지와 그 하위 패키지에 속한 클래스를 스캔 대상으로 설정한다.
// 스캔 대상에 해당하는 클래스 중에서 @Component 어노테이션이 붙은 클래스의 객체를 생성해서 빈으로 등록한다.
@ComponentScan(basePackages = {"dao", "util", "service"})
public class AppContext {

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
