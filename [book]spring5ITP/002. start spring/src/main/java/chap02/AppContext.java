package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정 클래스로 지정
public class AppContext {

    // 스프링이 생성한 객체를 빈(Bean) 객체라고 부른다.
    // @Bean을 메서드에 붙이면 해당 메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록한다.
    // @Bean을 붙이 메서드의 이름은 빈 객체를 구분할 때 사용한다. 이 이름은 빈 객체를 참조할 때 사용된다.
    @Bean
    public Greeter greeter() {
        Greeter g = new Greeter();
        g.setFormat("%s 안녕하세요!");
        return g;
    }
}
