package com.hendisantika.domain.user;

import lombok.Getter;

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
public enum Role {

    GUEST("ROLE_GUEST", "Guest"),
    USER("ROLE_USER", "General User");

    private final String key;
    private final String title;

    Role(String key, String title) {
        this.key = key;
        this.title = title;
    }

    // Manual getter for compatibility
    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }
}
