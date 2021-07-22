package kaoshixing_springboot.service;

import kaoshixing_springboot.pojo.User;

import java.util.List;

public interface UserService {
    //增加一个用户到user表
    Integer adduser(User user);
    //查询user表id最大值
    Integer queryMaxId();
    //根据id查询用户信息
    User queryUserById(Integer id);
    //根据姓名关键字模糊查询用户信息，且按照update_time倒序
    List<User> queryUserByNameLikeDesc(String nameLike);
    //根据姓名关键字 分页 模糊查询用户信息，且按照update_time倒序
    List<User> queryUserByNameLikeDescLimit(String nameLike,Integer pageNo, Integer pageSize);

    //更新user表信息
    Integer updateUserUpdateTimeById(Integer id);
}