package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Marks")
public class TblMarks {
    private int id;
    private Integer idSv;
    private Long idSubject;
    private Integer mark;
    private String note;

    private TblStudent tblStudentByIdSv;
    private TblSubject tblSubjectByIdSubject;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "id_sv")
//    public Integer getIdSv() {
//        return idSv;
//    }

    public void setIdSv(Integer idSv) {
        this.idSv = idSv;
    }

//    @Basic
//    @Column(name = "id_subject")
//    public Long getIdSubject() {
//        return idSubject;
//    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "mark")
    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblMarks marks = (TblMarks) o;
        return id == marks.id && Objects.equals(idSv, marks.idSv) && Objects.equals(idSubject, marks.idSubject) && Objects.equals(mark, marks.mark) && Objects.equals(note, marks.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSv, idSubject, mark, note);
    }

    @ManyToOne
    //@JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "id_sv", referencedColumnName = "id")
    public TblStudent getTblStudentByIdSv() {
        return tblStudentByIdSv;
    }

    public void setTblStudentByIdSv(TblStudent tblStudentByIdSv) {
        this.tblStudentByIdSv = tblStudentByIdSv;
    }

    @ManyToOne
    @JsonIgnoreProperties
    @JoinColumn(name = "id_subject", referencedColumnName = "id")
    public TblSubject getTblSubjectByIdSubject() {
        return tblSubjectByIdSubject;
    }

    public void setTblSubjectByIdSubject(TblSubject tblSubjectByIdSubject) {
        this.tblSubjectByIdSubject = tblSubjectByIdSubject;
    }
}
