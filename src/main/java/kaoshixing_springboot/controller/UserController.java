package kaoshixing_springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kaoshixing_springboot.pojo.Content2;
import kaoshixing_springboot.pojo.DepartmentUser;
import kaoshixing_springboot.pojo.Result2;
import kaoshixing_springboot.pojo.User;
import kaoshixing_springboot.service.DepartmentService;
import kaoshixing_springboot.service.DepartmentUserService;
import kaoshixing_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Controller

public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentUserService departmentUserService;
    @Autowired
    private DepartmentService departmentService;


    @ResponseBody
    @PostMapping("/user/adduser")
    public String list(@RequestParam("account") String account, @RequestParam("userName")String userName, @RequestParam("sex")Integer sex, @RequestParam("companyId")Integer companyId, @RequestParam("status")Integer status, @RequestParam("departmentName") String departmentName) throws JsonProcessingException {
        //获取当前时间
        Timestamp d= new Timestamp(System.currentTimeMillis());
        //获取userId
        Integer userId = userService.queryMaxId() + 1;
        //根据传入参数创建user对象
        User user = new User(userId,account,userName,sex,companyId,d,d,status);
        //根据输入的部门名称查询部门id
        Integer departmentId = departmentService.queryDepartmentIdByName(departmentName);

        Integer departmentUserId = userId;
        //根据传入参数创建DepartmentUser对象
        DepartmentUser departmentUser = new DepartmentUser(departmentUserId,companyId,departmentId,userId,status);
        //在user表中增加用户
        Integer adduser = userService.adduser(user);
        //在department_user表中增加用户信息
        Integer adddepertmentUser = departmentUserService.adddepartmentUser(departmentUser);

        //设置json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);


        Result2 result2 = null;
        Content2 content2 = new Content2(userId);
        if(adduser.equals(1)){

//            model.addAttribute("success","true");
//            model.addAttribute("id", userId);
//            model.addAttribute("errMsg", "null");

            result2 = new Result2(true,content2,null);

        }else {
//            model.addAttribute("success","false");
//            model.addAttribute("id", userId);
//            model.addAttribute("errMsg", "未成功增加用户");

            result2 = new Result2(false,content2,"未成功增加用户");
        }

        return mapper.writeValueAsString(result2);


    }
}
