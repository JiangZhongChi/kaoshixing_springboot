package kaoshixing_springboot.mapper;

import kaoshixing_springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //增加一个用户到user表
    Integer adduser(User user);

    //查询user表id最大值
    Integer queryMaxId();

    //根据id查询用户信息
    User queryUserById(Integer id);

    //根据姓名关键字模糊查询用户信息，且按照update_time倒序
    List<User> queryUserByNameLikeDesc(String nameLike);

    //根据姓名关键字 分页 模糊查询用户信息，且按照update_time倒序
    List<User> queryUserByNameLikeDescLimit(@Param("nameLike") String nameLike, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);


    //更新user表信息
    Integer updateUserUpdateTimeById(Integer id);


}