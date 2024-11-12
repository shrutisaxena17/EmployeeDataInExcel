package com.example.EmployeeDataInExcel.response;

public class EmployeeResponseEntity {
    private MessageInfo msgInfo;
    private PayLoad payload;

    public EmployeeResponseEntity(MessageInfo msgInfo, PayLoad payload) {
        this.msgInfo = msgInfo;
        this.payload = payload;
    }

    public MessageInfo getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(MessageInfo msgInfo) {
        this.msgInfo = msgInfo;
    }

    public PayLoad getPayload() {
        return payload;
    }

    public void setPayload(PayLoad payload) {
        this.payload = payload;
    }
}
