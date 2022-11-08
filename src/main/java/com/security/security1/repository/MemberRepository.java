package com.security.security1.repository;

import com.security.security1.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//Crud함수를 JpaRepository가 들고있음.
//@Repository라는 어노테이션이 없어도 IoC되요. 이유는 JpaRepository를 상속햇기 때문에가능
public interface MemberRepository extends JpaRepository<Member, Integer> {
    public Member findByUsername(String username);

}
