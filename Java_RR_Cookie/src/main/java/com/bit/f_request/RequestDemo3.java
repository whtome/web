package com.bit.f_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;


/**
 * 通用获取参数
 */
public class RequestDemo3 extends HttpServlet {

    //get方式获取参数
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println(request.getMethod());
        System.out.println("--------------");
        //get方式获取参数getQuerySting() ; url?username=xxx&password...
       /* String queryString = request.getQueryString();

        System.out.println(queryString);*/

        //get/post方式通用获取参数
        //getParameter(String name):通过参数名称获取参数值
        //tomcat8.0以上:自动解决参数值中文问题
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"="+password);

        System.out.println("---------------------");
        //getParameterNames():获取所有的参数名称对应内容: 返回值Enurmation
        Enumeration<String> enums = request.getParameterNames();
        while(enums.hasMoreElements()){
            String paramName = enums.nextElement();
            String paramValue = request.getParameter(paramName);
            System.out.println(paramName+"="+paramValue);
        }

        System.out.println("---------------------");
        //getParamterMap:Map<String(参数名称),String[] (将同名的所有参数值存储到字符串数组)>
        Map<String, String[]> map = request.getParameterMap();
        /**
         * Map集合遍历
         *  1)获取键值对对象entrySet()
         *  2)获取所有的键对象
         */
        Set<Map.Entry<String, String[]>> entrySet = map.entrySet();
        for(Map.Entry<String,String[]> entry: entrySet){
            //拿到键值对
            //getkey():获取键
            //getValue:获取值
            String paramName = entry.getKey();
            String[] paramValue = entry.getValue();
            System.out.println(paramName+"="+paramValue[0]);
        }


    }

    //Post方式获取参


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //复用doGet()
        doGet(request,response);
/*

        //post方式解决乱码
        request.setCharacterEncoding("utf-8");
        System.out.println(request.getMethod());
        System.out.println("--------------");
        *//**
         * 请求行
         * 请求头
         *
         * formData :实体内容
         * username=xxx&password=XXX
         *//*
        //通过字节输入流的方式读取实体内容
        *//*InputStream in = request.getInputStream();
        byte[] buff = new byte[1024] ;
        int len = 0 ;
        while((len=in.read(buff))!=-1){
            String content = new String(buff,0,len) ;
            System.out.println(content);
         }*//*

        //getParameterNames():获取所有的参数名称对应内容: 返回值Enurmation
        Enumeration<String> enums = request.getParameterNames();
        while(enums.hasMoreElements()){
            String paramName = enums.nextElement();
            String paramValue = request.getParameter(paramName);
            System.out.println(paramName+"="+paramValue);
        }*/



    }
}