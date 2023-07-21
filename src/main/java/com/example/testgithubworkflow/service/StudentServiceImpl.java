package com.example.testgithubworkflow.service;

import com.example.testgithubworkflow.domain.Licence;
import com.example.testgithubworkflow.domain.Student;
import com.example.testgithubworkflow.exception.StudentException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    public static final Map<Student, List<Licence>> licenses= new HashMap<>();
    @Override
    public Student addLicenseToStudent(Student student, Licence licence) {
        if(student.getAge() >= 18) {
            student.getLicences().add(licence);
            licenses.put(student, student.getLicences());
            return student;
        }
        throw new StudentException("Student is too young!");
    }
}
