/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.Serializable;

/**
 *
 * @author RuiSL
 */
public class DataInvalidaException extends IllegalArgumentException{

    /**
     * Creates a new instance of <code>DataInvalidaException</code> without
     * detail message.
     */
    public DataInvalidaException() {
        super("Data inválida!!");
    }

    /**
     * Constructs an instance of <code>DataInvalidaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DataInvalidaException(String msg) {
        super(msg);
    }
}
