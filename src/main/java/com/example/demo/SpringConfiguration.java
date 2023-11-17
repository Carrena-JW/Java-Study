package com.example.demo;

import com.example.demo.Repository.MemberRepository;
import com.example.demo.Repository.MemoryMemberRepository;
import com.example.demo.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public MemberService MemberService(){
        return new MemberService(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository(){
    return new MemoryMemberRepository();
    }
}
