/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Miguel Barros
 */
public class Stand {

    private String name;

    private double area;

    /**
     * Constructor class Stand
     *
     * @param name
     * @param area
     */
    public Stand(String name, double area) {

        this.name = name;

        this.area = area;

    }

    /**
     * Empty Constructor
     */
    public Stand() {

    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * the area
     *
     * @return
     */
    public double getArea() {
        return area;
    }

    /**
     * area the area to set
     *
     * @param area
     */
    public void setLocal(double area) {
        this.area = area;
    }

    @Override
    public String toString() {

        return "Stand Name:" + name + "Area:" + area;
    }

    /**
     * Boolean validation method
     *
     * @return
     */
    public boolean valida() {

        if (name == null || name.equals("")) {

            if (!name.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$")) {
                return false;
            }

        }

        return true;

    }

}
