package util;

import domain.Member;
import jdk.internal.jline.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

    public void print(Member member) {
        if (dateTimeFormatter == null) {
            System.out.printf(
                    "회원 정보 : 아이디=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(),
                    member.getName(), member.getRegisterDateTime()
            );
        } else {
            System.out.printf(
                    "회원 정보 : 아이디=%s, 이메일=%s, 이름=%s, 등록일=%s\n",
                    member.getId(), member.getEmail(),
                    member.getName(),
                    dateTimeFormatter.format(member.getRegisterDateTime())
            );
        }
    }

    // @Autowired 어노테이션의 required 속성을 false로 지정하면 매칭되는 빈이 없어도 익셉션이 발생하지 않으며 자동 주입을 수행하지 않는다.
    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    // 스프링5 부터는 위의 방법 대신 의존 주입 대상에 Optional을 사용해도 된다. : Optional<DateTimeFormatter> opt
    // 자동 주입 대상 타입이 Optional인 경우, 일치하는 빈이 존재하지 않으면 값이 없는 Optional을 인자로 전달하고(익셉셥 발생 안함),
    // 일치하는 빈이 존재하면 해당 빈을 값으로 갖는 Optional을 인자로 전달한다.
    @Autowired
    public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt) {
        if (formatterOpt.isPresent()) {
            this.dateTimeFormatter = formatterOpt.get();
        } else {
            this.dateTimeFormatter = null;
        }
    }

    // @Autowired 를 붙인 세터 메서드에서 @Nullable 어노테이션을 의존 주입 대상 파라미터에 붙이면,
    // 스프링 컨테이너는 세터 메서드를 호출할 때 자동 주입할 빈이 존재하면 해당 빈을 인자로 전달하고,
    // 존재하지 않으면 인자로 null을 전달한다.
    @Autowired
    public void setDateTimeFormatterNullable(@Nullable DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    // @Autowired(required=false) 와 @Nullable 의 차이는 @Nullable은 자동 주입할 빈이 존재하지 않아도 메서드를 호출하지만
    // @Autowired(required=false)는 대상 빈이 존재하지 않으면 세터 메서드를 호출하지 않는다.
}
