package io.esev.ms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by ESEV on 2/09/18.
 */

@RestController
@RequestMapping("/api")
public class APIController {

    private static final Logger log = LoggerFactory.getLogger(APIController.class);

    @GetMapping("/key/{type}")
    public String getKey(@PathVariable("type") String type){

        log.info("APIController.getKey({})", type);

        return UUID.randomUUID().toString();
    }

}
