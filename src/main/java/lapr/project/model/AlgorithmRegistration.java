/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import AtributionAlgorithms.AtribuitionByNumerOfFae;
import AtributionAlgorithms.AttribuitionAlgorithmEquitativeLoad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RuiSL
 */
public class AlgorithmRegistration {
    private List<AtribuitionAlgorithm> algorithmList;
    
    public AlgorithmRegistration() {
        algorithmList= new ArrayList<>();
    }
    public AlgorithmRegistration( List<AtribuitionAlgorithm> algorithmList) {
        this.algorithmList = algorithmList;       
    }

    public List<AtribuitionAlgorithm> getAlgorithmList() {
        return new ArrayList<>(this.algorithmList);
    }
    
    public void setAlgorithmList(List<AtribuitionAlgorithm> algorithm) {
        algorithmList = new ArrayList<AtribuitionAlgorithm>(algorithm);
    }
    
    public static List<AtribuitionAlgorithm> initializeAlgorithmRegister (){
        List<AtribuitionAlgorithm> algorithmList= new ArrayList<>();
        algorithmList.add(new AtribuitionByNumerOfFae());
        algorithmList.add(new AttribuitionAlgorithmEquitativeLoad());
        return algorithmList;
    }
}
