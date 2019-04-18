package com.dyd.ssp.smp.aspect;

import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 统一返回相应参数实体类
 */
@Data
public class ResultModel<T> implements Serializable {
    private static final long serialVersionUID = -1453709396310044030L;

    private int status;
    private T result;
    private String message;
    private String code;

    public ResultModel() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        response.setCharacterEncoding("UTF-8");
    }

    public String toString() {
        return "ResultModel [status=" + this.status + ", result=" + this.result +  ", message=" + this.message + ", code=" + this.code + "]";
    }
}
