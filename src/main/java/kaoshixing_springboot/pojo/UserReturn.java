package kaoshixing_springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReturn {
    private Integer id;
    private String name;
    private String account;
    private Integer sex;
    private Timestamp createTime;
    private Timestamp updateTime;

}