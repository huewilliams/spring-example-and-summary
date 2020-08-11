package dao;

import domain.Member;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// @Component 어노테이션에 값을 주었는 지에 따라 사용할 이름이 결정된다.
// @Component 어노테이션에 값을 주지 않으면 클래스 이름의 첫 글자를 소문자로 바꾼 이름을 빈 이름으로 사용한다.
@Component
public class MemberDao {

    private static long nextId = 0;

    private Map<String, Member> map = new HashMap<>();

    public Member selectByEmail(String email) {
        return map.get(email);
    }

    public void insert(Member member) {
        member.setId(++nextId);
        map.put(member.getEmail(), member);
    }

    public void update(Member member) {
        map.put(member.getEmail(), member);
    }

    public Collection<Member> selectAll() {
        return map.values();
    }

}
