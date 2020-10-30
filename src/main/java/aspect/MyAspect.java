package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class MyAspect {

    private Logger logger = Logger.getLogger(MyAspect.class.getName());

    //prima * inseamna ca poate sa returneze orice
    @Around(value = "execution(* service.*.*(..))")
    public void logMessage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("Before executing method named "+ proceedingJoinPoint.getSignature().getName());
        logger.info("Parameters " + Arrays.toString(proceedingJoinPoint.getArgs()));
        Object result = proceedingJoinPoint.proceed();
        logger.info("After executing method named "+ proceedingJoinPoint.getSignature().getName());
        long executionTime = System.currentTimeMillis() - start;
        logger.info(proceedingJoinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
    }
}
