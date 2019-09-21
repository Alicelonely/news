package cn.zk.servlet;

import cn.zk.entity.Summary;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DemoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String first = request.getParameter("first");           //从前端获取数据first
        String second = request.getParameter("second");         //从前端获取数据second
        String result=first+second;                                 //用于测试 ，判断是否成功获取到数据；

        Summary summary = new Summary(1,"台湾","台湾实践","2019-4-5","1.jpg","东升",1,"国内");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("summary",summary);
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add(jsonObject);
        out.println(jsonObject.toString());                  //将数据传到前端
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }



}
