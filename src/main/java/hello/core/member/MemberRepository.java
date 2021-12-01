package hello.core.member;

/*
    회원 저장소 인터페이스 - 아직 자체 DB를 사용할 지 미정.
 */
public interface MemberRepository {

    // 회원가입
    public void save(Member member);

    // 회원조회
    public Member findById(Long memberId);

}
