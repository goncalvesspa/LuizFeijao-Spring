package com.example.project.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import com.example.project.domain.Product;
import com.example.project.domain.Supplier;

public class ReadExcelService {

    private static final String FILE_NAME = "/Luiz/realSpringBoot-master/docs/decola.xlsx";



    @Autowired
    ProductService productService;
    @Autowired
    SupplierService supplierService;

    

       
    
    public String read() {
        int count = 0;
        String message = "";
        Calendar inicio;
        Calendar fim;
        Product entity = new Product();

        inicio = Calendar.getInstance();

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            iterator.next();

            while (iterator.hasNext()) {

                

                Row currentRow = iterator.next();
                

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "abc";
    }
}












/* 

package com.example.project.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import com.example.project.domain.Product;
import com.example.project.domain.Supplier;

@Service
public class ReadExcelService {

    private static final String FILE_NAME = "/Roney/Java/realSpringBoot-master/decola.xlsx";

    @Autowired
    ProductService productService;
    @Autowired
    SupplierService supplierService;

    public String read() {
        int count = 0;
        String message = "";
        Calendar inicio;
        Calendar fim;
        Product entity = new Product();
        inicio = Calendar.getInstance();
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                entity = Product.builder()//
                        .productName(currentRow.getCell(1).getStringCellValue())//
                        .supplierId(Supplier.builder()//
                                .supplierId((int) (currentRow.getCell(2).getNumericCellValue()))//
                                .build())//
                        .unitPrice(currentRow.getCell(3).getNumericCellValue())//
                        .packageName(currentRow.getCell(4).getStringCellValue())//
                        .discontinued(((int) currentRow.getCell(5).getNumericCellValue()) == 1)//
                        .build();
                workbook.close();
                count++;
                productService.saveBatch(entity);
                // productRepository.save(entity);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fim = Calendar.getInstance();
        message += "Foram salvos " + count + " registros\n"//
                + "Inicio da gravação " + inicio.getTime() + "\n"//
                + "Fim da gravação " + fim.getTime() + "\n" + "Duração da gravação: "
                + (fim.getTimeInMillis() - inicio.getTimeInMillis()) / 1000 + "s";
        System.out.println(message);
        return message;
    }
} */