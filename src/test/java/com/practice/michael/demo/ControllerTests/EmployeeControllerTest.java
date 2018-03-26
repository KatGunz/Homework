package com.practice.michael.demo.ControllerTests;

import com.mmnaseri.utils.spring.data.dsl.factory.RepositoryFactoryBuilder;
import com.practice.michael.demo.Controllers.EmployeeController;
import com.practice.michael.demo.DAOs.EmployeeDao;
import com.practice.michael.demo.DTOs.Employee;
import com.practice.michael.demo.Services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private EmployeeDao testEmployeeDao;

    private EmployeeService testEmployeeService;

    private EmployeeController testEmployeeController;





    @Before
    public void setup(){
        testEmployeeController = new EmployeeController();
        testEmployeeService = new EmployeeService();
        testEmployeeDao = RepositoryFactoryBuilder.builder().mock(EmployeeDao.class);
        ReflectionTestUtils.setField(testEmployeeService, "employeeDao", testEmployeeDao);
        ReflectionTestUtils.setField(testEmployeeController, "employeeService", testEmployeeService);

    }
    @Test
    public void testEmployeeController()throws Exception{
        String testName = "Burk";
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName(testName);
        employee.setLastName("Pottes");

        Mockito.when(testEmployeeService.findOneEmployee(testName)).thenReturn(employee);
        Mockito.when(testEmployeeDao.getEmployeeByFirstName(testName)).thenReturn(employee);
        MvcResult result =
        mockMvc.perform(get("/api/employees/{firstName}", testName))
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("firstName").value(testName))
                .andExpect(status().isOk())
                .andReturn();
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(testEmployeeService).findOneEmployee(argumentCaptor.capture());
        verify(testEmployeeDao).getEmployeeByFirstName(argumentCaptor.capture());

        assertEquals(testName, argumentCaptor.getValue());
        String responsePayload = result.getResponse().getContentAsString();
        assertEquals(employee.toString(), responsePayload);
    }
//    @After
//    public void tearDown(){
//
//    }

}
