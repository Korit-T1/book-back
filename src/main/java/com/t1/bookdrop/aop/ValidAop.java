package com.t1.bookdrop.aop;

import com.t1.bookdrop.dto.SigninReqDto;
import com.t1.bookdrop.dto.SignupReqDto;
import com.t1.bookdrop.exception.ValidException;
import com.t1.bookdrop.repository.UserMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class ValidAop {

    @Autowired
    private UserMapper userMapper;

    @Pointcut("@annotation(com.t1.bookdrop.aop.annotation.ValidAspect)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    String methodName = proceedingJoinPoint.getSignature().getName();

        Object [] args = proceedingJoinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg;
            }
        }

        if(methodName.equals("signup")) {
             SigninReqDto signinReqDto = null;

            for(Object arg : args) {
                if(arg.getClass() == SigninReqDto.class) {
                    signinReqDto = (SigninReqDto) arg;
                }
            }

            if(userMapper.userCheckByUsername(signinReqDto.getUsername()) != null) {
                ObjectError objectError = new FieldError("username", "username", "이미 사용하는 사용자 이름입니다.");
                bindingResult.addError(objectError);
            }
        }

        if(bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError fieldError : fieldErrors) {
                String fieldName = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                errorMap.put(fieldName, message);
            }

            throw new ValidException(errorMap);

        }
        return proceedingJoinPoint.proceed();
    }
}
