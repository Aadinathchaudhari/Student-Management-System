package edu.cjc.sms_app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms_app.app.model.Student;
import edu.cjc.sms_app.app.servicei.StudentServicei;
import edu.cjc.sms_app.app.serviceimpl.Student_serviceimpl;

@Controller
public class Homecontroller {
	@Autowired
	StudentServicei ssi;
	
    @RequestMapping("/")
	public String prelogin() {
		return "login";
		
	}
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
    	if(username.equals("ADMIN") && password.equals("ADMIN")) {
    		List<Student> Student=ssi.getallStudents();
    		m.addAttribute("data", Student);
    		return "adminscreen";
    	}else {
    		m.addAttribute("msg","Invalid User");
    		return "login";
    	}    	
    }
    @RequestMapping("enroll_student")
    public String savestudent(@ModelAttribute Student s,Model m) {
    	ssi.saveStudent(s);
    	List<Student> student=ssi.getallStudents();
    	m.addAttribute("data", student);
    	return "adminscreen";
    }
    @RequestMapping("/search")
    public String searchStudent(@RequestParam("batchNumber") String batchNumber,Model m) {
    	List<Student>record=ssi.getBatchStudent(batchNumber);
    	if(record.size()>0) {
    		m.addAttribute("data", record);
    		
    	}
    	else {
    		List<Student>List1=ssi.getallStudents();
    		m.addAttribute("data",List1);
    		m.addAttribute("message","No Records are available for the batch '"+batchNumber+"'...!");
    	}
    	
    	return "adminscreen";
		
    }
}
