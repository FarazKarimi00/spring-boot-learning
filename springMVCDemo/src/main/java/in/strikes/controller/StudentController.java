package in.strikes.controller;

import in.strikes.entity.Student;
import in.strikes.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    @ResponseBody
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student studentResp = studentService.createStudent(student);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        Student studentResp = studentService.getStudent(id);
        if(studentResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    @ResponseBody
    public  ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAll());
    }
}
