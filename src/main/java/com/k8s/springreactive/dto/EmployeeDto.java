package com.k8s.springreactive.dto;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.k8s.springreactive.dao.EmployeeDao;

import reactor.core.publisher.Flux;

@Component
@Slf4j
public class EmployeeDto {

    public List<EmployeeDao> getEmployee() {
        log.info("Fetching employee details ...");
        return IntStream.range(1, 10)
                .peek(EmployeeDto::threadSleep)
                .mapToObj(e -> new EmployeeDao(e, "Employee " + e))
                .collect(Collectors.toList());
    }

    public Flux<EmployeeDao> streamEmployeeFlux() {
        log.info("Fetching employee details every seconds ...");
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> new EmployeeDao(e, "Employee " + e));
    }
    private static void threadSleep(int i) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
