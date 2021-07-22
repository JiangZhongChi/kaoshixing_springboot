package kaoshixing_springboot.service;

import kaoshixing_springboot.mapper.UserMapper;
import kaoshixing_springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Integer adduser(User user) {
        return userMapper.adduser(user);
    }

    public Integer queryMaxId() {
        return userMapper.queryMaxId();
    }

    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    public List<User> queryUserByNameLikeDesc(String nameLike) {
        return userMapper.queryUserByNameLikeDesc(nameLike);
    }

    public List<User> queryUserByNameLikeDescLimit(String nameLike, Integer pageNo, Integer pageSize) {
        return userMapper.queryUserByNameLikeDescLimit(nameLike,pageNo,pageSize);
    }

    @Override
    public Integer updateUserUpdateTimeById(Integer id) {
        return userMapper.updateUserUpdateTimeById(id);
    }


}
