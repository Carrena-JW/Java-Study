package com.example.demo;

import com.example.demo.Repository.JdbcMemberRepository;
import com.example.demo.Repository.JdbcTemplateMemberRepository;
import com.example.demo.Repository.MemberRepository;
import com.example.demo.Repository.MemoryMemberRepository;
import com.example.demo.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {
    private final DataSource dataSource;
    public SpringConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService MemberService() {
        return new MemberService(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
      //  return new JdbcMemberRepository(dataSource);
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
