package com.hendisantika.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mustache-post
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/04/22
 * Time: 12.40
 */
@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final Environment env;

}
