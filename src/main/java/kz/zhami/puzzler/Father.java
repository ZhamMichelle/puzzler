package kz.zhami.puzzler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * @author zhamilya on 3/12/24
 */
@Component
public class Father {
    @PostConstruct
    private void init() {
        System.out.println("Father.");
    }
}
