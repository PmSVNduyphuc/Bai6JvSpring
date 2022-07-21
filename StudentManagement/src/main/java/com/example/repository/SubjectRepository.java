package com.example.repository;

import com.example.dto.SubjectCount;
import com.example.model.TblSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository
        extends JpaRepository<TblSubject, Long> {

    List<TblSubject> findSubjectByName(String name);

    List<TblSubject> findSubjectBySem(Integer sem);

    List<TblSubject> getAllByOrderByNameDesc();

    @Query("SELECT COUNT(s.name) FROM TblSubject s")
    Long getCountByName();

    @Query("SELECT NEW com.example.dto.SubjectCount(s.sem, COUNT(s.name)) FROM TblSubject s GROUP BY s.sem")
    List<SubjectCount> countBySem();
}
