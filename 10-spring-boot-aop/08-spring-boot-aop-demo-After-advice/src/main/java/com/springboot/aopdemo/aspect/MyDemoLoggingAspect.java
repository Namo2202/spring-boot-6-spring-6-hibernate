package com.springboot.aopdemo.aspect;

import com.springboot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @After("execution(* com.springboot.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>>> Executing @After (finally) on method: "+method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.springboot.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>>> Executing @AfterThrowing on method: "+method);

        System.out.println("\n=====>>> The exception is: "+ theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.springboot.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void  afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =====>>> Executing @AfterReturning on method: "+method);

        System.out.println("\n=====>>> result is: "+ result);

        convertAccountNameToUpperCase(result);

        System.out.println("\n=====>>> result is: "+ result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.springboot.aopdemo.aspect.LuvAOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: "+theAccount.getName());
                System.out.println("account level: "+theAccount.getLevel());
            }
        }
    }
}
