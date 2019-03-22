package br.pucrs.mase.userservice.api;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PingController {

    @GetMapping("/ping")
    @ResponseBody
    public Publisher<String> handler() {
        return Mono.just("pong");
    }
}
