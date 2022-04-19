package com.hendisantika.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mustache-post
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/04/22
 * Time: 12.21
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "Guest"),
    USER("ROLE_USER", "General User");

    private final String key;
    private final String title;
}
