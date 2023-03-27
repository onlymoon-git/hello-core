package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //시작위치를 지정하지 않으면 default로 AutoAppconfig 가 속해있는 package 부터 찾기 시작
        // --> 여기서는 "package hello.core;"

        //스프링 빈을 찾는 시작위치 지정
        basePackages = "hello.core",

        //내 package에서 찾기 시작: 여기서는 "package hello.core;"
        basePackageClasses = AutoAppConfig.class,

        //AppConfig.class는 수동으로 등록하는 설정파일인데 예제코드를 살리기위해서 빼주는 것이다.
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
