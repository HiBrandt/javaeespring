package com.study.spring.spring02;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.spring.spring02.controller.UserController;
import com.study.spring.spring02.dao.UserDaoImpl;
import com.study.spring.spring02.service.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @program: javaeessm
 * @description: Spring笔记02
 * @author: HiBrandt
 * @create: 2020-08-17 21:22
 *
 * Spring bean的作用域：其实就是多例和单例还有请求和会话 （singleton、prototype）
 *   --> 可以在<bean>元素的scope属性里设置bean的作用域，(单例还是多例)(默认是单例)(当为单例时重复getbean获取的还是equals比较为true)
 *   --> 当为单例时会在创建IOC容器时就创建bean对象实例，当是多例时会在获取bean的实例时创建bean的实例对象
 * Spring bean的生命周期：
 *   ①创建bean实例
 *   ②为bean的属性设置值
 *   ③前置处理器
 *   ④调用bean的初始化方法
 *   ⑤后置处理器
 *   ⑥bean可以使用了
 *   ⑦销毁方法（调用close方法时才会触发）（想调用close方法必须使用子类，子类方法更丰富）
 * 注意：
 *       ③和⑤是可选的  需要实现 BeanPostProcessor接口  其影响范围是整个ioc容器中的bean实例 （后置处理器记得把bean返回）
 *       在配置bean时,init-method和destroy-method 属性为bean指定初始化和销毁方法
 * 使用外部的属性文件:
 *    ①创建外部文件
 *    ②在spring中配置 加载配置文件 用的也是 bean标签
 *    ③下面的配置用 ${}
 * 处理流程：
 *  Contronller接收客户端请求,Service层处理逻辑,Dao持久层数据落地,再把数据返回给Service,接着返回给Contronller,最终响应到客户端
 *
 *  学了半天根本不会用到xml文件配置bean  开发中还是用的注解去配置bean,加了注解就相当于在xml文件中加了bean标签
 *  理解：组件就是bean bean就是对象的类
 *   1)	普通组件：@Component  标识一个受Spring IOC容器管理的组件
 *   2)	持久化层组件：@Repository 标识一个受Spring IOC容器管理的      持久化层    组件
 *   3)	业务逻辑层组件：@Service 标识一个受Spring IOC容器管理的       业务逻辑层   组件
 *   4)	表述层控制器组件：@Controller 标识一个受Spring IOC容器管理的  控制层       组件
 *
 *   指定被扫描的package： <context:component-scan base-package="com.atguigu.component"/>
 *   将会扫描包下的所有类/多个包可以逗号分隔/如果仅仅希望扫描特定的类（下一行）
 *     --><context:include-filter> 表示包含的目标类  annotation（包含哪些注解）/assignable（包含哪些类）
 *       -->use-default-filters 必须设置为false  可以写多个包含
 *     --><context:exclude-filter> 表示要排除在外的目标类   annotation（排除哪些注解）/assignable（排除哪些类）
 *       -->use-default-filters 必须设置为true  可以写多个排除
 *
 *     关于  use-default-filters默认是扫描全部 如果是排除的话必须是扫描全部才能排除啊  如果是包含就不用扫描全部
 *   getbean时，默认id为 类名首字母小写
 *
 * 自动装配：不需要明确指定，Spring自动将匹配的属性值注入bean中。（属性需要ref的那种 不是字面量 不然byType就太局限了）
 * 手动装配：以value或ref的方式明确指定属性值都是手动装配。
 *    -->两种形式  autowire=“byType”和autowire=“byName” （都有局限性）
 * 正确的方法是用注解  @Autowired  前提是bean的xml文件里面必须配置好相应类型的bean或者是注解扫描
 *    -->@Qualifiter(value = "beanID")注解可以指定注入bean的名称，必须配合@Autowired使用 -->UserServiceImpl
 *      -->(比如两个实现类都符合注入的条件，就要指定是哪个类了 UserServiceImpl和dao包下)
 * 不重要：@controller可以自己设置beanID
 * 注意重要：在 @Autowired自动装配时 默认使用的是byType 此时要求Spring容器中 只 有一个能为其赋值
 *    -->如果byType实现不了自动装配 则会自动切换到byName，此时要求Spring容器中 有一个bean的id和属性名一致（private UserDao userDao中有bean的ID为userDao）
 *
 *
 *~~~~如果仅仅是加了注解其实spring根本不会管理这些组件  必须在配置文件中去扫描 才能让加了注解的bean让spring去管理
 *
 **/
public class StudySpring02 {

    public static void main(String[] args) throws SQLException {

          //测试生命周期

//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/com/study/spring/spring02/conf/applicationContext.xml");
//
//        Person p1 = ac.getBean("person", Person.class);
//
//        System.out.println(p1);
//
//        ac.close();


          //测试配置属性文件
          ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/com/study/spring/spring02/conf/applicationContext2.xml");
          DruidDataSource datasource = ac.getBean("datasource", DruidDataSource.class);
          System.out.println(datasource.getConnection());
          ac.close();
//
//          //测试注解配置bean
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/com/study/spring/spring02/conf/applicationContext3.xml");
//        //默认id为首字母小写的类名
//        UserDaoImpl userDaoImpl = ac.getBean("userDaoImpl", UserDaoImpl.class);
//        System.out.println(userDaoImpl);
//        UserServiceImpl userServiceImpl = ac.getBean("userServiceImpl", UserServiceImpl.class);
//        System.out.println(userServiceImpl);
//        UserController userController = ac.getBean("userController", UserController.class);
//        System.out.println(userController);
//
//        //controller->service->dao  里面就是new对象调方法  接口抽象方法 实现类去实现
//        userController.addUser();


    }
}
