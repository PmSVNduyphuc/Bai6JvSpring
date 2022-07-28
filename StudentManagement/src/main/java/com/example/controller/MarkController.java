package com.example.controller;

import com.example.dto.ListMark;
import com.example.model.TblMarks;
import com.example.service.MarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/mark")
public class MarkController {
    @Autowired
    MarkServiceImpl markService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<TblMarks>> listAllMarks() {
        List<TblMarks> list = markService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TblMarks> saveMark(@RequestBody TblMarks marks) {
        markService.saveMarks(marks);
        return ResponseEntity.ok(marks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TblMarks> findById(@PathVariable("id") int id) {
        TblMarks marks = markService.getOne(id);
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TblMarks> updateMark(@PathVariable("id") int id,
                                               @RequestBody TblMarks marks) {
        TblMarks oldMarks = markService.getOne(id);
        if (oldMarks == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldMarks.setMark(marks.getMark());
            oldMarks.setNote(marks.getNote());
            return ResponseEntity.ok(oldMarks);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TblMarks> deleteMark(@PathVariable("id") int id) {
        Optional<TblMarks> marks = markService.findMarksById(id);
        if (marks == null) {
            return ResponseEntity.notFound().build();
        } else {
            markService.deleteMarks(id);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/lsMark", method = RequestMethod.GET)
    public ResponseEntity<ListMark> listMark() {
        List<TblMarks> list = markService.getAll();
        ListMark ls = new ListMark();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }
}
