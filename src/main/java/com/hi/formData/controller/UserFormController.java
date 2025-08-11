package com.hi.formData.controller;

import com.hi.formData.dto.Day;
import com.hi.formData.dto.FormDto;
import com.hi.formData.dto.Langauge;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserFormController {
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("dto", new FormDto());
        return "form";
    }

    @PostMapping("/form")
    public String form(@ModelAttribute("dto") FormDto dto, Model model) {
        for (String x : dto.getHobbies()) {
            System.out.println(x);
        }
        dto.setDay(Day.MON);
        model.addAttribute("dto", dto);
        return "/result";
    }

    // Enum Type 데이터를 @ModelAttribute로 보내기
    @ModelAttribute("language")
    private Langauge[] langauges() {
        return Langauge.values();
    }

    // 메서드에 정의도니 @ModelAttribute는
    // form html 호출할 때 같이 데이터를 보낼 때
    @ModelAttribute("hobbies")
    private Map<String, String> favorite() {
        Map<String, String> map = new HashMap<>();
        map.put("movie", "영화보기");
        map.put("music", "음악듣기");
        map.put("running", "런닝하기");
        map.put("game", "게임하기");
        return map;
    }

    // 테스트 용도

    @GetMapping("getName")
    public String getName(@RequestParam("name") String name) {
        System.out.println("get name : " + name);
        return "redirect:/form";
    }

    @PostMapping("getName")
    public String postName(FormDto dto) {
        System.out.println("post name : " + dto.getName());
        return "redirect:/form";
    }

    @GetMapping("/form2")
    // th:field가 있는 GetMapping은 껍데기 Dto를 보내야한다
    public String showForm2(Model model) {
        model.addAttribute("dto", new FormDto());
        return "form2";
    }

    @PostMapping("/form2")
    public String postForm2(@ModelAttribute("dto") FormDto dto) {
        System.out.println(dto.getName());
        System.out.println(dto.getAge());
        return null;
    }
}
