package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired //생성자 위에 기술
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    // 1. 주문생성 요청이 오면
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //2. 회원정보 조회

        //3. 할인정책에 회원(member)을 넘긴후 할인금액을 받는다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //4. 주문을 만들어서 반환하면 OrderService 의 역할은 끝이 난다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트를 위한 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
