package com.example.service;

import com.example.dto.StudentCount;
import com.example.model.TblStudent;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<TblStudent> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(TblStudent tblStudent) {
        studentRepository.save(tblStudent);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<TblStudent> findStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public TblStudent getOne(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<TblStudent> findStudentByName(String name) {
        return studentRepository.findByName(name);
    }

//    @Override
//    public List<StudentCount> countStudent() {
//        return studentRepository.countStudentW();
//    }
}
