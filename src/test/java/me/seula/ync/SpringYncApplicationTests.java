package me.seula.ync;

import me.seula.ync.answer.AnswerEntity;
import me.seula.ync.answer.AnswerRepository;
import me.seula.ync.question.QuestionEntity;
import me.seula.ync.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class SpringYncApplicationTests {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Autowired
    public SpringYncApplicationTests(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Test
    public void Test() {
        QuestionEntity question = new QuestionEntity();
        question.setSubject("테스트");
        question.setContent("테스트입니다.");

        questionRepository.save(question);

        AnswerEntity answer = new AnswerEntity();
        answer.setContent("테스트입니다.");

        answerRepository.save(answer);
    }

}
