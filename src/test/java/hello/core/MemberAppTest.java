package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberAppTest {

    MemberService memberService;

    // 각 테스트가 실행전 이 메서드가 실행된다.
    @BeforeEach
    public void before() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void main() {
        // given = 특정상황이 주어졌다.
        Member member = new Member(1L , "memberA", Grade.VIP);

        // when = 그떄 이런 데이터를.
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // then = 데이터의 결과물의 일치여부
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}