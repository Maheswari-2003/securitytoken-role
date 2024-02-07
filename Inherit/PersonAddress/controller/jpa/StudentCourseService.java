package com.example.Inherit.PersonAddress.controller.jpa;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentCourseService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public ResponseEntity<String> enrollStudentInCourse(Long studentId, Long courseId, String studentName, String courseName) {
        Optional<studententity> studentOptional = studentRepository.findById(studentId);
        Optional<courseentity> courseOptional = courseRepository.findById(courseId);

        if (studentOptional.isPresent() && courseOptional.isPresent()) {
            studententity student = studentOptional.get();
            courseentity course = courseOptional.get();

            student.setStudentName(studentName);
            course.setCourseName(courseName);

            student.getCourses().add(course);
            course.getStudents().add(student);

            studentRepository.save(student);
            courseRepository.save(course);

            return ResponseEntity.ok("Enrollment successful");
        } else {
            return ResponseEntity.badRequest().body("Enrollment failed. Student or Course not found");
        }
    }
}
