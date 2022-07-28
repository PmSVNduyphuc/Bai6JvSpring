package com.example.controller;

import com.example.dto.ListSubject;
import com.example.dto.SubjectCount;
import com.example.model.TblSubject;
import com.example.service.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {

    @Autowired
    SubjectServiceImpl subjectService;

    //http://localhost:8080/subject/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<TblSubject>> listAllSubject() {
        List<TblSubject> list = subjectService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //http://localhost:8080/subject/save
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<TblSubject> saveSubject(@RequestBody TblSubject subject) {
        subjectService.saveSubject(subject);
        return ResponseEntity.ok(subject);
    }

    //http://localhost:8080/subject/1
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TblSubject> findById(@PathVariable("id") Long id) {
        TblSubject subject = subjectService.getOne(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    //http://localhost:8080/subject/1
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TblSubject> updateSubject(@PathVariable("id") Long id,
                                                    @RequestBody TblSubject subject) {
        TblSubject oldSubject = subjectService.getOne(id);
        if (oldSubject == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldSubject.setName(subject.getName());
            oldSubject.setDescription(subject.getDescription());
            oldSubject.setSem(subject.getSem());
            oldSubject.setDuration(subject.getDuration());
            subjectService.saveSubject(oldSubject);
            return ResponseEntity.ok(oldSubject);
        }
    }

    //http://localhost:8080/subject/1
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TblSubject> deleteById(@PathVariable("id") Long id) {
        Optional<TblSubject> student = subjectService.findSubjectById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {
            subjectService.deleteSubject(id);
            return ResponseEntity.ok().build();
        }
    }

    //http://localhost:8080/subject/?name=Rino
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TblSubject>> findByName(@RequestParam String name) {
        return new ResponseEntity<>(subjectService.findSubjectByName(name), HttpStatus.OK);
    }

    //http://localhost:8080/subject/sem/3
    @RequestMapping(value = "/sem/{sem}", method = RequestMethod.GET)
    public ResponseEntity<List<TblSubject>> findBySem(@PathVariable("sem") int sem) {
        return new ResponseEntity<>(subjectService.findSubjectBySem(sem), HttpStatus.OK);
    }

    //http://localhost:8080/subject/sort
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public ResponseEntity<List<TblSubject>> listAllSubjectSortByName() {
        List<TblSubject> list = subjectService.getAllByOrderByNameDesc();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }


    //http://localhost:8080/subject/countName
    @RequestMapping(value = "/countName", method = RequestMethod.GET)
    public ResponseEntity<TblSubject> countByName(){
        Long tblSubject = subjectService.getCountByName();
        return new ResponseEntity(tblSubject, HttpStatus.OK);
    }

    //http://localhost:8080/subject/countSem
    @RequestMapping(value = "/countSem", method = RequestMethod.GET)
    public ResponseEntity<List<SubjectCount>> getCountBySem() {
        List<SubjectCount> list = subjectService.countBySem();
        return new ResponseEntity<>(list , HttpStatus.OK);
    }

    @RequestMapping(value = "/lsSubject", method = RequestMethod.GET)
    public ResponseEntity<ListSubject> listClass() {
        List<TblSubject> list = subjectService.getAll();
        ListSubject ls = new ListSubject();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }
}
