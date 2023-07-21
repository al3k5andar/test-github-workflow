package com.example.testgithubworkflow.service;

import com.example.testgithubworkflow.domain.Licence;
import com.example.testgithubworkflow.domain.Student;

public interface StudentService {

    Student addLicenseToStudent(Student student, Licence licence);
}
