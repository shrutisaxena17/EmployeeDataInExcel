package com.example.EmployeeDataInExcel.response;

public class PayLoad {
    String actualDocument;
    String fileName;

    public PayLoad(String actualDocument, String fileName) {
        this.actualDocument = actualDocument;
        this.fileName = fileName;
    }

    public String getActualDocument() {
        return actualDocument;
    }

    public void setActualDocument(String actualDocument) {
        this.actualDocument = actualDocument;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
