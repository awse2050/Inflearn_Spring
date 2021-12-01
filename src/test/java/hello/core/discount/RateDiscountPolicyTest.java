package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    public void VIP_10_할인_적용() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member, 10000);
        //then
        // ALT + ENTER 사용시 static import 를 해준다.
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    public void VIP_10_할인_미적용() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

}