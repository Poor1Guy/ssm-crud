package com.yufeng.crud.controller;

import com.yufeng.crud.bean.Department;
import com.yufeng.crud.bean.Msg;
import com.yufeng.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *每天进步一点点鸭！
  * 处理和部门有关的请求
 *@Author: lyf
 *@date : 2020/12/16 16:10
 */
 @Controller
public class DepartmentController {

      @Autowired
      private DepartmentService departmentService;

      /*
      * 返回所有部门信息*/
      @RequestMapping("/depts")
      @ResponseBody
      public Msg getDepts(){
           //查出的所有的部门信息
           List<Department> list = departmentService.getDepts();
           return Msg.success().add("depts",list);
      }
}
