/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtributionAlgorithms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    /**
     * @param aPRETENDED_FAE the PRETENDED_FAE to set
     */
    public static void setPRETENDED_FAE(int aPRETENDED_FAE) {
        PRETENDED_FAE = aPRETENDED_FAE;
    }

    public AtribuitionByNumerOfFae() {

    }

    @Override
    public AtribuitionList getAlgorithmAtribuitionList(Event e) {
        Scanner in= new Scanner(System.in);
        List<Application> applicationsWithoutAtribuition = e.getApplicationsWithoutAtribuition();
        FAEList eventFaeList = e.getFaeList();

        if (applicationsWithoutAtribuition.isEmpty() || eventFaeList.isEmpty()) {
            return new AtribuitionList();
        }
        System.out.println("What is the number of Fae you would like in each application?");
        int n=in.nextInt();
        setPRETENDED_FAE(n);
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
