package com.example.demo;

import com.example.demo.Repository.*;
import com.example.demo.Service.MemberService;
import com.example.demo.aop.TimeTraceAop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {
    //    private final DataSource dataSource;
//    private final EntityManager em;
//    public SpringConfiguration(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfiguration(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService MemberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

//    @Bean
//    public MemberRepository MemberRepository()  //  return new JdbcMemberRepository(dataSource);
////        return new MemoryMemberRepository();
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
