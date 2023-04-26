package idusw.springboot3.controller;

import idusw.springboot3.domain.Member;
import idusw.springboot3.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberControllerTests {
    @Autowired
    MemberService memberService;
    @Test
    void readMember() { // seq를 사용해야 함
        Member member = Member.builder()
                .seq(1052L)
                .build();
        Member result = null;
        if((result = memberService.read(member)) != null ) // 정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            System.out.println("조회 성공!" + result.getEmail() + ":" + result.getName());
        else
            System.out.println("조회 실패!");
    }
}
