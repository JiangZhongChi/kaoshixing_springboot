package kaoshixing_springboot.mapper;

import kaoshixing_springboot.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {
    Integer queryDepartmentIdByName( String name);

    Department queryDepartmentNameById(Integer id);
}
