package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.util.UserInputService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);

        UserInputService InputService =context.getBean(UserInputService.class);

        InputService.getString();


    }
}