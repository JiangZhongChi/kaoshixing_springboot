package kaoshixing_springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content1 {
    private Integer page;
    private Integer total;
    private Integer rowCount;
    private Object rows;
}