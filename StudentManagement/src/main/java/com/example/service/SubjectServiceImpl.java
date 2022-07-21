package com.example.service;

import com.example.dto.SubjectCount;
import com.example.model.TblSubject;
import com.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<TblSubject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void saveSubject(TblSubject tblSubject) {
        subjectRepository.save(tblSubject);
    }

    @Override
    public void deleteSubject(long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Optional<TblSubject> findSubjectById(long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public TblSubject getOne(long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public List<TblSubject> findSubjectByName(String name) {
        return subjectRepository.findSubjectByName(name);
    }

    @Override
    public List<TblSubject> findSubjectBySem(Integer sem) {
        return subjectRepository.findSubjectBySem(sem);
    }

    @Override
    public List<TblSubject> getAllByOrderByNameDesc() {
        return subjectRepository.getAllByOrderByNameDesc();
    }

    @Override
    public Long getCountByName() {
        return subjectRepository.getCountByName();
    }

    @Override
    public List<SubjectCount> countBySem() {
        return subjectRepository.countBySem();
    }
}
