package idusw.springboot.board3b.repository;

import idusw.springboot.board3b.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

}
