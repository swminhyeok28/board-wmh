package idusw.springboot.board3b.repository;


import idusw.springboot.board3b.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
