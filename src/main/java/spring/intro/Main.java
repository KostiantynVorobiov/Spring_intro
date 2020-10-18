package spring.intro;

import org.apache.log4j.Logger;
import spring.intro.model.User;
import spring.intro.service.UserService;
import spring.intro.service.impl.UserServiceImpl;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.add(new User("Maksim", "Perepelkin", "Pepepel@bt.ht"));
        userService.add(new User("Yosup", "Ivanov", "Ivan@bt.ht"));
        userService.add(new User("Afonya", "Dudkin", "Dudka@bt.ht"));

        logger.info("Show all users");
        userService.listUsers().forEach(System.out::println);
    }
}
