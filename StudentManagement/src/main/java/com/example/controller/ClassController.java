package com.example.controller;

import com.example.dto.ListClass;
import com.example.dto.ListStudent;
import com.example.model.TblClass;
import com.example.model.TblStudent;
import com.example.service.ClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/class")
public class ClassController {

    @Autowired
    ClassServiceImpl classService;

    //http://localhost:8080/class/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<TblClass>> listAll() {
        List<TblClass> list = classService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //http://localhost:8080/class/save
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<TblClass> saveClass(@RequestBody TblClass tblClass) {
        classService.saveClass(tblClass);
        return ResponseEntity.ok(tblClass);
    }

    //http://localhost:8080/class/1
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TblClass> findById(@PathVariable("id") int id) {
        TblClass tblClass = classService.getOne(id);
        return new ResponseEntity<>(tblClass, HttpStatus.OK);
    }

    //http://localhost:8080/class/1
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TblClass> updateClass(@PathVariable("id") int id,
                                                @RequestBody TblClass tblClass) {
        TblClass oldClass = classService.getOne(id);
        if (oldClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldClass.setName(tblClass.getName());
            oldClass.setNote(tblClass.getNote());
            classService.saveClass(oldClass);
            return ResponseEntity.ok(oldClass);
        }
    }

    //http://localhost:8080/class/1
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TblClass> deleteClass(@PathVariable("id") int id) {
        Optional<TblClass> tblClass = classService.findClassById(id);
        if (tblClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            classService.deleteSubject(id);
            return ResponseEntity.ok().build();
        }
    }

    //http://localhost:8080/class/?name=
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TblClass>> findByName(@RequestParam String name) {
        return new ResponseEntity<>(classService.findClassByName(name), HttpStatus.OK);
    }

    //http://localhost:8080/class/count
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity<TblClass> countById(){
        Long tblClass = classService.getCountByName();
        return new ResponseEntity(tblClass, HttpStatus.OK);
    }

    @RequestMapping(value = "/lsClass", method = RequestMethod.GET)
    public ResponseEntity<ListClass> listClass() {
        List<TblClass> list = classService.getAll();
        ListClass ls = new ListClass();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }
}
