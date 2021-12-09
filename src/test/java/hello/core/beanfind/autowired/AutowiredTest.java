package hello.core.beanfind.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

// 옵션 처리 테스트
public class AutowiredTest {

    /*
        자동주입 대상 옵션
        1. @Autowired(require = false) - 자동주입할 대상이 없으면 호출x
        2. @Nullable - 자동 주입할 대상이 없으면 null
        3. Optional - 자동주입 대상이 없으면 Optional.empty
     */

    @Test
    public void AutowiredOption() {
        // TestBean 스프링 빈 등록
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    
    static class TestBean {

        // 의존관계가 없으면 이 메서드 자체가 미호출.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            // MEmber는 빈이 아니다.
            System.out.println("noBean1 = " + noBean1);
        }

        // @Nullable을 넣으면 호출은 되지만 null
        @Autowired
        public void setNoBean2(@Nullable Member noBean1) {
            // MEmber는 빈이 아니다.
            System.out.println("noBean1 = " + noBean1);
        }

        // 스프링 빈이 없으면 empty
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
        
    }

}
