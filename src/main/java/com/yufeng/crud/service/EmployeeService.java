package com.yufeng.crud.service;

import com.yufeng.crud.bean.Employee;
import com.yufeng.crud.bean.EmployeeExample;
import com.yufeng.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

     @Autowired
     EmployeeMapper employeeMapper;
     public List<Employee> getAll() {
          return employeeMapper.selectByExampleWithDept(null);
     }

     /**
      * 员工保存方法
      * @param employee
      */
     public void saveEmp(Employee employee) {
          employeeMapper.insertSelective(employee);
     }

     /**
      * 检验用户名是否可用
      * true 可用
      * @param empName
      * @return
      */
     public boolean checkUser(String empName) {
          EmployeeExample example = new EmployeeExample();
          EmployeeExample.Criteria criteria = example.createCriteria();
          criteria.andEmpNameEqualTo(empName);
          long count = employeeMapper.countByExample(example);
          return count == 0;
     }

     /**
      * 按照员工id查询员工
      * @param id
      * @return
      */
     public Employee getEmp(Integer id) {
          // TODO Auto-generated method stub
          Employee employee = employeeMapper.selectByPrimaryKey(id);
          return employee;
     }

     /**
      * 員工更新
      * @param employee
      */
     public void updateEmp(Employee employee) {
          employeeMapper.updateByPrimaryKeySelective(employee);
     }

     /**
      * 员工删除
      * @param id
      */
     public void deleteEmp(Integer id) {
          employeeMapper.deleteByPrimaryKey(id);
     }

     /**
      * 批量删除
      * @param del_ids
      */
     public void deleteBatch(List<Integer> ids) {
          // TODO Auto-generated method stub
          EmployeeExample example = new EmployeeExample();
          EmployeeExample.Criteria criteria = example.createCriteria();
          //delete from xxx where emp_id in(1,2,3)
          criteria.andEmpIdIn(ids);
          employeeMapper.deleteByExample(example);
     }
}
