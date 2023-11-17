package com.example.demo.Repository;
import com.example.demo.Domain.Member;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> _store= new HashMap<>();
    private static long _sequence = 0L;

    public void CleareStore(){
        _store.clear();
    }
    @Override
    public Member Save(Member member) {
        member.setId(_sequence++);
        _store.put(member.getId(), member);
        return  member;
    }

    @Override
    public Optional<Member> FindById(long id) {
        return Optional.ofNullable(_store.get(id));
    }

    @Override
    public Optional<Member> FindByName(String name) {
        return  _store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> FindAll() {
        return new ArrayList<>(_store.values());
    }
}
