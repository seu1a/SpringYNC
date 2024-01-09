package me.seula.ync;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    /*
        Question 엔티티와 Answer 엔티티가
        연결되었다고 할 수 있지만
        실제론 DB에서 외래키 관계가 형성됨
        (QuestionEntity의 PK(id)가 들어옴)
    */
    // 하나의 질문에 여러 개의 답변이 달릴 수 있다
    @ManyToOne
    private QuestionEntity question;

}
