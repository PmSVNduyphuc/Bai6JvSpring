package com.example.controller;

import com.example.dto.StudentCount;
import com.example.model.TblStudent;
import com.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<TblStudent>> listAll() {
        List<TblStudent> list = studentService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<TblStudent> saveStudent(@RequestBody TblStudent tblStudent) {
        studentService.saveStudent(tblStudent);
        return ResponseEntity.ok(tblStudent);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TblStudent> findById(@PathVariable("id") int id) {
        TblStudent tblStudent = studentService.getOne(id);
        return new ResponseEntity<>(tblStudent, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TblStudent> updateStudent(@PathVariable("id") int id,
                                                    @RequestBody TblStudent tblStudent) {
        TblStudent oldStudent = studentService.getOne(id);
        if (oldStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldStudent.setStudentId(tblStudent.getStudentId());
            oldStudent.setName(tblStudent.getName());
            oldStudent.setAddress(tblStudent.getAddress());
            oldStudent.setPhone(tblStudent.getPhone());
            oldStudent.setEmail(tblStudent.getEmail());
            return ResponseEntity.ok(oldStudent);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TblStudent> deleteStudent(@PathVariable("id") int id) {
        Optional<TblStudent> tblStudent = studentService.findStudentById(id);
        if (tblStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TblStudent>> findByName(@RequestParam String name) {
        return new ResponseEntity<>(studentService.findStudentByName(name), HttpStatus.OK);
    }

//    @RequestMapping(value = "/count", method = RequestMethod.GET)
//    public ResponseEntity<List<StudentCount>> countStudent() {
//        List<StudentCount> list = studentService.countStudent();
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
}
