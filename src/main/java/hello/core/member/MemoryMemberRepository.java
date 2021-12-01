package hello.core.member;

import java.util.HashMap;
import java.util.Map;
/*
    회원 저장소 인터페이스 구현체 - 아직 자체 DB를 사용할 지 미정.
 */
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
