package com.example.Inherit.PersonAddress.controller.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/enroll")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping
    public ResponseEntity<String> enrollStudentInCourse(@RequestBody Map<String, Object> payload) {
        Long studentId = Long.valueOf(payload.get("studentId").toString());
        Long courseId = Long.valueOf(payload.get("courseId").toString());
        String studentName = (String) payload.get("studentName");
        String courseName = (String) payload.get("courseName");

        return studentCourseService.enrollStudentInCourse(studentId, courseId, studentName, courseName);
    }
}
