package kaoshixing_springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kaoshixing_springboot.pojo.Result1;
import kaoshixing_springboot.pojo.Result2;
import kaoshixing_springboot.service.DepartmentService;
import kaoshixing_springboot.service.DepartmentUserService;
import kaoshixing_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

@Controller
public class UpdateController {

    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentUserService departmentUserService;
//    @Autowired
//    private DepartmentService departmentService;

    @ResponseBody
    @PostMapping("/update")
    public String update(@RequestParam("userId")Integer userId,@RequestParam("departmentId") Integer departmentId) throws JsonProcessingException {

        //设置json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        //根据传入的userId和departmentId修改department_user表
        Integer integer = departmentUserService.updateDepertmentUser(userId, departmentId);

        //根据传入的userId将此用户的update_time更新为当前时间
        userService.updateUserUpdateTimeById(userId);

        Result2 result2 = null;
        if(integer.equals(1)) {
//            model.addAttribute("success", "true");
//            model.addAttribute("content", "null");
//            model.addAttribute("errMsg", "null");
            result2 = new Result2(true,null,null);
        }

        return mapper.writeValueAsString(result2);
    }
}