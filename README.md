# spring5_test1
# Spring5框架—Bean管理（基于xml）
## IOC操作的Bean管理（概念）
    1、什么是Bean管理
        （0）Bean管理指的是两个操作
            （1）Spring创建对象
            （2）Spring注入属性
    2、Bean管理的操作有两种方式
        （1）基于xml配置文件方式实现
        （2）基于注解方式实现
## IOC操作Bean管理（基于xml方式）
    1、基于xml方式创建对象
    <!--    配置User对象创建-->
    <bean id="user" class="com.zh.spring5.User"></bean>
        （1）在spring配置文件中，使用bean标签，标签里面添加对相应的属性，就可以实现对象的创建
        （2）在bean便签里面有很多属性
        * id:唯一标识
        *class:类全路径（包类路径）
        （3）创建对象时候，默认执行无参构造方法

     2、基于xml方式注入属性
        （1）DI：依赖注入，就是注入属性
            1.set方式注入
```xml
<bean id="book" class="com.zh.spring5.Book">
    使用property标签完成注入
    name：类里面属性名称
    value：向属性注入的值
    <property name="bname" value="Java编程"></property>
    <property name="bauthor" value="外国人"></property>
</bean>
```
                *p名称空间注入（了解）
                1.添加p名称空间在配置文件中
                    ` xmlns:p="http://www.springframework.org/schema/p" 
                2.进行属性注入，在bean标签中进行操作
                    <!--    set方式注入属性：使用p标签-->
                        <bean id="book" class="com.zh.spring5.Book" p:bname="九阳神功" p:bauthor="无名氏">
                        </bean>
            2.有参构造注入
```xml
<bean id="orders" class="com.zh.spring5.Orders">
    使用constructor-arg标签
    <constructor-arg name="oname" value="abc"></constructor-arg>
    <constructor-arg name="address" value="China"></constructor-arg>
</bean>
```
   ## IOC操作Bean管理（xml注入其他类型属性）
        1.字面量
            (1)null值
                <!--设置null值-->
                <property name="address">
                    <null/>
                </property>
            (2)属性中包含特殊符号
                <!--属性中包含特殊符号
                    1.把<>进行转义 &lt;(小于号) &gt;(大于号)
                    2.把带特殊符号内容写到CDATA
                -->
                <property name="address">
                    <value>
                        <![CDATA[<<武汉>>]]>
                    </value>
                </property>
        2.注入属性-外部bean
            （1）创建两个类service类和dao类
            （2）在service中调用dao里面的方法
            <!--    service和dao对象创建-->
            <bean id="userService" class="com.zh.spring5.service.Userservice">
                <property name="userDao" ref="userDaoImpl"></property>
            </bean>
            <bean id="userDaoImpl" class="com.zh.spring5.dao.UserDaoImpl"></bean>
        3.注入属性-内部bean
            （1）一对多关系：部门和员工
            一个部门有多个员工，一个员工属于一个部门
            部门是一，员工是多
            （2）在实体类之间表示一对多关系，员工表示所属部门，使用对象类型进行表示
            //部门类
            public class Dept {
                private String dname;
                public void setDname(String dname) {
                    this.dname = dname;
                }
            //员工类
            public class Emp {
                private String ename;
                private String gender;
                //员工属于一个部门，使用对象形式表示
                private Dept dept;
                public void setDept(Dept dept) {
                    this.dept = dept;
                }
                public void setEname(String ename) {
                    this.ename = ename;
                }
                public void setGender(String gender) {
                    this.gender = gender;
                }
            }
            （3）在Spring配置文件中进行配置
            <!--内部bean-->
                <bean id="emp" class="com.zh.spring5.bean.Emp">
                    <!--设置两个普特属性-->
                    <property name="ename" value="lucy"></property>
                    <property name="gender" value="女"></property>
                    <!--设置对象属性-->
                    <property name="dept">
                        <bean id="dept" class="com.zh.spring5.bean.Dept">
                            <property name="dname" value="财务部"></property>
                        </bean>
                    </property>
                </bean>
        4.注入属性-级联赋值
            (1)第一种写法
            <!--级联赋值-->
                <bean id="emp" class="com.zh.spring5.bean.Emp">
                    <!--设置两个普特属性-->
                    <property name="ename" value="lucy"></property>
                    <property name="gender" value="女"></property>
                    <!--级联赋值-->
                    <property name="dept" ref="dept"></property>
                </bean>
                <bean id="dept" class="com.zh.spring5.bean.Dept">
                    <property name="dname" value="后勤部"></property>
                </bean>
               (2)第二种写法(需要先生成对象的get方法)
               <!--级联赋值-->
                   <bean id="emp" class="com.zh.spring5.bean.Emp">
                       <!--设置两个普特属性-->
                       <property name="ename" value="lucy"></property>
                       <property name="gender" value="女"></property>
                       <!--级联赋值-->
                       <property name="dept" ref="dept"></property>
                       <property name="dept.dname" value="技术部"></property>
                   </bean>
                   <bean id="dept" class="com.zh.spring5.bean.Dept"></bean>
