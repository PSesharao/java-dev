/*
 * package com.mindtree.springmvcapp.service.impl;
 * 
 * import static org.junit.Assert.*;
 * 
 * import org.junit.Test; import org.junit.jupiter.api.Assertions; import
 * org.junit.runner.RunWith; import org.mockito.junit.MockitoJUnitRunner; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean;
 * 
 * import com.mindtree.springmvcapp.dto.DepartmentDto; import
 * com.mindtree.springmvcapp.entity.Department; import
 * com.mindtree.springmvcapp.exception.serviceexception.
 * DepartmentServiceException; import
 * com.mindtree.springmvcapp.repository.DepartmentRepository; import
 * com.mindtree.springmvcapp.service.DepartmentService;
 * 
 * 
 * import static org.mockito.Mockito.doReturn; import static
 * org.mockito.ArgumentMatchers.any;
 * 
 * @SpringBootTest //@RunWith(MockitoJUnitRunner.class) public class
 * DepartmentServiceTest {
 * 
 * @Autowired private DepartmentService departmentService ;
 * 
 * @MockBean private DepartmentRepository departmentRepository ;
 * 
 * 
 * @Test public void testCreate() throws DepartmentServiceException {
 * 
 * Department department = new Department(); DepartmentDto departmentDto = new
 * DepartmentDto();
 * 
 * doReturn(department).when(departmentRepository).save(any());
 * 
 * Department tdpt = departmentService.createDepartment(departmentDto);
 * 
 * Assertions.assertNotNull(tdpt, "The saved widget should not be null"); }
 * 
 * }
 */