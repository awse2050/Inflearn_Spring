package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    애플리케이션 환경구성을 여기서 한다.
    객체의 생성 및 주입
    구현에 대한 역할들이 잘 보이게끔 코드를 수정 해야 한다.
 */
/*
    구체적인 구성영역은 수정이 있을 수 있기때문에 변경이 잦다.
    하지만 이곳을 변경한다고 해서 실행영역에 변경되지 않는다.
 */
// 12/04 스프링으로 변환하기.
@Configuration
public class AppConfig {

    /*
        @Bean을 사용하면 스프링 컨테이너에 등록이 된다.
        기본적으로 메서드 이름으르 등록이 된다.
        Bean에 매개변수를 추가해서 빈 이름을 변경할 수 있지만 웬만하면 관례를 따르는 것이 좋다.
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
