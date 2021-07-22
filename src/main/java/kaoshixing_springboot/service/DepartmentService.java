package kaoshixing_springboot.service;

import kaoshixing_springboot.pojo.Department;

public interface DepartmentService {
    Integer queryDepartmentIdByName(String name);

    Department queryDepartmentNameById(Integer id);
}
