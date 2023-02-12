package com.api.asset_management.service;

import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import com.api.asset_management.exception.ResourceNotFoundException;
import com.api.asset_management.model.Employee;
import com.api.asset_management.payload.ApiResponse;
import com.api.asset_management.repository.EmployeeRepository;
import com.api.asset_management.services.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService EmployeeService() {
			return new EmployeeService();
		}
	}

	@Mock
	private EmployeeRepository testRepo;
	@InjectMocks
	private EmployeeService testService;
	String id = "randomId";
	UUID id2 = UUID.randomUUID();
	Employee employee = Employee.builder().branch(null).department(null).email("kssrikumar180703@gmail.com")
			.status("ACTIVE").employeeId(id).firstName("Sri").lastName("Kumar").phoneNumber(6309557701l).build();

	@Test
	void getAllEmployeeTest() {
		ApiResponse result = testService.getAllEmployee();
		Assert.assertEquals(result.getClass(), ApiResponse.class);
		Assert.assertNotNull(result.getData());
		Assert.assertEquals(HttpStatus.OK, result.getStatus());
	}

	@Test
	void getEmployeeByIdTest() {
		when(testRepo.findById(id)).thenReturn(Optional.of(employee));
		ApiResponse result = testService.getAllEmployeeById(id);
		Assert.assertEquals(ApiResponse.class, result.getClass());
		Assert.assertNotNull(result.getData());
		Employee data = (Employee) result.getData();
		Assert.assertEquals(id, data.getEmployeeId());
	}

	@Test
	void throwExceptionIfEmployeeIdNotPresentTest() {
		Assert.assertThrows(ResourceNotFoundException.class, () -> {
			testService.getAllEmployeeById(id);
		});
	}

	//	@Test
	//	void addEmployeeTest() {
	//		when(testRepo.save(Mockito.any(Employee.class))).thenReturn(employee);
	//		Employee result = testService.addEmployee(EmployeeRequest.builder().branchId(id2).departmentId(id2)
	//				.email("kssrikumar180703@gmail.com").employeeId(id).firstName("Sri").lastName("kumar")
	//				.password("123456").phoneNumber(6309557702l).build());
	//		Assert.assertNotNull(result);
	//		Assert.assertEquals("kssrikumar180703@gmail.com", result.getEmail());
	//
	//	}

}
