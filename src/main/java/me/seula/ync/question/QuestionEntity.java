package me.seula.ync.question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import me.seula.ync.answer.AnswerEntity;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    // AnswerEntity의 question 속성에서 id를 가지고 있는 엔티티를 가져옴
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<AnswerEntity> answer;

}
