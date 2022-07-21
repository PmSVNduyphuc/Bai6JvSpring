package com.example.service;

import com.example.dto.SubjectCount;
import com.example.model.TblSubject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<TblSubject> getAll();

    void saveSubject(TblSubject tblSubject);

    void deleteSubject(long id);

    Optional<TblSubject> findSubjectById(long id);

    TblSubject getOne(long id);

    List<TblSubject> findSubjectByName(String name);

    List<TblSubject> findSubjectBySem(Integer sem);

    List<TblSubject> getAllByOrderByNameDesc();

    Long getCountByName();

    List<SubjectCount> countBySem();
}
