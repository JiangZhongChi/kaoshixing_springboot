package kaoshixing_springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private Integer id;
    private String companyName;
    private Timestamp createTime;
    private String version;
    private Integer status;
}
