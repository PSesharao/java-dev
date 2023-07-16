package com.mindtree.springJpaManytoMany.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springJpaManytoMany.converter.StudentConverter;
import com.mindtree.springJpaManytoMany.converter.SubjectConverter;
import com.mindtree.springJpaManytoMany.dto.StudentDto;
import com.mindtree.springJpaManytoMany.dto.SubjectDto;
import com.mindtree.springJpaManytoMany.entity.Student;
import com.mindtree.springJpaManytoMany.entity.Subject;
import com.mindtree.springJpaManytoMany.exception.daoexception.ResourceNotFoundException;
import com.mindtree.springJpaManytoMany.exception.serviceexception.SubjectServiceException;
import com.mindtree.springJpaManytoMany.repository.SubjectRepository;
import com.mindtree.springJpaManytoMany.service.SubjectService;

class SortDescending implements Comparator<Subject> {

	@Override
	public int compare(Subject subject1 , Subject subject2 ) {
		
		return (int) (subject2.getSecuredMarks() - subject1.getSecuredMarks());
	}


}
@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SubjectConverter subjectConverter;
	
	@Autowired
	private StudentConverter studentConverter;
	
	@Override
	public Subject createSubject(SubjectDto subjectDto) throws SubjectServiceException {
		
		return subjectRepository.save(subjectConverter.dtoToEntity(subjectDto));
	}

	@Override
	public List<Subject> getSubjectsByName(String subjectName) throws SubjectServiceException {
		List<Subject> subjectList = subjectRepository.findAllByName(subjectName);
		if(subjectList == null)
			try {
				throw new ResourceNotFoundException("No Subject Found With Name "+subjectName);
			} catch (ResourceNotFoundException e) {
				throw new SubjectServiceException(e.getLocalizedMessage());
			}
		return subjectList;
	}

	@Override
	public Subject getSubjectById(long subjectId) throws SubjectServiceException {
		
		try {
			return subjectRepository.findById(subjectId).orElseThrow(() -> new ResourceNotFoundException("No Subject Found With Id " + subjectId));
		} catch (ResourceNotFoundException e) {
			throw new SubjectServiceException(e.getLocalizedMessage());
		}
	}

	@Override
	public Subject saveSubject(Subject subject) throws SubjectServiceException {
		
		return subjectRepository.save(subject);
	}

	@Override
	public List<Map<String, Object>> getStudentsBySubject(String subjectName) throws SubjectServiceException {
		
		
		List<Map<String, Object>> info = new ArrayList<>();
		
		
		List<Subject> subjectList = sortSubjectsByMarks(getSubjectsByName(subjectName));
	
		for(Subject subject : subjectList)
		{
			/*subject.getStudentList().forEach(student -> {
				studentList.add(student);
				Map<String, Object> message = new LinkedHashMap<>();
				message.put("name ", student.getName());
				message.put("marks report ", subject.getSecuredMarks() +"/" + subject.getFullMarks() );
				info.add(message);
			});*/
			
			
			
			for ( Student student : subject.getStudentList()) {
				Map<String, Object> message = new LinkedHashMap<>();
				message.put("name ", student.getName());
				message.put("marks report ", subject.getSecuredMarks() +"/" + subject.getFullMarks() );
				info.add(message);
			}
		}
			
		
		return info;
	}

	@Override
	public List<Subject> sortSubjectsByMarks(List<Subject> subjectList) throws SubjectServiceException {
		
		return 
				
				subjectList.
				stream().
				sorted(new SortDescending()).
				collect(Collectors.toList());
	}

	@Override
	public List<SubjectDto> getSubjectDtoList(List<Subject> subjectList) throws SubjectServiceException {
		List<SubjectDto> subjectDtoList = new ArrayList<SubjectDto>();
		subjectList.forEach(subject -> {
			subjectDtoList.add(subjectConverter.entityToDto(subject));
		
		});
		return subjectDtoList;
	}

	@Override
	public float getTotalSecuredMarks(List<Subject> subjectList) throws SubjectServiceException {
		float TotalSecuredMarks = 0;
		for (Subject subject : subjectList) {
			TotalSecuredMarks+=subject.getSecuredMarks();
		}
		return TotalSecuredMarks;
	}

	@Override
	public int getTotalMarks(List<Subject> subjectList) throws SubjectServiceException {
		int TotalMarks = 0;
		for (Subject subject : subjectList) {
			TotalMarks+=subject.getFullMarks();
		}
		return TotalMarks;
	}
	
	

}
