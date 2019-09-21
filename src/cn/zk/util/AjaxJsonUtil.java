package cn.zk.util;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AjaxJsonUtil {


    private boolean success = true;


    private List<String> errMsg = null;


    private String msg = "操作成功";


    private Object obj = null;

    private Map<String, Object> attributes;


    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    ;


    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }


    public String getMsg() {
        String eMsg = "";
        if ((this.errMsg != null) && (this.errMsg.size() > 0)) {
            for (String str : this.errMsg) {
                eMsg = eMsg + str + "<br/>";
            }
        }
        if (eMsg.equals("")) {
            eMsg = this.msg;
        }
        return eMsg;
    }


    public void setMsg(String msg) {
        if (this.errMsg == null) {
            this.errMsg = new ArrayList();
        }
        this.msg = msg;
        this.errMsg.add(msg);
    }


    public String getErrMsg() {
        String eMsg = "";
        if ((this.errMsg != null) && (this.errMsg.size() > 0)) {
            for (String str : this.errMsg) {
                eMsg = eMsg + str + "<br/>";
            }
        }
        return eMsg;
    }


    public Object getObj() {
        return this.obj;
    }


    public void setObj(Object obj) {
        this.obj = obj;
    }


    public boolean isSuccess() {
        return this.success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getJsonStr() {
        JSONObject obj = new JSONObject();
        obj.put("success", Boolean.valueOf(isSuccess()));
        obj.put("msg", getErrMsg());
        obj.put("obj", this.obj);
        obj.put("attributes", this.attributes);
        return obj.toString();
    }

}