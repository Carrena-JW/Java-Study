package com.example.demo.Service;

import com.example.demo.Domain.Member;
import com.example.demo.Repository.MemberRepository;
import com.example.demo.Repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntTest {

    @Autowired MemberService service;

    @Test
    void join() {
        //given
        Member member =new Member();
        member.setName("지웅");

        //when
        Long saveId = service.Join(member);

        //then
        Member findMember = service.FindOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 회원중복확인(){
        //Given
        Member member1 = new Member();
        member1.setName("지웅");
        Member member2 = new Member();
        member2.setName("지웅");
//When
        service.Join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                ()->service.Join(member2));
        //예외가 발생해야 한다. assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then

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