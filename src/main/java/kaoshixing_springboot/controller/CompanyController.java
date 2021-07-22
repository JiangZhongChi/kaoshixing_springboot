package kaoshixing_springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kaoshixing_springboot.pojo.Company;
import kaoshixing_springboot.pojo.Result1;
import kaoshixing_springboot.service.CompanyService;
import kaoshixing_springboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //查询公司
    @ResponseBody
    @GetMapping("/company/queryCompanyById")
    public String list(@RequestParam("companyId")Integer companyId) throws JsonProcessingException {
        //设置json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        Company company = companyService.queryCompanyById(companyId);
//        String str = mapper.writeValueAsString(company);

        Result1 result1 = new Result1(true,company);
        return mapper.writeValueAsString(result1);

    }

//    @Autowired
//    private RedisUtil redisUtil;

//    @ResponseBody
//    @GetMapping("/test")
//    public Company test(){
//
//        Company company =companyService.queryCompanyById(1);
//        return company;
//    }

//    @ResponseBody
//    @GetMapping("/test1")
//    public String test1(){
////        redisTemplate.opsForHash().put("companyMessage","1","1qwe");
//        redisUtil.hset("companyMessage","1","1qwe");
//        redisUtil.hset("companyMessage","2","2qwe");
//        redisUtil.hset("companyMessage","3","3qwe",300);
//        redisUtil.del("qqq","www");
//        return (String) redisUtil.hget("companyMessage","1");
//
//    }

}
