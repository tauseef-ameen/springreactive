package com.baeldung.springreactive.springreactive.dto;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.baeldung.springreactive.springreactive.dao.EmployeeDao;

import reactor.core.publisher.Flux;

@Component
public class EmployeeDto {

    public List<EmployeeDao> getEmployee() {
        return IntStream.range(1, 60)
                .peek(EmployeeDto::threadSleep)
                .mapToObj(e -> new EmployeeDao(e, "Employee " + e))
                .collect(Collectors.toList());
    }

    public Flux<EmployeeDao> streamEmployeeFlux() {
        return Flux.range(1,60)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> new EmployeeDao(e, "Employee " + e));
    }
    private static void threadSleep(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
