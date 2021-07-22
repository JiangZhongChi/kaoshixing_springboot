package kaoshixing_springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUser {
    private Integer id;
    private Integer companyId;
    private Integer departmentId;
    private Integer userId;
    private Integer status;
}
