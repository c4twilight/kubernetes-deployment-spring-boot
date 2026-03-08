package com.kubernetes.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
// Use H2 test profile so this test does not require a running local MySQL instance.
@ActiveProfiles("test")
class BackendDemoAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
