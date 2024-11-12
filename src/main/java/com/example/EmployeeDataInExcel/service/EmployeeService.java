package com.example.EmployeeDataInExcel.service;

import com.example.EmployeeDataInExcel.exception.EmployeeIdNotFound;
import com.example.EmployeeDataInExcel.repo.EmployeeRepo;
import com.example.EmployeeDataInExcel.entity.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    public byte[] generateEmployeeExcel(int empId) throws IOException {
        List<Employee> employees = employeeRepository.findEmployeeByEmpId(empId);

        if (employees.isEmpty()) {
            throw new EmployeeIdNotFound("Employee not found");
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employee Details");

        String[] headers = {"Emp ID", "Name", "Salary", "Department", "Address", "Education"};


        for (int i = 0; i < headers.length; i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(headers[i]);
        }


        int colNum = 1;
        for (Employee employee : employees) {
            Row row1 = sheet.getRow(0);
            row1.createCell(colNum).setCellValue(employee.getEmpId());

            Row row2 = sheet.getRow(1);
            row2.createCell(colNum).setCellValue(employee.getName());

            Row row3 = sheet.getRow(2);
            row3.createCell(colNum).setCellValue(employee.getSalary());

            Row row4 = sheet.getRow(3);
            row4.createCell(colNum).setCellValue(employee.getDepartment());

            Row row5 = sheet.getRow(4);
            row5.createCell(colNum).setCellValue(employee.getAddress());

            Row row6 = sheet.getRow(5);
            row6.createCell(colNum).setCellValue(employee.getEducation());

            colNum++;
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
}
