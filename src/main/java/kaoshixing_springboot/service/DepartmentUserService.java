package kaoshixing_springboot.service;

import kaoshixing_springboot.pojo.DepartmentUser;

import java.util.List;

public interface DepartmentUserService {
    //增加一个用户到department_user表
    Integer adddepartmentUser(DepartmentUser departmentUser);
    //根据department_id查询user_id
    List<Integer> queryUserIdByDepartmentId(Integer departmentId);
    //根据department_id分页查询user_id
    List<Integer> queryUserIdByDepartmentIdLimit(Integer departmentId,Integer pageNo,Integer pageSize);
    //根据user_id和department_id修改department_user表
    Integer updateDepertmentUser(Integer userId,Integer departmentId);




}