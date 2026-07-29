package com.likelion.seminar.student.service;

import com.likelion.seminar.student.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final List<StudentDTO> studentDTOList;

    public void createStudent(StudentDTO studentDTO) {
        this.studentDTOList.add(studentDTO);
    }

    public List<StudentDTO> getStudents() {
        return this.studentDTOList;
    }

    public StudentDTO getStudentById(String studentId) {
        return this.studentDTOList.stream()
                .filter(studentDTO -> studentId.equals(studentDTO.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("학생을 찾을 수 없습니다: " + studentId));
    }

    public void updateStudent(String studentId, StudentDTO studentDTO) {
        StudentDTO targetStudent = getStudentById(studentId);

        if (studentDTO.getStudentId() != null) {
            targetStudent.setStudentId(studentDTO.getStudentId());
        }
        if (studentDTO.getName() != null) {
            targetStudent.setName(studentDTO.getName());
        }
        if (studentDTO.getDateOfBirth() != null) {
            targetStudent.setDateOfBirth(studentDTO.getDateOfBirth());
        }
    }

    public void deleteStudent(String studentId) {
        StudentDTO targetStudent = getStudentById(studentId);
        this.studentDTOList.remove(targetStudent);
    }
}
