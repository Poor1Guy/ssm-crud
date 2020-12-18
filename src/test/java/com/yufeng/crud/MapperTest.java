package com.yufeng.crud;

import com.yufeng.crud.bean.Department;
import com.yufeng.crud.bean.Employee;
import com.yufeng.crud.dao.DepartmentMapper;
import com.yufeng.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao的工作
 * 推荐使用spring的单元测试 可以自动注入我们的组件
 * 1、导入springtest依赖
 * 2、@ContextConfiguration指定spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

     @Autowired
     DepartmentMapper departmentMapper;

     @Autowired
     EmployeeMapper employeeMapper;

     @Autowired
     SqlSession sqlSession;
     @Test
     public void testCRUD(){
        //原生测试方法
        /*//1,创建springIOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2,从容器中获取mapper
        DepartmentMapper ben = ioc.getBean(DepartmentMapper.class);*/

             System.out.println(departmentMapper);

        //1、插入几个部门
        //departmentMapper.insertSelective(new Department(null,"开发部"));
        //departmentMapper.insertSelective(new Department(null,"测试部"));

        //2、生成员工数据
          employeeMapper.insertSelective(new Employee(null, "Phone", "M", "Phone@qq.com", 1));

          //3、批量插入多个员工,使用可以执行批量操作的sqlSession
          /*for(){
               employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "jerry@qq.com", 1));
          }*/
          EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
          for(int i=0; i<200;i++){
               String uid = UUID.randomUUID().toString().substring(0,5) + i;
               mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
          }

          /*for(int i=1000;i<2000;i++){
               employeeMapper.deleteByPrimaryKey(i);
          }
          System.out.println("删除完成");
           */
          System.out.println("任务完成！！！");
     }
}
