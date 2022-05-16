package me.janah.studentmanagement.web;

import lombok.AllArgsConstructor;
import me.janah.studentmanagement.entities.Student;
import me.janah.studentmanagement.service.IStudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private IStudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toStudents(){
        return "redirect:/students";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public String index(Model model,
                        @RequestParam(name="page", defaultValue = "0") int page,
                        @RequestParam(name="size", defaultValue = "10") int size,
                        @RequestParam(name="search", defaultValue = "") String search) {
        Page<Student> studentsPages = studentService.findByName(search, PageRequest.of(page, size));
        List<Student> students = studentsPages.getContent();
        model.addAttribute("studentsList", students);
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        model.addAttribute("totalPages", new int[studentsPages.getTotalPages()]);
        model.addAttribute("hasPrev", page - 1 >= 0);
        model.addAttribute("hasNext", page + 1 < studentsPages.getTotalPages());
        model.addAttribute("search", search);
        return "index";
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "add";
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addStudent(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add";
        }
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/students/delete/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public String deleteStudent(@PathVariable(name="id") String id){
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @RequestMapping(value = "/students/edit", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editStudent(@RequestParam(name="id") String id, Model model){
        model.addAttribute("student", studentService.findById(id));
        return "edit";
    }

    @RequestMapping(value = "/students/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editStudent(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        studentService.addStudent(student);
        return "redirect:/students";
    }

    // handle exception
    @ExceptionHandler(Exception.class)
    public String handleException(Model model, Exception e){
        model.addAttribute("error", e.getMessage());
        return "error";
    }
}

