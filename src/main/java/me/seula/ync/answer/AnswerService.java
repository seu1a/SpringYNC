package me.seula.ync.answer;

import lombok.RequiredArgsConstructor;
import me.seula.ync.question.QuestionEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(QuestionEntity question, String content) {
        AnswerEntity answer = new AnswerEntity();
        answer.setContent(content);
        answer.setCreatedAt(LocalDateTime.now());
        answer.setQuestion(question);
        answerRepository.save(answer);
    }

}
