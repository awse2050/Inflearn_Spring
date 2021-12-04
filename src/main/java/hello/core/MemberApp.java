package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    /*
        테스트 코드
        하지만, 애플리케이션 로직에서는 좋은 방식의 테스트가 아니다.
        JUnit 프레임워크를 사용 하자.
     */
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        // appConfig에서 객체를 결정하고 넘겨준다.
//        MemberService memberService = appConfig.memberService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }

}
