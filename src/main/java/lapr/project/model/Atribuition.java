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
public class Atribuition {
     private Application application;
    private List<FAE> faeList;

    public Atribuition(Application c, List<FAE> faeList) {
        this.application = c;
        this.faeList = new ArrayList<>(faeList);
    }
    public Atribuition() {
        this.faeList = new ArrayList<>();
    }

    public void setFAE(FAE FAE) {

    }

    
    public List<FAE> getFaeList() {
        return faeList;
    }

    public boolean isFromFAE(FAE fae) {
        return faeList.contains(fae);
    }

    /**
     * Devolve a candidatura à qual corresponde a atribuição
     *
     * @return candidatura
     */
    public Application getApplication() {
        return application;
    }

    /**
     * Verifica se a atribuição é respectiva à candidatura
     *
     * @param c candidatura a verificar
     * @return true se corresponder, senão false
     */
    public boolean isFromApplication(Application c) {
        return application.equals(c);
    }

    /**
     * Devolve a lista de FAE definida para a avaliação
     *
     * @return lista de FAE
     */
    public boolean hasFae(FAE faeAux) {
        for(FAE fae : faeList) {
            if(fae.equals(faeAux)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String s = "";
        for(FAE fae : faeList) {
            s = s.concat(fae.toString() + "\n");
        }
        return String.format("Candidatura: %s %nFAE: %s", application.toString(), s);
    }
}
