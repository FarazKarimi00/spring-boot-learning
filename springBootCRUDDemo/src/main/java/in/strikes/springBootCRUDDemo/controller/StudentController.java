package in.strikes.springBootCRUDDemo.controller;

import in.strikes.springBootCRUDDemo.entity.Student;
import in.strikes.springBootCRUDDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    // Read one
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
        Student studentRes = studentService.getStudent(id);

        if(studentRes == null) {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body(null);

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentRes);
    }

    // Read all
    @GetMapping("getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }

    // Update
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,
                                                 @RequestBody Student studentReq) {
        Student studentResp = studentService.updateStudent(id, studentReq);
        if(studentResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }

    // Delete
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted for id: " + id);
    }

    // Soft delete
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id) {
        boolean isDeleted = studentService.deleteStudentSoftly(id);
        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted for id: " + id);
    }
}
