package kaoshixing_springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kaoshixing_springboot.pojo.Content1;
import kaoshixing_springboot.pojo.Result1;
import kaoshixing_springboot.pojo.User;
import kaoshixing_springboot.pojo.UserReturn;
import kaoshixing_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QueryUserNameController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/queryUserName")
    public String queryUserName(@RequestParam("nameLike") String nameLike,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize) throws JsonProcessingException {
        //根据名字模糊查询用户信息
        List<User> list = userService.queryUserByNameLikeDesc(nameLike);
        //根据名字 分页 模糊查询用户信息
        List<User> list1 = userService.queryUserByNameLikeDescLimit(nameLike,(pageNo-1)*pageSize,pageSize);
        //设置json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);
        //转成json格式
        List<UserReturn> users = new ArrayList<UserReturn>();
        for(int i=0;i<list1.size();i++){
            User user = list1.get(i);
            UserReturn userReturn = new UserReturn(user.getId(),user.getName(),user.getAccount(),user.getSex(),user.getCreateTime(),user.getUpdateTime());
//            String str = mapper.writeValueAsString(userReturn);
//            users.add(str);
            users.add(userReturn);
        }

        int total = list.size();
//        model.addAttribute("success", "true");
//        model.addAttribute("page",pageNo);
//        model.addAttribute("total",total);
//        model.addAttribute("rowCount",pageSize);
//        model.addAttribute("list",users);
//        model.addAttribute("errMsg","null");


        Content1 content1 = new Content1(pageNo,total,pageSize,users);
        Result1 result1 = new Result1(true,content1);
        return mapper.writeValueAsString(result1);
    }



}