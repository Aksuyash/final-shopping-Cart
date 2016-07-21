/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CsuEastBay.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class Item implements Serializable{
    private String name;
    private String description;
    private double price;
    private String date;
    private int id;
    private ArrayList<String> imgText = new ArrayList();

    public Item(String name, String description, Double price, String date, int id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.date = date;
        this.id = id;
    }
    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<String> getImgText() {
        return imgText;
    }

    public void setImgText(ArrayList<String> imgText) {
        this.imgText = imgText;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return id;
    }
        
        
    
    
}
