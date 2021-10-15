package com.example.demoreflexive.controllers;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class Test {
    
    @GetMapping("/test")
    public Mono<Long> test() throws InterruptedException{
        long a = Math.round(Math.random()*1000);
        long b = Math.round(Math.random()*1000);
        Mono<Long> mod = Mono.just((long)0);
        if(a>b && a!=0 && b!=0){
            mod = Mono.just((long)a%b);
        }
        if(b>a && a!=0 && b!=0){
            mod = Mono.just((long)b%a);
        }
        long timeout = (long)Math.random()*1000;
        TimeUnit.MILLISECONDS.sleep(timeout);
        return mod;
    }
}
