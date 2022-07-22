package com.example.controller.view.admin;

import com.example.model.TblStudent;
import com.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/admin/list")
    public String showUserList(Model model) {
        List<TblStudent> list = studentService.getAll();
        model.addAttribute("list", list);
        return "listStudent";
    }
}
