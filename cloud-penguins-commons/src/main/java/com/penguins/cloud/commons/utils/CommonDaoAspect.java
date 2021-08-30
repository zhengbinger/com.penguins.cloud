//package com.penguins.cloud.commons.utils;
//
//import io.micrometer.core.instrument.util.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.BeanUtils;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//
///**
// * @author 郑冰
// * @date 2021/8/13 14:23
// * @email mydreambing@126.com
// * @since jdk8
// **/
//@Aspect
//@Component
//@Configuration
//public class CommonDaoAspect {
//
//    private static final String creater = "creater";
//    private static final String createTime = "createTime";
//    private static final String updater = "updater";
//    private static final String updateTime = "updateTime";
//
//    @Pointcut("execution(* com.penguins.*.update*(..))")
//    public void daoUpdate() {
//    }
//
//    @Pointcut("execution(* com.penguins.*.insert*(..))")
//    public void daoCreate() {
//    }
//
//    @Around("daoUpdate()")
//    public Object doDaoUpdate(ProceedingJoinPoint pjp) throws Throwable {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attributes == null) {
//            return pjp.proceed();
//        }
//        HttpServletRequest request = attributes.getRequest();
//        String token = request.getHeader("token");
//        String username = getUserName();
//        if (token != null && username != null) {
//            Object[] objects = pjp.getArgs();
//            if (objects != null && objects.length > 0) {
//                for (Object arg : objects) {
//                    BeanUtils.setProperty(arg, updater, username);
//                    BeanUtils.setProperty(arg, updateTime, new Date());
//                }
//            }
//        }
//        Object object = pjp.proceed();
//        return object;
//
//    }
//
//    @Around("daoCreate()")
//    public Object doDaoCreate(ProceedingJoinPoint pjp) throws Throwable {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attributes == null) {
//            return pjp.proceed();
//        }
//        Object[] objects = pjp.getArgs();
//        if (objects != null && objects.length > 0) {
//            for (Object arg : objects) {
//                String username = getUserName();
//                if (username != null) {
//                    if (StringUtils.isBlank(BeanUtils.getProperty(arg, creater))) {
//                        BeanUtils.setProperty(arg, creater, username);
//                    }
//                    if (StringUtils.isBlank(BeanUtils.getProperty(arg, createTime))) {
//                        BeanUtils.setProperty(arg, createTime, new Date());
//                    }
//                }
//            }
//        }
//        Object object = pjp.proceed();
//        return object;
//    }
//
//    private String getUserName() {
//        return "";
////        return UserUtils.getUsername();
//    }
//}