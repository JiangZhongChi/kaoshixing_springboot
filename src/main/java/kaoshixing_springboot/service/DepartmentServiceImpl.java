package kaoshixing_springboot.service;

import kaoshixing_springboot.mapper.DepartmentMapper;
import kaoshixing_springboot.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public Integer queryDepartmentIdByName(String name) {
        return departmentMapper.queryDepartmentIdByName(name);
    }

    public Department queryDepartmentNameById(Integer id) {
        return departmentMapper.queryDepartmentNameById(id);
    }
}
