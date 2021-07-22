package kaoshixing_springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String account;
    private String name;
    private Integer sex;
    private Integer companyId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer status;
}
