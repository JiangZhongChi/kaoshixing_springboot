package kaoshixing_springboot.service;

import kaoshixing_springboot.pojo.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


public interface CompanyService {
    //查询公司
    Company queryCompanyById(@RequestParam("id") Integer id);
    //查询全部公司信息
    Company queryCompany();
}
