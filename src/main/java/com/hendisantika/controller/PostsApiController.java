package com.hendisantika.controller;

import com.hendisantika.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mustache-post
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/04/22
 * Time: 12.38
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
}
