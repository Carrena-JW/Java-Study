package com.example.demo.Service;

import com.example.demo.Domain.Member;
import com.example.demo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
public class MemberService {
    private final MemberRepository _memberRepo;

    @Autowired
    public MemberService(MemberRepository _memberRepo) {
        this._memberRepo = _memberRepo;
    }
    public Long join(Member member){
        // 이름 중복 X 로직 추가
        vailtionByName(member);
        _memberRepo.save(member);
        return member.getId();
    }

    public List<Member> findAllMembers(){
        return _memberRepo.findAll();
    }

    public Optional<Member> findOne(Long id){
        return _memberRepo.findById(id);
    }

    public Optional<Member> findOne(String name){
        return _memberRepo.findByName(name);
    }

    private void vailtionByName(Member member) {
        _memberRepo.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException(m.getName() + " 은 이미 등록된 이름입니다.");
        });
    }
}
