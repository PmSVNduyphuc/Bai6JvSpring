package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Tblstudent")
public class TblStudent {
    private int id;
    @NotBlank(message = "Student Id is mandatory")
    private String studentId;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Integer classId;
    private Collection<TblMarks> marksById;
    private TblClass tblClassByClassId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_id")

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @Basic
//    @Column(name = "class_id")
//    public Integer getClassId() {
//        return classId;
//    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblStudent that = (TblStudent) o;
        return id == that.id && Objects.equals(studentId, that.studentId) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, name, address, phone, email, classId);
    }

    @OneToMany(mappedBy = "tblStudentByIdSv")
    public Collection<TblMarks> getMarksById() {
        return marksById;
    }

    public void setMarksById(Collection<TblMarks> marksById) {
        this.marksById = marksById;
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    public TblClass getTblClassByClassId() {
        return tblClassByClassId;
    }

    public void setTblClassByClassId(TblClass tblClassByClassId) {
        this.tblClassByClassId = tblClassByClassId;
    }
}
