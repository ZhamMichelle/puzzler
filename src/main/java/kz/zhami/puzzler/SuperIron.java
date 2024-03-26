package kz.zhami.puzzler;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhamilya on 3/14/24
 */
@Component
public class SuperIron implements Iron {

    @Override
    public void gettingWarm() {
        System.out.println("I am getting warm.");
    }

//    @PostConstruct
    @Autowired
    public void warmWater(Water water) {
        System.out.println("warm " + water);
    }
}
