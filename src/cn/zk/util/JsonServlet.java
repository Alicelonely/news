package cn.zk.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonServlet {


    public static void getJson(HttpServletRequest request, HttpServletResponse response,Object object){
        response.setContentType("text/html;charset-UTF-8");
        //禁用缓存
        response.setHeader("Paragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", -10);

        PrintWriter out = null;

        try {
            out = response.getWriter();
            String jsonStr = JSON.toJSONString(object);
            out.println(jsonStr);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }

    }

}
