package idusw.springboot3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 클래스임으로 나타내는 애노테이션
@Table(name = "member_b201818064")

@ToString   // lombok 라이브러리 사용
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@SequenceGenerator(sequenceName = "member_b201818064_seq", name = "member_b201818064_seq_gen",
                    initialValue = 1, allocationSize = 1)
// Table name이 정해지고 sequence와 generator 설정
public class MemberEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_b201818064_seq_gen")
    // Oracle : GenerationType.SEQUENCE, Mysql : GenerationType.IDENTITY
    private Long seq;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String pw;
}

