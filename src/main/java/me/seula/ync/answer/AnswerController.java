package me.seula.ync.answer;

import lombok.RequiredArgsConstructor;
import me.seula.ync.question.QuestionEntity;
import me.seula.ync.question.QuestionService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;

    @PostMapping("/answer/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id) {
        QuestionEntity question = questionService.getQuestion(id);
        return String.format("redirect:/question/detail/%s", id);
    }

}
