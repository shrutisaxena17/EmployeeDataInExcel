package com.example.EmployeeDataInExcel.controller;

import com.example.EmployeeDataInExcel.response.EmployeeResponseEntity;
import com.example.EmployeeDataInExcel.service.EmployeeService;
import com.example.EmployeeDataInExcel.response.MessageInfo;
import com.example.EmployeeDataInExcel.response.PayLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/generate-excel")
    public ResponseEntity<EmployeeResponseEntity> generateExcel(@RequestParam int empId) throws IOException {
        try {
            byte[] excelData = employeeService.generateEmployeeExcel(empId);
            String base64EncodedData = Base64.getEncoder().encodeToString(excelData);

            PayLoad payload = new PayLoad(base64EncodedData, "employee_data.xlsx");
            MessageInfo msgInfo = new MessageInfo(
                    String.valueOf(HttpStatus.OK.value()),
                    "Success",
                    "Response Generated Successfully"
            );

            EmployeeResponseEntity responseEntity = new EmployeeResponseEntity(msgInfo, payload);

            return ResponseEntity.ok(responseEntity);
        } catch (Exception e) {
            MessageInfo msgInfo = new MessageInfo(
                    String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    "Failure",
                    "Response was not generated"
            );
            EmployeeResponseEntity responseEntity = new EmployeeResponseEntity(msgInfo, null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseEntity);
        }
    }
}
