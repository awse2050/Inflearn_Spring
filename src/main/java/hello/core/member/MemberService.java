package hello.core.member;

// 회원 서비스 인터페이스
public interface MemberService {
    // 회원가입
    public void join(Member member);

    // 회원조회
    public Member findMember(Long memberId);
}
