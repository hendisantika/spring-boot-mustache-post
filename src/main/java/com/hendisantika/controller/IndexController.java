package com.hendisantika.controller;

import com.hendisantika.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mustache-post
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/04/22
 * Time: 12.36
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
}
