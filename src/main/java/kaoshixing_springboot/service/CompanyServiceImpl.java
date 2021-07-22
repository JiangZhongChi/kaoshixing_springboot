package kaoshixing_springboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kaoshixing_springboot.mapper.CompanyMapper;
import kaoshixing_springboot.pojo.Company;
import kaoshixing_springboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${companyMessage}")
    private String companyMessage;

    public void setCompanyMapper(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public Company queryCompanyById(Integer id) {
        //设置json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        //判断redis中是否有数据，如果有，直接从redis中获取数据返回
        try {
            String jsonstr = (String) redisUtil.hget(companyMessage,id + "");
            if(jsonstr!=null) {
                System.out.println("有缓存,剩余时间" + redisUtil.getExpire(companyMessage) + "秒");
                return mapper.readValue(jsonstr, Company.class);
            }
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //从mysql中查询company信息
        Company company = companyMapper.queryCompanyById(id);

        //调用方法将company信息写入redis
        try {
            redisUtil.hset(companyMessage,id+"",mapper.writeValueAsString(company),300);
            System.out.println("没有缓存");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return company;
    }

    @Override
    public Company queryCompany() {
        return companyMapper.queryCompany();
    }
}
