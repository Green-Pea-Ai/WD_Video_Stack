// s2의 p2
package com.example.demo.repository.s2;

import com.example.demo.entity.s2.RandNumMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RandNumRepository {
    private static final Logger log =
            LoggerFactory.getLogger(RandNumRepository.class);

    public RandNumMessage getRandom() {
        log.info("Repo getRandom");

        return new RandNumMessage();
    }
}
