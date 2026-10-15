package com.learning.aopIntroductionDemo.service;

import com.learning.aopIntroductionDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class LoggingDecorator implements StudentService{

    private final StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {
        // LOGGING RELATED LOGIC
        LoggingServiceUtil.logStart("StudentServiceImpl",
                "createStudent");

        studentServiceImpl.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImpl",
                "createStudent");
    }
}
