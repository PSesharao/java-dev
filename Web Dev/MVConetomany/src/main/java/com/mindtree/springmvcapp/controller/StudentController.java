package com.mindtree.springmvcapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mindtree.springmvcapp.dto.StudentDto;
import com.mindtree.springmvcapp.entity.Department;
import com.mindtree.springmvcapp.entity.Student;
import com.mindtree.springmvcapp.exception.StudentException;
import com.mindtree.springmvcapp.exception.serviceexception.DepartmentServiceException;
import com.mindtree.springmvcapp.service.DepartmentService;
import com.mindtree.springmvcapp.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private DepartmentService departmentService;

	
	@RequestMapping("/student")
	public ModelAndView student() throws StudentException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student");
		List<Department> deptList = null;
		try {
			deptList = departmentService.getAllDept();
		} catch (DepartmentServiceException e) {
			throw new StudentException(e.getLocalizedMessage());

		}
		mv.addObject("departmentList", deptList);
		return mv;
	}

	@RequestMapping("/addstudent")
	public String addStud(StudentDto studDto, @RequestParam("deptId") long deptId) throws StudentException {
		studentService.createStudent(studDto , deptId);
		
		return "home";
	}

	@RequestMapping("/show")
	public ModelAndView show() throws StudentException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		List<Department> deptList = null;
		try {
			deptList = departmentService.getAllDept();
		} catch (DepartmentServiceException e) {
			throw new StudentException(e);
		}
		mv.addObject("departmentList", deptList);
		return mv;
	}

	@RequestMapping("/showstudent")
	public ModelAndView showStud(@RequestParam("deptId") long deptId) throws StudentException {
		List<Student> students = null;
		Department department = null;
		try {
			department = departmentService.getDeptById(deptId);
		} catch (DepartmentServiceException e) {
			throw new StudentException(e.getLocalizedMessage());
		}
		students = department.getStudents();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		List<Department> deptList = null;
		try {
			deptList = departmentService.getAllDept();
		} catch (DepartmentServiceException e) {
			throw new StudentException(e.getLocalizedMessage());
		}
		mv.addObject("departmentList", deptList);
		mv.addObject("students", students);
		return mv;
		
	}

	@RequestMapping("/updatestudent")
	public ModelAndView updateStud(@RequestParam("studId") long studId) throws StudentException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updatestudent");
		Student existingStudent = studentService.getStudentById(studId);
		mv.addObject("student", existingStudent);
		return mv;
	}

	@RequestMapping("/savestudent")
	public ModelAndView saveStd(@RequestParam("studId") long studId, StudentDto studDto) throws StudentException {
		Student updatedStudent = studentService.updateStudent(studDto, studId);
		Department department = updatedStudent.getDepartment();
		department.getStudents().
		forEach(student -> {
			if(student.getId() == studId)
			{
				student = updatedStudent;
			}
		});
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		List<Department> deptList = null;
		try {
			deptList = departmentService.getAllDept();
		} catch (DepartmentServiceException e) {
			throw new StudentException(e.getLocalizedMessage());
		}
		
		mv.addObject("departmentList", deptList);
		return mv;
	}
}
