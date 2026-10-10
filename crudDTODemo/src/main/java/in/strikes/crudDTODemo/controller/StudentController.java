package in.strikes.crudDTODemo.controller;

import in.strikes.crudDTODemo.dto.CreateStudentRequestDTO;
import in.strikes.crudDTODemo.dto.CreateStudentResponseDTO;
import in.strikes.crudDTODemo.dto.UpdateStudentRequestDTO;
import in.strikes.crudDTODemo.dto.UpdateStudentResponseDTO;
import in.strikes.crudDTODemo.entity.Student;
import in.strikes.crudDTODemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> create(
            @Valid @RequestBody CreateStudentRequestDTO studentRequestDTO) {

        CreateStudentResponseDTO studentResp =
                studentService.createStudent(studentRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentResp);
    }

    // GET
    @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDTO> get(@RequestParam Long id) {
        CreateStudentResponseDTO studentResp = studentService.getStudent(id);
        if(studentResp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studentResp);
    }

    // GET ALL
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDTO>> getAll() {
        List<CreateStudentResponseDTO> studentList = studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDTO> update
    (@RequestParam Long id, @Valid @RequestBody UpdateStudentRequestDTO studentReq) {

        UpdateStudentResponseDTO studentResp =
                studentService.updateStudent(id, studentReq);

        if(studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    // DELETE
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted for id: " + id);
    }

    // SOFT DELETE
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> softDelete(@RequestParam Long id) {
        boolean isDeleted = studentService.deleteStudentSoftly(id);
        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted softly for id: " + id);
    }
}
