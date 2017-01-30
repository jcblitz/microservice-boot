package net.blitzstein.microservices.web;

import net.blitzstein.microservices.LearningApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by jared on 1/25/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LearningApplication.class)
@WebAppConfiguration
public class HelloControllerTest {
    @Test
    public void hello() throws Exception {

    }

}