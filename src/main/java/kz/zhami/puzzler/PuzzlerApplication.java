package kz.zhami.puzzler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class PuzzlerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(PuzzlerApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
