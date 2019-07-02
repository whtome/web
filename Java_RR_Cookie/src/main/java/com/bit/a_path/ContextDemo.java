package com.bit.a_path;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * 获取上下文路径
 */
public class ContextDemo extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

//        response.getWriter().write("servlet");
        ServletContext servletContext = this.getServletContext();
        //public String getContextPath():获取上下文路径
        System.out.println(servletContext.getContextPath());///Java7_web
        //xxx.jsp(El表达式) ----><a href=${pageContext.request.contextpah}"/xxServet"></a>

    }



    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
