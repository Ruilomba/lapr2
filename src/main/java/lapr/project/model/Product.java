/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author teixe
 */
public class Product {
    
    /**
     * Product designation
     */
    private String productName;

/**
 * 
 * @param productName 
 */
    public Product(String productName) {
        this.productName = productName;
    }
    
    public void setProductName(String product){
        this.productName = product;
    }
    

    
    @Override
    public String toString(){
        return productName;
    }
    
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!this.productName.equals(other.productName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.productName);
        return hash;
    }


}
