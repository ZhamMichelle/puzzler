package kz.zhami.puzzler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * @author zhamilya on 3/12/24
 */
@Component
public class Son extends Father {
    @PostConstruct
    public void init() {
        System.out.println("Son.");
    }
}
