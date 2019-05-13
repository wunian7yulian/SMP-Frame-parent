package com.dyd.ssp.smp.section.advice.handler;

import com.dyd.ssp.smp.section.advice.handler.ResultModel;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * @author zwt
 * @since 2019-05-06
 */
@Slf4j
public class ResponseUtil {

    public static void out(ServletResponse response, ResultModel resultModel){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(new Gson().toJson(resultModel));
        } catch (Exception e) {
            log.error(e + "输出JSON出错");
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }

}
