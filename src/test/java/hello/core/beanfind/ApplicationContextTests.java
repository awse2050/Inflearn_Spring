package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextTests {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void findAllBean() {
        String[] beanNames = ac.getBeanDefinitionNames();
        /*
            스프링 내부에 있는 빈들까지 모두 출력된다.
         */
        for (String beanName : beanNames) {
            Object bean = ac.getBean(beanName);
            System.out.println(beanName + " : " + bean);
        }
    }

    @Test
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // alt enter
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    void findBeanByType() {
        // 같은 타입이 여러개일 경우 곤란.
        MemberService memberService = ac.getBean(MemberService.class);
        // alt enter
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
