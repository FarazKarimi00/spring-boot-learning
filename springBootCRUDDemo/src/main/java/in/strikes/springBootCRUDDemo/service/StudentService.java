package in.strikes.springBootCRUDDemo.service;

import in.strikes.springBootCRUDDemo.entity.Student;
import in.strikes.springBootCRUDDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student createStudent(Student studentReq) {
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    // GET
    public Student getStudent(Long id) {
        // Optional:- value isme ho bhi sakti hai or nahi bhi
        Optional<Student> studentRes = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentRes.isPresent()) {
            return studentRes.get();
        }
        return null;
    }

    // GET ALL
    public List<Student> getAllStudent() {
        List<Student> studentList= studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    // UPDATE
    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setSubject(studentReq.getSubject());

        return studentRepository.save(studentToSave);
    }

    // DELETE
    public boolean deleteStudent(Long id) {
        boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
    }

    // SOFT DELETE
    public boolean deleteStudentSoftly(Long id) {
        // get, delete = 1, save
        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) {
            return false;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);

        return true;
    }
}
