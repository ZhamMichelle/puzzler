package kz.zhami.puzzler;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * @author zhamilya on 3/16/24
 */
@Component
public class InitMethodRegistryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
//    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(name);
            String className = beanDefinition.getBeanClassName();
            if (className != null) {
                Class<?> beanClass = null;
                try {
                    beanClass = Class.forName(className);
                    Class<?>[] interfaces = ClassUtils.getAllInterfacesForClass(beanClass);
                    for (Class<?> ifc : interfaces) {
                        Method[] methods = ifc.getMethods();
                        for (Method method : methods) {
                            if (method.isAnnotationPresent(PostConstruct.class)) {
                                beanDefinition.setInitMethodName(method.getName());
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
