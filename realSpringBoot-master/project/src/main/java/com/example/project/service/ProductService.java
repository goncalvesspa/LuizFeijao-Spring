package com.example.project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;



import com.example.project.domain.Customer;
import com.example.project.domain.Product;
import com.example.project.domain.Supplier;
import com.example.project.repository.CustomerRepository;
import com.example.project.repository.ProductRepository;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }




    public String upload(MultipartFile file, Integer id) {
		String dirName = File.separator + "temp";
		File dir = new File(dirName);
		
		if (!dir.exists()) dir.mkdir();
		
		String filename = file.getOriginalFilename();
		File destFile = new File(dir + File.separator + filename);
		
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
        }
        
        return destFile.getName();
    }
    


    public Product putImagem(Integer id, String imagemm){ //Metodo que salva o nome da imagem no banco
        Product p = productRepository.findById(id).get();
        
        p.setImagem(imagemm);
        return productRepository.save(p);
    }

   /*  public Product putImagens(Integer id){

        Product resposta = new Product();
        resposta = findById(id);


    } */


    private static final String FILE_NAME = "/Luiz/realSpringBoot-master/docs/decola.xlsx";
    //public Object uploadExcel(MultplartFile file){} //isso aqui pode substituir os dois metodos
    public static void main(String[] args) {
 
        int count = o;
        
        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Row currentRow = iteratorRow.next();
                    Product produto = new Product();
                    Supplier supplier = new Supplier()
                    
                    
                    //Cell currentCell = cellIterator.next();

                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                   
                    if(currentRow.getRowNum() > 0){

                        Iterator<Cell> iteratorCell = currentRow.iterator();

                        Cell currentCell = iterator.next();

                        currentCell = iteratorCell.next();
                        produto.setProductName(currentCell.getStringCellValue());

                        currentCell = iteratorCell.next();
                        Double value = currentCell.getNumericCellValue();
                        suplier.setId(value.intValue());
                        produto.setSupplierId(supplier);

                        currentCell = iteratorCell.next();
                        produto.setUnitPrice(currentCell.getStringCellValue());

                        currentCell = iteratorCell.next();
                        produto.setNamePackage(currentCell.getStringCellValue());

                        currentCell = iterator.next();
                        int valueVerific = (int) currentCell.getNumericCellValue();

                        if(valueVerific == 0){}

                    }
                   
                    if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();
                productRepository.save(produto);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
 }

