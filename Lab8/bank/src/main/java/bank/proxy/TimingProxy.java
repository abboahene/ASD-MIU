package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingProxy implements InvocationHandler {
    private Object target;

    public TimingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Long start = System.currentTimeMillis();
        Object object = method.invoke(target, args);
        Long end =  System.currentTimeMillis();
        System.out.println("Timing: " + method.getName() + " took " + (end - start) + "ms");
        return object;
    }
}
