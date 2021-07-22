package kaoshixing_springboot.mapper;

import kaoshixing_springboot.pojo.Company;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


@Mapper

public interface CompanyMapper {
    //查询公司
    Company queryCompanyById(@RequestParam("id") Integer id);
    //查询全部公司信息
    Company queryCompany();
}
