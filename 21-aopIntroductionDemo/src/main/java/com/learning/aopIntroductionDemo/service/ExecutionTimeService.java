package com.learning.aopIntroductionDemo.service;

import com.learning.aopIntroductionDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService{

    private final LoggingDecorator loggingDecorator;

    public ExecutionTimeService(LoggingDecorator loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public void createStudent(Student student) {
        long startTime = System.nanoTime();
        loggingDecorator.createStudent(student);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000.0;
        System.out.println("Duration: " + duration);
    }
}
