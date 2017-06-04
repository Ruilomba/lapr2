/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtributionAlgorithms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.Atribuition;
import lapr.project.model.AtribuitionAlgorithm;
import lapr.project.model.AtribuitionList;
import lapr.project.model.Event;
import lapr.project.model.FAE;
import lapr.project.model.FAEList;
import lapr.project.utils.Utils;

/**
 *
 * @author RuiSL
 */
public class AtribuitionByNumerOfFae implements AtribuitionAlgorithm {

    /**
     * Número de FAE pretendidos para avaliar cada candidatura
     */
    private static int PRETENDED_FAE = 2;

    public AtribuitionByNumerOfFae() {

    }

    @Override
    public AtribuitionList getAlgorithmAtribuitionList(Event e) {
        List<Application> applicationsWithoutAtribuition = e.getApplicationsWithoutAtribuition();
        FAEList eventFaeList = e.getFaeList();

        if (applicationsWithoutAtribuition.isEmpty() || eventFaeList.isEmpty()) {
            return new AtribuitionList();
        }

        AtribuitionList atribuitionList = new AtribuitionList();
        List<FAE> listaFae = eventFaeList.getFaeListElements();
        int faeTotalNum = listaFae.size();

        for (Application c : applicationsWithoutAtribuition) {
            List<FAE> atribuitedFaeList = new ArrayList<>();
            while (atribuitedFaeList.size() < PRETENDED_FAE || atribuitedFaeList.size() < faeTotalNum) {
                int nAleatorio = Utils.generateRandom(0, faeTotalNum);
                FAE fae = listaFae.get(nAleatorio);

                if (atribuitedFaeList.contains(fae) == false) {
                    atribuitedFaeList.add(fae);
                }
            }
            Atribuition a = atribuitionList.newAtribuition(c, atribuitedFaeList);
            atribuitionList.registerAtribuition(a);
        }
        return atribuitionList;
    }

    @Override
    public String toString() {
        return String.format("Atribuição conforme o número pretendido por candidatura");
    }

}
