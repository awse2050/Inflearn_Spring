package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// 주문 인터페이스 구현체 (클라이언트 코드)
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /*
        역할과 구현을 분리시키고 새로운 정책을 사용하려 했지만 클래스 의존관계를 보면
        추상과 구현에 모두 의존하고 있는 상태  - DIP(인터페이스에만 의존) 위반
     */
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /*
        아래와 같이하면 인터페이스에만 의존한다.
        근데 구현체가 없다.. 어떻게 할까
        누군가 구현객체를 대신 생성해서 주입을 해줘야한다.
        DIP는 지켰으나 구현이 안됨.
    */
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
