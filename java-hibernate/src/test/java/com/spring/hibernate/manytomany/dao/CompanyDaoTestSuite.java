package com.spring.hibernate.manytomany.dao;

import com.spring.hibernate.manytomany.Company;
import com.spring.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;
    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        //try {
        //    companyDao.deleteById(softwareMachineId);
        //    companyDao.deleteById(dataMaestersId);
        //    companyDao.deleteById(greyMatterId);
        //} catch (Exception e) {
        //    //do nothing
        //}
    }

    @Test
    void testRetrieveEmployeesByLastname() {
        Employee employee = new Employee("John", "Doe");
        employeeDao.save(employee);
        String lastname = "Doe";

        List<Employee> retrievedEmployees = employeeDao.retrieveEmployeesByLastname(lastname);


            assertEquals(1, retrievedEmployees.size());
            assertEquals("John", retrievedEmployees.get(0).getFirstname());

           // employeeDao.delete(employee);

    }

    @Test
    void testRetrieveCompaniesByFirstThreeCharsOfName() {
        Company company = new Company("ABC Corporation");
        companyDao.save(company);
        String namePattern = "ABC";

        List<Company> retrievedCompanies = companyDao.retrieveCompaniesByFirstThreeCharsOfName(namePattern);


            assertEquals(1, retrievedCompanies.size());
            assertEquals("ABC Corporation", retrievedCompanies.get(0).getName());

           // companyDao.delete(company);

    }
}
