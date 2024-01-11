package me.seula.ync;

import me.seula.ync.answer.AnswerEntity;
import me.seula.ync.answer.AnswerRepository;
import me.seula.ync.question.QuestionEntity;
import me.seula.ync.question.QuestionRepository;
import me.seula.ync.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class SpringYncApplicationTests {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    @Autowired
    public SpringYncApplicationTests(QuestionRepository questionRepository, AnswerRepository answerRepository, QuestionService questionService) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.questionService = questionService;
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

    @Test
    public void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다 : [%03d]", i);
            String content = "내용 : 무";

            questionService.create(subject, content);
        }
    }

}
