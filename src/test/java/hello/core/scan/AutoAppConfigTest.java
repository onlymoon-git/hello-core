package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

//        Map<String, MemberService> beansOfType = ac.getBeansOfType(MemberService.class);
//        for (String key : beansOfType.keySet()) {
//            System.out.println("key = " + key + " value = " + beansOfType.get(key));
//        }
//
//        assertThat(beansOfType.size()).isEqualTo(2);
    }
}
