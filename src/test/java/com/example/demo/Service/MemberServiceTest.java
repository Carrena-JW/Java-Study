package com.example.demo.Service;

import com.example.demo.Domain.Member;
import com.example.demo.Repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    MemberService service = new MemberService(repository);

    @AfterEach
    public void AfterEach(){
        repository.CleareStore();
    }

    @Test
    void join() {
        //given
        Member member =new Member();
        member.setName("지웅");

        //when
        Long saveId = service.Join(member);

        //then
        Member findMember = service.FindOne(saveId).get();
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void 회원중복확인(){
        //given
        Member member1 =new Member();
        member1.setName("지웅");

        Member member2 =new Member();
        member2.setName("지웅");

        //when
        service.Join(member1); //첫번째 추가

        //then
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> service.Join(member2));
        assertThat(e.getMessage()).isEqualTo("지웅 은 이미 등록된 이름입니다.");
    }

    @Test
    void findAllMembers() {
    }

    @Test
    void findOne() {
    }

    @Test
    void testFindOne() {
    }
}