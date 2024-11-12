package com.example.EmployeeDataInExcel.response;

public class MessageInfo {
    private String msgCode;
    private String msg;
    private String msgDescription;

    public MessageInfo(String msgCode, String msg, String msgDescription) {
        this.msgCode = msgCode;
        this.msg = msg;
        this.msgDescription = msgDescription;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgDescription() {
        return msgDescription;
    }

    public void setMsgDescription(String msgDescription) {
        this.msgDescription = msgDescription;
    }
}
