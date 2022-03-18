package com.company.yaqinklinikaadminpage;

import com.company.yaqinklinikaadminpage.repository.AdviceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YaqinKlinikaAdminPageApplicationTests {
    @Autowired
    AdviceRepository adviceRepository;

    @Test
    void contextLoads() {
    }

}
