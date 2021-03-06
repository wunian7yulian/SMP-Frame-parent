package com.dyd.ssp.smp.section.advice;

import com.dyd.ssp.smp.base.BusinessException;
import com.dyd.ssp.smp.base.Constant;
import com.dyd.ssp.smp.exception.ParamJsonException;
import com.dyd.ssp.smp.section.advice.handler.ResultModel;
import com.dyd.ssp.smp.section.advice.handler.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Controller统一异常处理
 */
@ControllerAdvice
public class ControllerExceptionAdvice {
    private static Logger logger = LoggerFactory.getLogger(ControllerExceptionAdvice.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     */
    @ModelAttribute
    public void addAttributes(Model model) {
    }

    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultModel<String> errorHandler(Exception ex) {
        ex.printStackTrace();
        logger.error("接口出现异常：{}", ex.getMessage());
        return ResultUtil.validationFailure(Constant.ResultType.FAILED);
    }

    /**
     * 捕捉BusinessException自定义抛出的异常
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultModel handleBusinessException(BusinessException e) {
        if(e instanceof BusinessException) {
            logger.info("操作失败："+e.getMessage());
            return ResultUtil.validationFailure("操作失败："+e.getMessage());
        }
        return ResultUtil.validationFailure(Constant.ResultType.ERROR);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = ParamJsonException.class)
    @ResponseBody
    public ResultModel<String> handleParamJsonException(ParamJsonException e) {
        logger.info("参数错误："+e.getMessage());
        return ResultUtil.validationFailure("参数错误："+ e.getMessage());
    }


}