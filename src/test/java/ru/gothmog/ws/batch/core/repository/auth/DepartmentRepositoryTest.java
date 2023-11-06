package ru.gothmog.ws.batch.core.repository.auth;

import liquibase.Liquibase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gothmog.ws.batch.core.model.auth.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("test")
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void testInsert() {
        long size = 10000;
        List<Department> departmentList = new ArrayList<>();
        for (int i = 0; i < size; i += 1) {
            Department department = new Department();
            department.setSmallName("Department small name " + i  + " insert");
            department.setFullName("Department full name " + i  + " insert");
            department.setPublicId(UUID.randomUUID());
            departmentList.add(department);
        }
        departmentRepository.saveAll(departmentList);
        assertEquals(size, departmentRepository.count());
    }

    @Test
    public void testUpdate() {
        List<Department> departmentList = departmentRepository.findAll();
        List<Department> departments = new ArrayList<>();
        for (Department department : departmentList) {
            department.setActive(true);
            department.setFullName("Department small name update zero");
            departments.add(department);
        }

//        departmentList.forEach(department -> department.getSmallName().replaceAll(department.getSmallName(),
//                                                                                  "Department small name update zero"));
//        List<Department> departments = new ArrayList<>();
//        for (Department department: departmentList) {
//            department.getSmallName().replaceAll(department.getSmallName(), "Department small name update");
//
//        }
//        for (int k = 0; k < 10; k += 1) {
//
//            for (int i = 0; i < 100; i += 1) {
//                Department department = new Department();
//                department.setSmallName("Department small name " + i + " update");
//                department.setFullName("Department full name " + i  + " update");
//                department.setPublicId(UUID.randomUUID());
//                departmentList.add(department);
//            }
//
//        }
        departmentRepository.saveAll(departments);
        assertEquals(10000,  departmentRepository.count());
    }

    @Test
    public void testDelete() {
        for (int k = 0; k < 20; k += 1) {
            List<Department> departmentList = new ArrayList<>();
            for (int i = 0; i < 50; i += 1) {
                Department department = new Department();
                department.setSmallName("Department small name " + i);
                department.setFullName("Department full name " + i);
                department.setPublicId(UUID.randomUUID());
                departmentList.add(department);
            }
            departmentRepository.deleteAll(departmentList);
        }
        assertEquals(1000, departmentRepository.count());
    }

    @Test
    public void test4() {
        long size = 1000;
        for (int i = 0; i < size; i += 1) {
            Department department = new Department();
            department.setSmallName("Department small name " + i);
            department.setFullName("Department full name " + i);
            department.setPublicId(UUID.randomUUID());
            departmentRepository.save(department);
        }
        assertEquals(size, departmentRepository.count());
    }

    @AfterEach
    void tearDown() {
    }
}
