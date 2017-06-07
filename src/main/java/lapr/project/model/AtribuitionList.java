/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RuiSL
 */
public class AtribuitionList {
    private List<Atribuition> atribuitionList;
    
    public AtribuitionList(){
        this.atribuitionList= new ArrayList<>();
    }

    /**
     * @return the atribuitionList
     */
    public List<Atribuition> getAtribuitionListElements() {
        return atribuitionList;
    }
    public Atribuition newAtribuition(Application c , List<FAE> faeList){
        return new Atribuition(c, faeList);
    }
    /**
     * @param atribuitionList the atribuitionList to set
     */
    public void setAtribuitionList(List<Atribuition> atribuitionList) {
        this.atribuitionList = atribuitionList;
    }
    public boolean hasApplication(Application a){
        for(Atribuition at : atribuitionList){
            if(at.isFromApplication(a)){
                return true;
            }           
        }
        return false;
    }
    
    public int getAtribuitionsNumberOfFae(FAE fae){
        int i=0;
        for(Atribuition a : atribuitionList){
            if(a.isFromFAE(fae)){
                i++;
            }
        }
        return i;
    }
    public void registerAtribuition(Atribuition a) {
        atribuitionList.add(a);
    }
}
