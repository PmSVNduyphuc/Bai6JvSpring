package com.example.service;

import com.example.model.TblMarks;

import java.util.List;
import java.util.Optional;

public interface MarkService {

    List<TblMarks> getAll();

    void saveMarks(TblMarks tblMarks);

    void deleteMarks(int id);

    Optional<TblMarks> findMarksById(int id);

    TblMarks getOne(int id);
}
