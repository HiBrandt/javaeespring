package com.study.spring.spring03;

import com.study.spring.spring03.proxy.MathI;
import com.study.spring.spring03.proxy2.MathImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: javaeessm
 * @description: TODO
 * @author: HiBrandt
 * @create: 2020-10-16 14:20
 *
 * 1.动态代理：使用一个代理将原本对象包装起来，然后用该代理对象”取代”原始对象。任何对原始对象的调用都要通过代理。
 *   -->涉及到三个对象  原始对象、代理对象、目标对象
 *     -->其实就是根据不同的目标对象，动态的对应生成不同的代理对象，以实现目标对象的功能。
 *     （底层就是用代理对象调用目标对象的方法，这样就能保证目标的结果一致性）
 * 2.面向切面编程AOP：是对OOP的一种补充
 *    -->OOP: 纵向继承 AOP: 横向抽取（公共功能抽取出来）（公共功能就是非业务代码，以及公用的一些功能）
 *    -->什么是切面：来存储公共功能的类就叫做切面（本质也是类，放公共功能的类） 例如：MyLogger
 *    -->公共功能术语叫横切关注点
 *    -->AOP依赖于IOC
 * 3.AspectJ:AOP框架
 *    -->①xml配置文件加载该标签，<aop:aspectj-autoproxy>
 *        当Spring IOC容器侦测到bean配置文件中的<aop:aspectj-autoproxy>元素时,会自动为与AspectJ切面匹配的bean创建代理
 *    -->②用Spring注解的方式配置bean。(其实就是xml文件配置要扫描的包)(所以AOP依赖于IOC)
 *    -->③为切面添加注解 @Aspect以及IOC的注解比如 @Component、@Repository持久化层组件等等
 *    -->④编写切面代码并在切面中方法处添加注解@Before,@After,@AfterReturning,@AfterThrowing等并写切入点表达式....
 *    -->⑤给要作用的目标类添加上注解以被Spring管理
 *    -->⑥使用的时候要以IOC的形式创建对象
 *
 *
 **/
public class StudySpring03 {


    public static void main(String[] args) {


        // 测试proxy1
        /*
        ProxyUtil proxyUtil = new ProxyUtil(new MathImpl());
        //向下强转成接口的类型(必须是接口的类型)
        //因为动态代理是生成的代理对象 是用来代理之前的接口实现类的对象的(其实就是代理目标对象)
        //代理对象和目标对象没有纵向继承的关系而是并列的关系
        MathI proxy = (MathI) proxyUtil.getProxy();
        int add = proxy.add(3, 4);
       */

        //测试proxy2
        ApplicationContext ac = new ClassPathXmlApplicationContext("/com/study/spring/spring03/conf/aop.xml");
        MathI math = ac.getBean("mathImpl", MathI.class);
        System.out.println(math.getClass().getName());
        int i = math.div(4, 1);
        System.out.println(i);
    }


}
