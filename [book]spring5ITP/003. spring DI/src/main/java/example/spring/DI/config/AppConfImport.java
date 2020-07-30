package example.spring.DI.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// @Import 애노테이션은 함께 사용할 설정 클래스를 지정한다.
// AppConfImport 설정 클래스를 사용하면 @Import로 지정한 설정 클래스도 함께 사용하므로 스프링 컨테이너를 생성할 때 @Import로 지정한
// 클래스를 지정할 필요가 없다.
// @Import 애노테이션은 다음과 같이 배열을 이용해서 두 개 이상의 설정 클래스도 지정할 수 있다.
@Import({ AppConfig1.class, AppConfig2.class })
public class AppConfImport {

}
