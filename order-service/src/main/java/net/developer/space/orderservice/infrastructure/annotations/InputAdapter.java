package net.developer.space.orderservice.infrastructure.annotations;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;


@Documented
@RestController
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InputAdapter {}
