package com.example.demo.Repository;

import com.example.demo.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member Save(Member member);
    Optional<Member> FindById(long id);
    Optional<Member> FindByName(String name);
    List<Member> FindAll();
}
