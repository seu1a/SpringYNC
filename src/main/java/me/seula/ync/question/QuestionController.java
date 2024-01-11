package me.seula.ync.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.seula.ync.answer.AnswerForm;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

//    @GetMapping("/list")
//    public String list(Model model) {
//        List<QuestionEntity> questionList = questionService.getList();
//        model.addAttribute("questionList", questionList);
//        return "question_list";
//    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        QuestionEntity question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    /*
        BidingResult = Validation의 결과
    */
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<QuestionEntity> paging = questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    };

}
