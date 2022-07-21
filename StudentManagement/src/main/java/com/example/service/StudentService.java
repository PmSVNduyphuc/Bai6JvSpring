package com.example.service;

import com.example.dto.StudentCount;
import com.example.model.TblStudent;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<TblStudent> getAll();

    void saveStudent(TblStudent tblStudent);

    void deleteStudent(int id);

    Optional<TblStudent> findStudentById(int id);

    TblStudent getOne(int id);

    List<TblStudent> findStudentByName(String name);

//    List<StudentCount> countStudent();
}
