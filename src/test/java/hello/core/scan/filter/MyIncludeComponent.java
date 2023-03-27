package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//MyIncludeComponent annotation이 붙은 것은 Component Scan에 추가할 것이라는 내용
public @interface MyIncludeComponent {
}
