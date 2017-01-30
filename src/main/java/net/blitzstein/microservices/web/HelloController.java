package net.blitzstein.microservices.web;

import net.blitzstein.microservices.domain.Greeting;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jared on 1/25/17.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Greeting hello() {
        return new Greeting("Hello from heroku!!!");
    }

}
