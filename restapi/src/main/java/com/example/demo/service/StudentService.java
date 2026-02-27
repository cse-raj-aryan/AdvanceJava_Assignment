package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

   
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

   
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

   
    public Student updateStudent(Long id, Student updatedStudent) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setCity(updatedStudent.getCity());
            return studentRepository.save(existingStudent);
        }

        return null; 
    }

  
    public boolean deleteStudent(Long id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        }

        return false;
    }
}