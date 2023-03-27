package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Member 구현체가 제대로 작동하는 지 Test 하는 Class
//이렇게 main method로 테스트를 하는 것은 좋은 방법이 아니다.
public class MemberApp {

    public static void main(String[] args) {

        //Spring 사용하지 않을 때 사용하는 코드
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //AppConfig.class에 있는 설정 정보를 가지고 Spring이 스프링 컨테이너에 객체를 생성하여 넣어준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
