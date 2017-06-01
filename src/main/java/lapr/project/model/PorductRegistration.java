/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;

/**
 *
 * @author teixe
 */
public class PorductRegistration {

    private ArrayList<Product> listProduct;

    /**
     *
     * @param listProduct
     */
    public PorductRegistration(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    /**
     *
     */
    public PorductRegistration() {
        this.listProduct = new ArrayList<>();
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }
    
    public void addProduct(Product product){
        if(globalValidation(product)){
            listProduct.add(product);
        }
    }

    /**
     * verify if product alredy exist
     * @param product
     * @return 
     */
    public boolean globalValidation(Product product) {
        boolean validation = true;
        for (Product p : listProduct) {
            if (p.equals(product)) {
                validation = false;
                break;
            }

        }
        return true;
    }

}
