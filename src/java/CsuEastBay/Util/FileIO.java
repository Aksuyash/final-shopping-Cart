/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CsuEastBay.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author welcome
 */
public class FileIO implements Serializable{
       private String line;
       private Product product = new Product();

    public FileIO() {
    }

    public FileIO(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Product getProduct(String fileName, String productCode) throws FileNotFoundException, IOException
    {
        FileReader file_Input = new FileReader(fileName);
        BufferedReader buffer = new BufferedReader(file_Input);
        while((line = buffer.readLine()) != null){
            if (line.equals(productCode)){
                product.setName(line);
                line = buffer.readLine();
                product.setDescription(line);
                line = buffer.readLine();
                product.setValue(Integer.valueOf(line));
                break;
            }
        }	  
        return product;
    }   
}
