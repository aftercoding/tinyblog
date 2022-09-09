package com.aftercoding.common.lang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    @JSONField
    private int code;// 200 ok, other abnormal
    @JSONField
    private String msg;
    @JSONField
    private Object data;

    public static Result succ(Object data){
        return succ(200, "operation success", data);
    }
    public static Result succ(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg){
        return fail(400, msg, null);
    }

    public static Result fail(String msg, Object data){
        return fail(400, msg, data);
    }
    public static Result fail(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static void main(String[] args) {
        Result r = succ(100, "sean", "okok");
        String jsonOutput= JSON.toJSONString(r);
//        System.out.println(jsonOutput);

    }
}
