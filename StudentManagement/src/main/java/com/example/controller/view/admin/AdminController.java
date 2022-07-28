package com.example.controller.view.admin;

import com.example.model.TblStudent;
import com.example.service.ClassServiceImpl;
import com.example.service.MarkServiceImpl;
import com.example.service.StudentServiceImpl;
import com.example.service.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    ClassServiceImpl classService;

    @Autowired
    SubjectServiceImpl subjectService;

    @Autowired
    MarkServiceImpl markService;

    @GetMapping("/admin/listStudent")
    public String showUserList(Model model) {
        model.addAttribute("list", studentService.getAll());
        return "listStudent";
    }

    @GetMapping("/admin/listClass")
    public String showClassList(Model model) {
        model.addAttribute("listClass", classService.getAll());
        return "list-class";
    }

    @GetMapping("/admin/student")
    public String showStudent(Model model) {
        model.addAttribute("listStudent", studentService.getAll());
        return "student";
    }

    @GetMapping("/admin/listSubject")
    public String showSubjectList(Model model) {
        model.addAttribute("listSubject", subjectService.getAll());
        return "list-subject";
    }

    @GetMapping("/admin/listMarks")
    public String showMarkList(Model model) {
        model.addAttribute("listMark", markService.getAll());
        return "list-mark";
    }

    @RequestMapping("/admin/signup")
    public String showSignUpForm(TblStudent student) {
        return "add-student";
    }

    @PostMapping("/addStudent")
    public String addStudent(@Valid TblStudent student,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }
        studentService.saveStudent(student);
        return "redirect:/listStudent";
    }

    @GetMapping("/admin/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,
                                 Model model) {
        TblStudent student = studentService.findStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: " + id));
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/admin/update/{id}")
    public String updateStudent(@PathVariable("id") int id,
                                @Valid TblStudent student,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }
        studentService.saveStudent(student);
        return "redirect:/listStudent";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id,
                                Model model) {
        TblStudent student = studentService.findStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: "+ id));
        studentService.deleteStudent(id);
        return "redirect:/listStudent";
    }


}
