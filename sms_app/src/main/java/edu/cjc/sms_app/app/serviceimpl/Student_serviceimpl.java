package edu.cjc.sms_app.app.serviceimpl;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sms_app.app.model.Student;
import edu.cjc.sms_app.app.repository.StudentRepository;
import edu.cjc.sms_app.app.servicei.StudentServicei;
@Service
public class Student_serviceimpl implements StudentServicei{
    @Autowired
	StudentRepository sr;
	@Override
	public void saveStudent(Student s) {
		sr.save(s);
		
	}
	@Override
	public List<Student> getallStudents() {
		
		return (List<Student>) sr.findAll();
	}
	@Override
	public List<Student> getBatchStudent(String batchNumber) {
		
		return sr.findAllByBatchNumber(batchNumber);
	}

}
