package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BookService;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        BookService service = context.getBean(BookService.class);
        service.addBook("Ion", " Liviu", "Rebreanu");
        service.deleteBook(1);
        service.addBook("We better not meet again, causesjwbxnjnahbjabhsdsjbahjdxhsajdnjasdbhasjdsj", " Liviu", "Rebreanu");
    }
}
