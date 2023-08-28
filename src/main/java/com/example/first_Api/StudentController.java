package com.example.first_Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;       // after domain name in URL rest everything is API endpoint eg./http//:www.hotstar.com/(endPoint)

import java.util.HashMap;
import java.util.Map;
                                               // for single param request---> www.xyz.com/get?q=resNo
                                               // for multiple param request---> www.xyz.com/get?q=resNo&&
@RestController
public class StudentController {

@Autowired
studentService service;

   @GetMapping("/get")    //this is to map the end point to get the method
    public Student getStudent(@RequestParam("q")  int regNo)
   {
       return service.getStudent(regNo);
   }


    @PostMapping ("/add")   // @PostMapping annotated methods handle the HTTP POST requests matched with given URL
    public String addStudent(@RequestBody Student student)
    {
        return service.addStudent(student);
    }


    @GetMapping("/getByPath/{regNo}")   // by path variable
     public Student getStudentUsingPath(@PathVariable("regNo") int regNo)
    {
        return service.getStudentUsingPathVariable(regNo);
    }


    @PutMapping("/updateAge/{regNo}")
     public String updateAge(@PathVariable("regNo") int regNo,@RequestParam("q") int newAge )
    {
        return service.updateAge(regNo,newAge);
    }


    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("regNo") int regNo)
    {
        return service.deleteStudent(regNo);
    }


    @DeleteMapping("/deleteByPath/{regNo}")
    public String deleteStudentUsingPath(@PathVariable("regNo") int regNo)
    {
       return service.deleteStudentUsingPathVariable(regNo);
    }


    @PutMapping("/update-course-both-rp")  // rp-{Request Param}
    public Student updateCourse(@RequestParam("regNo") int regNo,@RequestParam("course") String course)
    {
       return service.updateCourse(regNo,course);
    }


    @PutMapping("/update-course-both pv/{regNo}/{course}")    // pv-{Path Variable}
    public Student updateCourseUsingPath(@PathVariable("regNo") int regNo,@PathVariable("course") String course)
    {
       return service.updateCourseUsingPathVariable(regNo,course);
    }
    @PutMapping("/update-course-one-rp-one-pv/{regNo}")
    public Student updateCourseUsingOnePROnePV(@PathVariable("regNo") int regNo,@RequestParam("course") String course)
    {
       return service.updateCourseUsingOnePROnePV(regNo,course);
    }
}
