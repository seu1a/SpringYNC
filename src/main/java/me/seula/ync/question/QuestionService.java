package me.seula.ync.question;

import lombok.RequiredArgsConstructor;
import me.seula.ync.DataNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<QuestionEntity> getList() {
        return questionRepository.findAll();
    }

    public QuestionEntity getQuestion(Integer id) {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("Question not found");
        }
    }

    public void create(String subject, String content) {
        QuestionEntity question = new QuestionEntity();

        question.setSubject(subject);
        question.setContent(content);
        question.setCreatedAt(LocalDateTime.now());

        questionRepository.save(question);
    }

}
