package com.example.repository;

import com.example.dto.StudentCount;
import com.example.model.TblStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository
        extends JpaRepository<TblStudent, Integer> {
    List<TblStudent> findByName(String name);

//    @Query("SELECT NEW com.example.dto.StudentCount(c.name, COUNT(s.id)) " +
//            "FROM TblStudent s INNER JOIN TblClass c " +
//            "ON s.classId = c.id " +
//            "GROUP BY c.name")
//    List<StudentCount> countStudentW();
}
