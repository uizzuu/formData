package com.hi.formData.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private String name;
    private int age;
    private boolean trueOrFalse;
    private List<String> hobbies; // 다중 체크박스 용도
    private String language;
    // 요일을 담는 Enum 타입 변수
    private Day day;
}
