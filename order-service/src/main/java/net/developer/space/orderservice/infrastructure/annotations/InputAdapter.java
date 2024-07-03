package net.developer.space.orderservice.infrastructure.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
@Documented
public @interface InputAdapter {

    @AliasFor(annotation = RestController.class)
    String value() default "";
}
