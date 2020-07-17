package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // AnnotationConfigApplicationContext 클래스는 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
        // AnnotationConfigApplicationContext는 AppContext에서 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화함.
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);
        /*
         getBean() : 빈 객체를 검색함. 첫 번째 파라미터는 @Bean의 메소드 이름인 빈 객체의 이름이며, 두 번째 파라미터는 검색할 빈 객체의
                     타입이다.
         */
        // getBean()은 greeter()가 생성한 Greeter 객체를 리턴한다.
        Greeter g = ctx.getBean("greeter", Greeter.class);
        // 구한 Greeter 객체의 메서드를 실행한다.
        String msg = g.greet("스프링");
        System.out.println(msg);
        ctx.close();
    }
}
