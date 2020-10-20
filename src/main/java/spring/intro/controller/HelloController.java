package spring.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.intro.dto.UserResponseDto;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/dto")
    public UserResponseDto getUser() {
        UserResponseDto dto = new UserResponseDto();
        dto.setName("Bob");
        dto.setSurname("Pupkin");
        dto.setEmail("pupkin@pr.dun");
        return dto;
    }
}
