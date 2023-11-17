package com.example.demo.Repository;
import com.example.demo.Domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MemoryMemberRepositoryTest {
    MemoryMemberRepository _repo = new MemoryMemberRepository();

    @AfterEach
    public void AfterEach(){
        _repo.CleareStore();
    }


    @Test
    public void Save(){
        Member member = new Member();
        member.setName("JW");

        _repo.Save(member);

        Member result = _repo.FindById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void FindByName(){
        Member member1 = new Member();
        member1.setName("JW1");
        _repo.Save(member1);

        Member member2 = new Member();
        member2.setName("JW2");
        _repo.Save(member2);

        Member result = _repo.FindByName("JW1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void FindAll(){
        Member member1 = new Member();
        member1.setName("JW1");
        _repo.Save(member1);

        Member member2 = new Member();
        member2.setName("JW2");
        _repo.Save(member2);

        List<Member> result =  _repo.FindAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
