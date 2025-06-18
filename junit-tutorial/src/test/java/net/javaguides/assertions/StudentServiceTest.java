package net.javaguides.assertions;

import net.javaguides.Student;
import net.javaguides.StudentService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentTest(){
        StudentService studentService=new StudentService();
        Student student = new Student(1,"Ramesh");

        List<Student> listOfStudents = studentService.getStudents();
//        studentService.addStudent(student);
        boolean actualResult=listOfStudents.isEmpty();

//        assertTrue(actualResult);
//        assertTrue(()->actualResult);
//        assertTrue(actualResult,"List of students is empty!");
//        assertTrue(()->actualResult,"List of students is empty!");
        assertTrue(actualResult,()->"List of students is empty!");
    }

}