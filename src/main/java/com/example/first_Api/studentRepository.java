package com.example.first_Api;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class studentRepository {
    Map<Integer,Student> db=new HashMap<>();

    public Student getStudent(int regNo)
    {
        return db.get(regNo);
    }
    public void addStudent(Student student)
    {
        db.put(student.getRegNo(),student);
    }

    public Student addStudenByPathVariable(int regNo) {
        return db.get(regNo);
    }

    public void uodateAge(int regNo, int newAge) {
        db.get(regNo).setAge(newAge);
    }

    public void deleteStudent(int regNo) {
        db.remove(regNo);
    }

    public void deleteStudentUsingPathVariable(int regNo) {
        db.remove(regNo);
    }

    public Student updateCourse(int regNo, String course) {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    public Student updateCourseUsingPathVariable(int regNo, String course) {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    public Student updateCourseUsingOnePROnePV(int regNo, String course) {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }
}
