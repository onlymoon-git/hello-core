package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* 하나의 interface에 하나의 구현체만 있을 경우에 관례상 구현체에 Impl을 붙인다 */
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //자동으로 연결해서 주입해라. 생성자 위에 기술
    @Autowired //AppConfig.class에서 생성자에 의해서 주입되던 것을 @Autowired가 해준다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트를 위한 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
