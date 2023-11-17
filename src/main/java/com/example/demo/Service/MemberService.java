package com.example.demo.Service;

import com.example.demo.Domain.Member;
import com.example.demo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository _memberRepo;

    @Autowired
    public MemberService(MemberRepository _memberRepo) {
        this._memberRepo = _memberRepo;
    }
    public Long Join(Member member){
        // 이름 중복 X 로직 추가
        VailtionByName(member);
        _memberRepo.Save(member);
        return member.getId();
    }

    public List<Member> FindAllMembers(){
        return _memberRepo.FindAll();
    }

    public Optional<Member> FindOne(Long id){
        return _memberRepo.FindById(id);
    }

    public Optional<Member> FindOne(String name){
        return _memberRepo.FindByName(name);
    }

    private void VailtionByName(Member member) {
        _memberRepo.FindByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException(m.getName() + " 은 이미 등록된 이름입니다.");
        });
    }
}
