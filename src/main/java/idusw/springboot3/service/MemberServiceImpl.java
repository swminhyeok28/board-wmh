package idusw.springboot3.service;

import idusw.springboot3.domain.Member;
import idusw.springboot3.entity.MemberEntity;
import idusw.springboot3.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    // DI - IoC (Inversion of Control : 제어의 역전) 방법 중 하나, DI, DL ...
    //
    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) { // Spring Framework이 주입(하도록 요청함)
        this.memberRepository = memberRepository;
    }

    @Override
    public int create(Member m) {
        MemberEntity entity = MemberEntity.builder()
                .seq(m.getSeq())
                .email(m.getEmail())
                .name(m.getName())
                .pw(m.getPw())
                .build();
        if(memberRepository.save(entity) != null) // 저장 성공
            return 1;
        else
            return 0;
    }

    @Override
    public Member read(Member m) {
        return null;
    }

    @Override
    public List<Member> readList() {
        return null;
    }

    @Override
    public int update(Member m) {
        return 0;
    }

    @Override
    public int delete(Member m) {
        return 0;
    } // 구현체

}
