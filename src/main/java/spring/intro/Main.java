package spring.intro;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("Maksim", "Perepelkin", "Pepepel@bt.ht"));
        userService.add(new User("Yosup", "Ivanov", "Ivan@bt.ht"));
        userService.add(new User("Afonya", "Dudkin", "Dudka@bt.ht"));

        logger.info("Show all users");
        userService.listUsers().forEach(logger::info);
    }
}
