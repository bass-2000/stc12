package ru.innopolis.stc12.springSp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap();
    private ProfilingController profilingController = new ProfilingController();

    public ProfilingAnnotationBeanPostProcessor() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(
                profilingController,
                new ObjectName("Profiling", "name", "controller")
        );
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(
                    beanClass.getClassLoader(),
                    beanClass.getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if (profilingController.isEnabled()) {
                                System.out.println("PROFILING");
                                long startTime = System.currentTimeMillis();
                                Object returning = method.invoke(bean, args);
                                System.out.println("Progiling result:" + (System.currentTimeMillis() - startTime));
                                System.out.println("PROFILING FINISHED");
                                return returning;
                            }
                            return method.invoke(bean, args);
                        }
                    }
            );
        }
        return bean;
    }
}
