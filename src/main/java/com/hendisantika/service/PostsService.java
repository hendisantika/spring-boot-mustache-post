package com.hendisantika.service;

import com.hendisantika.domain.post.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mustache-post
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/04/22
 * Time: 12.30
 */
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
}
