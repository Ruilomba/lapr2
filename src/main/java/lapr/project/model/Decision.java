/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author RuiSL
 */
public class Decision {
    private static final long serialVersionUID = 2L;
    private boolean acceptance;
    private String justificacao;

    
    
    public Decision(){
        acceptance=false;
    }
    public Decision(boolean decision, String justificacao){
        this.acceptance=decision;
        this.justificacao=justificacao;
    }
    /**
     * @return the acceptance
     */
    public boolean getDecision() {
        return acceptance;
    }

    /**
     * @return the justificacao
     */
    public String getJustificacao() {
        return justificacao;
    }

    /**
     * @param decision the acceptance to set
     */
    public void setDecision(boolean decision) {
        this.acceptance = decision;
    }

    /**
     * @param justificacao the justificacao to set
     */
    public void setJustificacao(String justificacao) {
        this.justificacao = justificacao;
    }
}
