package com.example.repository;

import com.example.model.TblClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository
        extends JpaRepository<TblClass, Integer> {
    List<TblClass> findByName(String name);

    @Query("SELECT COUNT(c.name) FROM TblClass c")
    long countByName();
}
