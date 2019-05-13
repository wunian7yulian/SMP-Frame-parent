package com.dyd.ssp.smp.section.advice.handler;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 统一返回相应参数实体类
 */
@Data
@ApiModel(description = "返回结果")
public class ResultModel<T> implements Serializable {
    private static final long serialVersionUID = -1453709396310044030L;

    private String status;
    private T result;
    private String message;
    private int code;

    public ResultModel() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        response.setCharacterEncoding("UTF-8");
    }

    public String toString() {
        return "ResultModel [status=" + this.status + ", result=" + this.result +  ", message=" + this.message + ", code=" + this.code + "]";
    }
}
