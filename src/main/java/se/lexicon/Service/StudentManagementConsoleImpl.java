package se.lexicon.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement{

    private StudentDao studentDao;

    private UserInputService userInputService;

    //ConstructorInjector
    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Creating student id");
        int id = userInputService.getInt();
        System.out.println("Creating student name");
        String name = userInputService.getString();
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        return student;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student student = studentDao.find(id);
        studentDao.delete(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        System.out.println("Edit student name");
        String name = userInputService.getString();
        student.setName(name);
        return studentDao.save(student);
    }
}
