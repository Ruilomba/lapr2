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
public class AtribuitionRegistration {

    private List<Atribuition> atribuitionList;

    public AtribuitionRegistration() {
        this.atribuitionList = new ArrayList<>();
    }

    /**
     * @return the atribuitionList
     */
    public List<Atribuition> getAtribuitionListElements() {
        return atribuitionList;
    }

    public Atribuition newAtribuition(Application c, List<FAE> faeList) {
        return new Atribuition(c, faeList);
    }

    /**
     * @param atribuitionList the atribuitionList to set
     */
    public void setAtribuitionList(List<Atribuition> atribuitionList) {
        this.atribuitionList = atribuitionList;
    }

    public boolean hasApplication(Application a) {
        for (Atribuition at : atribuitionList) {
            if (at.isFromApplication(a)) {
                return true;
            }
        }
        return false;
    }

    public int getAtribuitionsNumberOfFae(FAE fae) {
        int i = 0;
        for (Atribuition a : atribuitionList) {
            if (a.isFromFAE(fae)) {
                i++;
            }
        }
        return i;
    }

    public void registerAtribuition(Atribuition a) {
        atribuitionList.add(a);
    }

    public List<Atribuition> getAtribuitionListOfFae(FAE fae) {
        List<Atribuition> atrList = new ArrayList<Atribuition>();
        for (int i = 0; i < this.atribuitionList.size(); i++) {
            List<FAE> temp = this.atribuitionList.get(i).getFaeList();
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).getUser().equals(fae)) {
                    atrList.add(this.atribuitionList.get(i));
                }
            }

        }

        return atrList;
    }
}
