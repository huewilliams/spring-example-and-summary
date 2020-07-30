package example.spring.DI.main;

import example.spring.DI.config.AppConfig1;
import example.spring.DI.config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainForConfigurationBean {

    public static void main(String[] args) {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig1.class, AppConfig2.class);

        // @Configuration 설정 클래스도 빈으로 등록함
        AppConfig1 appConfig1 = context.getBean(AppConfig1.class);
        System.out.println(appConfig1 != null); //true

        context.close();
    }
}
