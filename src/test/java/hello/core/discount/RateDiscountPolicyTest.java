package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//RateDiscountPolicy 가 진짜로 10% discount가 되는 지 Test할 것이다.
class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.") //JUnit5의 기능
    void vip_o() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(1000);
        //Assertions.assertThat(discount).isEqualTo(1000);
        // => 에서 Alt + Enter를 쳐서 on-demand static import 를 하면 간결해진다.
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}