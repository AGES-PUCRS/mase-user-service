package br.pucrs.ages.mase.user_service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PingController {

    @GetMapping("/ping")
    @ResponseBody
    public Mono<String> handler() {
        return Mono.just("pong");
    }
}
