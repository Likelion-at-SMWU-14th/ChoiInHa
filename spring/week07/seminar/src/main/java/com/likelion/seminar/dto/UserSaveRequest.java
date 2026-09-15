package com.likelion.seminar.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class UserSaveRequest {

    @NotBlank(message = "이름 필수")
    @Size(max = 20, message = "이름 20자 이하")
    private String name;

    @NotBlank(message = "이메일 필수")
    @Email(message = "올바른 이메일 형식")
    private String email;

    @NotBlank(message = "비밀번 필수")
    @Size(min = 8, max = 20, message = "비밀번호 8자 이상 20자 이하")
    private String password;

    @NotNull(message = "나이 필수")
    @Min(value = 0, message = "나이 0 이상")
    private Integer age;

}
