package hello.core2.singleton;

import hello.core2.AppConfig;
import hello.core2.member.MemberRepository;
import hello.core2.member.MemberServiceImpl;
import hello.core2.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        //모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository  = " +
                orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        //assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        //assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
