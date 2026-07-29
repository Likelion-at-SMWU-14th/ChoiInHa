package com.likelion.seminar.student.controller;

import com.likelion.seminar.student.dto.StudentDTO;
import com.likelion.seminar.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // 학생 등록
    @PostMapping
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
    }

    // 전체 학생 목록 조회
    @GetMapping
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
    }

    // 특정 학생 정보 조회
    @GetMapping("/{studentId}")
    public StudentDTO getStudent(@PathVariable("studentId") String studentId) {
        return studentService.getStudentById(studentId);
    }

    // 특정 학생 정보 수정
    @PutMapping("/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") String studentId,
            @RequestBody StudentDTO studentDTO
    ) {
        studentService.updateStudent(studentId, studentDTO);
    }

    // 특정 학생 정보 삭제
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") String studentId) {
        studentService.deleteStudent(studentId);
    }
}
