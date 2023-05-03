package idusw.springboot3;

import idusw.springboot3.domain.Member;
import idusw.springboot3.domain.Memo;
import idusw.springboot3.service.MemberService;
import idusw.springboot3.service.MemoService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Board3BApplicationTests {
    @Autowired
    MemberService memberService;
    @Autowired
    MemoService memoService;
    @Test
    @Transactional // could not initialize proxy - no Session : Lazy fetch 로 인한 오류
    void createMember() {
        Member member = Member.builder()
                .email("13@13.com")
                .name("13")
                .pw("13")
                .build();
        if(memberService.create(member) > 0 ) // 정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            System.out.println("등록 성공");
        else
            System.out.println("등록 실패");
    }



    @Test
    public void readMemo() {
        Memo m = new Memo();
        m.setMno(1L);
        Memo result;
        if((result = memoService.read(m)) != null)
            System.out.println(result.getMemoText());
    }
}
