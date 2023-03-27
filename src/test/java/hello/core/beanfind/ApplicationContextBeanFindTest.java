package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //memberService가 MemberServiceImpl의 instance 이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);

        //memberService가 MemberServiceImpl의 instance 이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //역할이 아니라 구현에 의존하기때문에 좋은 코드는 아니다.
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        //memberService가 MemberServiceImpl의 instance 이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
        //ac.getBean("xxxxx", MemberService.class);
        /*MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
         -> 이것이 람다로 Throws 문 안으로 들어갔다.*/
        /* "() -> ac.getBean("xxxxx", MemberService.class)"를 실행하면
           "oSuchBeanDefinitionException.class" 예외가 터져야 성공이다. */
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }
}
