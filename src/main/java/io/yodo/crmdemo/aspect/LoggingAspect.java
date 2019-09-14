package io.yodo.crmdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger log = Logger.getLogger(getClass().getName());

    @Pointcut("execution(public * io.yodo.crmdemo.controller.*.*(..))")
    private void controllerMethod() {}

    @Pointcut("execution(public * io.yodo.crmdemo.dao.*.*(..))")
    private void daoMethod() {}

    @Pointcut("execution(public * io.yodo.crmdemo.service.*.*(..))")
    private void serviceMethod() {}

    @Pointcut("execution(public * set*(..))")
    private void setter() {}

    @Pointcut("execution(public * get*(..))")
    private void getter() {}

    @Pointcut("(controllerMethod() || daoMethod() || serviceMethod()) && !(getter() || setter())")
    private void combined() {}

    @Before("combined()")
    public void beforeLoggingAdvice(JoinPoint jp) {
        Signature sig = jp.getSignature();
        log.info(">> @Before - calling " + sig.toShortString());
    }

    @After("combined()")
    public void afterLoggingAdvice(JoinPoint jp) {
        Signature sig = jp.getSignature();
        log.info("<< @After - exiting " + sig.toShortString());
    }
}
