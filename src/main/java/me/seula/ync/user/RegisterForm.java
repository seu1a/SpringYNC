package me.seula.ync.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {

    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자명은 필수입니다")
    private String username;

    @NotEmpty(message = "비밀번호는 필수입니다")
    private String password;

    @NotEmpty(message = "비밀번호를 확인해주세요")
    private String password2;

    @NotEmpty(message = "이메일은 필수입니다")
    @Email // 속성이 이메일 형식과 매칭되는지 확인
    private String email;

}
