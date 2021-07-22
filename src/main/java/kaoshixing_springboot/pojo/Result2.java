package kaoshixing_springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result2 {
    private Boolean success;
    private Object content;
    private String errMsg;
}
