package in.strikes.crudDTODemo.service;

import in.strikes.crudDTODemo.dto.CreateStudentRequestDTO;
import in.strikes.crudDTODemo.dto.CreateStudentResponseDTO;
import in.strikes.crudDTODemo.dto.UpdateStudentRequestDTO;
import in.strikes.crudDTODemo.dto.UpdateStudentResponseDTO;
import in.strikes.crudDTODemo.entity.Student;
import in.strikes.crudDTODemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public CreateStudentResponseDTO createStudent
    (CreateStudentRequestDTO studentRequestDTO) {
        Student student = mapToEntity(studentRequestDTO);

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        Student studentResp = studentRepository.save(student);
        return mapToDTO(studentResp);
    }

    // GET
    public CreateStudentResponseDTO getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResp.isPresent()) {
            return mapToDTO(studentResp.get());
        }
        return null;
    }

    // GET ALL
    public List<CreateStudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList.stream()
                .map(this::mapToDTO)
                .toList();
    }

    // UPDATE
    public UpdateStudentResponseDTO updateStudent
    (Long id, UpdateStudentRequestDTO studentReq) {

        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);
        return mapToUpdateDTO(savedStudent);
    }

    //DELETE
    public boolean deleteStudent(Long id) {
        boolean isStudent = studentRepository.existsById(id);
        if(isStudent) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // SOFT DELETE
    public boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) {
            return false;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }

    // Mapping methods
    private Student mapToEntity(CreateStudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setEmail(studentRequestDTO.getEmail());
        student.setRollNo(studentRequestDTO.getRollNo());
        student.setSubject(studentRequestDTO.getSubject());
        student.setDeleted(false);
        return student;
    }
    private CreateStudentResponseDTO mapToDTO(Student student) {
        CreateStudentResponseDTO responseDTO = new CreateStudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setMessage("Student saved successfully");
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        return responseDTO;
    }
    private UpdateStudentResponseDTO mapToUpdateDTO(Student student) {
        UpdateStudentResponseDTO responseDTO = new UpdateStudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        responseDTO.setMessage("Student updated successfully");
        return responseDTO;
    }
}
