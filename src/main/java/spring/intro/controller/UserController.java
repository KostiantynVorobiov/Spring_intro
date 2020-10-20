package spring.intro.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.config.AppConfig;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(AppConfig.class);
    UserService userService = context.getBean(UserService.class);

    @GetMapping("/inject")
    public void inject() {
        logger.info("Trying to inject users");
        userService.add(new User("Maksim", "Perepelkin", "Pepepel@bt.ht"));
        userService.add(new User("Yosup", "Ivanov", "Ivan@bt.ht"));
        userService.add(new User("Afonya", "Dudkin", "Dudka@bt.ht"));
        userService.add(new User("Panas", "Onic", "Panasocic@bt.ht"));
        logger.info("Inject users are successfully");
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        logger.info("Trying to find user by id: " + id + " from DB in UserController");
        User user = userService.getById(id);
        return convertUserToUserDto(user);
    }

    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers() {
        logger.info("Trying to get all users from DB in UserController");
        return userService.listUsers().stream()
                .map(user -> convertUserToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserResponseDto convertUserToUserDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setSurname(user.getSurname());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
