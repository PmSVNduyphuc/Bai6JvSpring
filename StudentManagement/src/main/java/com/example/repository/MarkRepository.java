package com.example.repository;

import com.example.model.TblMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@Repository
public interface MarkRepository
        extends JpaRepository<TblMarks, Integer> {

    List<Mark> findByMark(int mark);

//    @Query("SELECT m.mark FROM TblMarks m")
//    long countByMark();
}
