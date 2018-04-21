package com.practice.michael.demo.ControllerTests;

import com.google.gson.Gson;
import com.mmnaseri.utils.spring.data.dsl.factory.RepositoryFactoryBuilder;
import com.practice.michael.demo.Controllers.EmployeeController;
import com.practice.michael.demo.DAOs.EmployeeDao;
import com.practice.michael.demo.DTOs.Employee;
import com.practice.michael.demo.Services.EmployeeService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService testEmployeeService;

    @InjectMocks
    private EmployeeController testEmployeeController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(testEmployeeController)
                .build();
    }


    @Test
    public void testEmployeeControllerWithStatus200()throws Exception{
        String testName = "Burk";
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName(testName);
        employee.setLastName("Pottes");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Mockito.when(testEmployeeService.findEmployeesByFirstName(testName)).thenReturn(employees);
        MvcResult result =
        mockMvc.perform(get("/api/employees/{firstName}", testName))
                .andExpect(status().isOk())
                .andReturn();

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(testEmployeeService, times(1)).findEmployeesByFirstName(argumentCaptor.capture());

        assertEquals(testName, argumentCaptor.getValue());
        String responsePayload = result.getResponse().getContentAsString();
        assertEquals(new Gson().toJson(employees).toString(), responsePayload);

        verifyNoMoreInteractions(testEmployeeService);
    }
    @Test
    public void testEmployeeControllerWithStatus400()throws Exception{
        String testName = "Burk";
        ArrayList<Employee> employees = null;

        Mockito.when(testEmployeeService.findEmployeesByFirstName(testName)).thenReturn(employees);
        MvcResult result =
        mockMvc.perform(get("/api/employees/{firstName}", testName))
                .andExpect(status().isBadRequest())
                .andReturn();

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(testEmployeeService, times(1)).findEmployeesByFirstName(argumentCaptor.capture());

        assertEquals(testName, argumentCaptor.getValue());
        String responsePayload = result.getResponse().getContentAsString();
        assertEquals("", responsePayload);

        verifyNoMoreInteractions(testEmployeeService);
    }
}
