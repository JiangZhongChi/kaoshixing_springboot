package kaoshixing_springboot.service;

import kaoshixing_springboot.mapper.DepartmentUserMapper;
import kaoshixing_springboot.pojo.DepartmentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentUserServiceImpl implements DepartmentUserService {
    @Autowired
    private DepartmentUserMapper departmentUserMapper;

    public void setDepartmentUserMapper(DepartmentUserMapper departmentUserMapper) {
        this.departmentUserMapper = departmentUserMapper;
    }

    public Integer adddepartmentUser(DepartmentUser departmentUser) {
        return departmentUserMapper.adddepartmentUser(departmentUser);
    }

    public List<Integer> queryUserIdByDepartmentId(Integer departmentId) {
        return departmentUserMapper.queryUserIdByDepartmentId(departmentId);
    }

    public List<Integer> queryUserIdByDepartmentIdLimit(Integer departmentId, Integer pageNo, Integer pageSize) {
        return departmentUserMapper.queryUserIdByDepartmentIdLimit(departmentId,pageNo,pageSize);
    }

    public Integer updateDepertmentUser(Integer userId, Integer departmentId) {
        return departmentUserMapper.updateDepertmentUser(userId,departmentId);
    }


}