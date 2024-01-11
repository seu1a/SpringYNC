package me.seula.ync.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup(RegisterForm registerForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!registerForm.getPassword().equals(registerForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordIncorrect",
                    "비밀번호가 일치하지 않습니다");
            return "signup_form";
        }

        userService.create(registerForm.getUsername(), registerForm.getEmail(), registerForm.getPassword());

        return "redirect:/";
    }

}
