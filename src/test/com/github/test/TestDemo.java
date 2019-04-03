package com.github.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestDemo {
    /**
     * 测试密码生成
     */
    @Test
    public void testBCryptPasswordEncoder() {
        String pwd = new BCryptPasswordEncoder().encode("123");
        System.out.println(pwd);
    }
}