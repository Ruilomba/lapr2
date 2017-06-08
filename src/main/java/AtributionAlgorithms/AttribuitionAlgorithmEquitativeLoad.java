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
import lapr.project.model.AtribuitionRegistration;
import lapr.project.model.Event;
import lapr.project.model.FAE;
import lapr.project.model.FAEList;
import lapr.project.utils.Utils;

/**
 *
 * @author RuiSL
 */
public class AttribuitionAlgorithmEquitativeLoad implements AtribuitionAlgorithm,Serializable {
private static final long serialVersionUID =1L;
    public AttribuitionAlgorithmEquitativeLoad() {

    }

    @Override
    public AtribuitionRegistration getAlgorithmAtribuitionList(Event e) {
        List<Application> noAtribuitionApplicationList = new ArrayList<>();
        try {
            noAtribuitionApplicationList = e.getApplicationsWithoutAtribuition();
        } catch (NullPointerException es) {
            System.out.println("Empty list");
        }
        FAEList eventFaeList = e.getFaeList();

        if (noAtribuitionApplicationList.isEmpty() || eventFaeList.isEmpty()) {
            return new AtribuitionRegistration();
        }

        AtribuitionRegistration atribuitionList = new AtribuitionRegistration();
        List<FAE> faeList = eventFaeList.getFaeListElements();
//        int[] listaNumeroAtribuicoesPorFAE = new int[listaFAE.size()];
//
//        for (int i = 0; i < listaFAE.size(); i++) {
//            listaNumeroAtribuicoesPorFAE[i] = listaAtribuicoes.getNumeroAtribuicoesFAE(listaFAE.get(i));
//        }

        for (Application c : noAtribuitionApplicationList) {
            int[] numberOfAtribuitionsByFae = new int[faeList.size()];

            for (int i = 0; i < faeList.size(); i++) {
                numberOfAtribuitionsByFae[i] = atribuitionList.getAtribuitionsNumberOfFae(faeList.get(i));
            }
            List<FAE> atribuitedFaeList = new ArrayList<>();
            int index = Utils.getMinorValueIndex(numberOfAtribuitionsByFae);
            atribuitedFaeList.add(faeList.get(index));

            Atribuition a = atribuitionList.newAtribuition(c, atribuitedFaeList);
            atribuitionList.registerAtribuition(a);
        }
        return atribuitionList;
    }

    @Override
    public String toString() {
        return String.format("Atribuition by equitative load");
    }

}
