package com.example.first_Api;

import org.springframework.web.bind.annotation.*;       // after domain name in URL rest everything is API endpoint eg./http//:www.hotstar.com/(endPoint)

import java.util.HashMap;
import java.util.Map;
                                               // for single param request---> www.xyz.com/get?q=resNo
                                               // for multiple param request---> www.xyz.com/get?q=resNo&&
@RestController
public class StudentController {

    Map<Integer,Student> db=new HashMap<>();

   @GetMapping("/get")    //this is to map the end point to get the method
    public Student getStudent(@RequestParam("q")  int regNo)
    {
        return db.get(regNo);
    }
    @PostMapping ("/add")          // @PostMapping annotated methods handle the HTTP POST requests matched with given URL
    public String addStudent(@RequestBody Student student)
    {
        db.put(student.getRegNo(),student);
        return "student has been added successfully";
    }
    @GetMapping("/getByPath/{regNo}")
     public Student getStudentUsingPath(@PathVariable("regNo") int regNo)
    {
        return db.get(regNo);
    }
    @PutMapping("/updateAge/{regNo}")
     public String updateAge(@PathVariable("regNo") int regNo,@RequestParam("q") int newAge )
    {
        db.get(regNo).setAge(newAge);
        return "Age has been updated successfully";
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("regNo") int regNo)
    {
        db.remove(regNo);
        return regNo +" has been removed successfully";
    }
    @DeleteMapping("/deleteByPath/{regNo}")
    public String deleteStudentUsingPath(@PathVariable("regNo") int regNo)
    {
        db.remove(regNo);
        return regNo +" has been removed successfully";
    }
    @PutMapping("/update-course-both-rp")  // rp-{Request Param}
    public Student updateCourse(@RequestParam("regNo") int regNo,@RequestParam("course") String course)
    {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }
    @PutMapping("/update-course-both pv/{regNo}/{course}")    // pv-{Path Variable}
    public Student updateCourseUsingPath(@PathVariable("regNo") int regNo,@PathVariable("course") String course)
    {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }
    @PutMapping("/update-course-one-rp-one-pv/{regNo}")
    public Student updateCourseUsingOnePROnePV(@PathVariable("regNo") int regNo,@RequestParam("course") String course)
    {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }
}
