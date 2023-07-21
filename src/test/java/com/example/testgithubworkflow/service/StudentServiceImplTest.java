package com.example.testgithubworkflow.service;

import com.example.testgithubworkflow.domain.Licence;
import com.example.testgithubworkflow.domain.Student;
import com.example.testgithubworkflow.exception.StudentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Struct;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    private Student student;
    private Student olderStudent;
    private Licence licence;
    private StudentService service = new StudentServiceImpl();

    @BeforeEach
    void setUp() {
        licence = Licence.builder()
                .name("Driving License")
                .category("B")
                .build();

        student = Student.builder()
                .firstName("Mark")
                .lastName("Smith")
                .age(15)
                .licences(new ArrayList<>())
                .build();

        olderStudent = Student.builder()
                .firstName("Mark")
                .lastName("Smith")
                .age(20)
                .licences(new ArrayList<>())
                .build();

    }

    @Test
    void addLicenceToStudent_WhenStudentIsUnderAge() {
        final String expectedMessage = "Student is too young!";

        Exception result = Assertions.assertThrows(StudentException.class, () -> {
            service.addLicenseToStudent(student, licence);
        });

        Assertions.assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    void addLicenceToStudent() {

        service.addLicenseToStudent(olderStudent, licence);

        Assertions.assertEquals(1, StudentServiceImpl.licenses.get(olderStudent).size());
    }
}