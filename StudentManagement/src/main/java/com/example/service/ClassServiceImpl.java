package com.example.service;

import com.example.model.TblClass;
import com.example.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<TblClass> getAll() {
        return classRepository.findAll();
    }

    @Override
    public void saveClass(TblClass tblClass) {
        classRepository.save(tblClass);
    }

    @Override
    public void deleteSubject(int id) {
        classRepository.deleteById(id);
    }

    @Override
    public Optional<TblClass> findClassById(int id) {
        return classRepository.findById(id);
    }

    @Override
    public TblClass getOne(int id) {
        return classRepository.findById(id).get();
    }

    @Override
    public List<TblClass> findClassByName(String name) {
        return classRepository.findByName(name);
    }

    @Override
    public Long getCountByName() {
        return classRepository.countByName();
    }
}
