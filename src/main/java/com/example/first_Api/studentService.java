package com.example.first_Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {
    @Autowired // for creating about of class
    studentRepository repository;


    public Student getStudent(int regNo)
    {
        Student student=repository.getStudent(regNo);
        return student;
    }
    public String addStudent(Student student)
    {
        repository.addStudent(student);
        return "student has been added successfully";
    }

    public Student getStudentUsingPathVariable(int regNo) {
       return repository.addStudenByPathVariable(regNo);
    }

    public String updateAge(int regNo, int newAge) {
        repository.uodateAge(regNo,newAge);
        return "Age has been updated successfully";
    }

    public String deleteStudent(int regNo) {
        repository.deleteStudent(regNo);
        return regNo +" has been removed successfully";
    }

    public String deleteStudentUsingPathVariable(int regNo) {
        repository.deleteStudentUsingPathVariable(regNo);
        return regNo +" has been removed successfully";
    }

    public Student updateCourse(int regNo, String course) {
        return repository.updateCourse(regNo,course);
    }

    public Student updateCourseUsingPathVariable(int regNo, String course) {
        return repository.updateCourseusingPathVariable(regNo,course);

    }

    public Student updateCourseUsingOnePROnePV(int regNo, String course) {
        return repository.updateCourseUsingOnePROnePV(regNo,course);
    }
}
