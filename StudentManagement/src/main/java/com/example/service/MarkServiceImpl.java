package com.example.service;

import com.example.model.TblMarks;
import com.example.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Override
    public List<TblMarks> getAll() {
        return markRepository.findAll();
    }

    @Override
    public void saveMarks(TblMarks tblMarks) {
        markRepository.save(tblMarks);
    }

    @Override
    public void deleteMarks(int id) {
        markRepository.deleteById(id);
    }

    @Override
    public Optional<TblMarks> findMarksById(int id) {
        return markRepository.findById(id);
    }

    @Override
    public TblMarks getOne(int id) {
        return markRepository.findById(id).get();
    }
}
