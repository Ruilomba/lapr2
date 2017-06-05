package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import lapr.project.states.EventState;
import lapr.project.states.EventStateDefinedFAE;
import lapr.project.states.EventStateToReceivingApplications;
import lapr.project.states.StartingEventState;

public class Event implements Serializable {

    private String titulo;
    private String textoDescritivo;
    private String local;
    private Date dataInicio;
    private Date dataFim;
    private FAEList faeList;
    private OrganizerRegistration registoOrganizadores;
    private ApplicationRegistration registoCandidaturas;
    private AtribuitionList listaAtribuicoes;
    private Date dataInicioSubCandidatura;
    private Date dataFimSubCandidatura;
    private EventType tipoEvento;
    private EventState eventState;

    public Event() {
        this.registoOrganizadores = new OrganizerRegistration();
        this.faeList = new FAEList();
        this.registoCandidaturas = new ApplicationRegistration();
        this.listaAtribuicoes = new AtribuitionList();
        this.dataFim = new Date();
        this.dataInicio = new Date();
        this.dataInicioSubCandidatura = new Date();
        this.tipoEvento = new Exhibition();
        this.eventState = new StartingEventState();
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return the textoDescritivo
     */
    public String getTextoDescritivo() {
        return textoDescritivo;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @return the FaeList
     */
    public FAEList getFaeList() {
        return faeList;
    }

    /**
     * @return the registoOrganizadores
     */
    public OrganizerRegistration getRegistoOrganizadores() {
        return registoOrganizadores;
    }

    /**
     * @return the registoCandidaturas
     */
    public ApplicationRegistration getRegistoCandidaturas() {
        return registoCandidaturas;
    }

    /**
     * @return the listaAtribuicoes
     */
    public AtribuitionList getListaAtribuicoes() {
        return listaAtribuicoes;
    }

    /**
     * @return the dataInicioSubCandidatura
     */
    public Date getDataInicioSubCandidatura() {
        return dataInicioSubCandidatura;
    }

    /**
     * @return the dataFimSubCandidatura
     */
    public Date getDataFimSubCandidatura() {
        return dataFimSubCandidatura;
    }

    /**
     * @return the tipoEvento
     */
    public EventType getTipoEvento() {
        return tipoEvento;
    }

    /**
     * @return the eventState
     */
    public EventState getEventState() {
        return eventState;
    }


    

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param textoDescritivo the textoDescritivo to set
     */
    public void setTextoDescritivo(String textoDescritivo) {
        this.textoDescritivo = textoDescritivo;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @param FaeList the FaeList to set
     */
    public void setFaeList(FAEList FaeList) {
        this.faeList = FaeList;
    }

    /**
     * @param registoOrganizadores the registoOrganizadores to set
     */
    public void setRegistoOrganizadores(OrganizerRegistration registoOrganizadores) {
        this.registoOrganizadores = registoOrganizadores;
    }

    /**
     * @param registoCandidaturas the registoCandidaturas to set
     */
    public void setRegistoCandidaturas(ApplicationRegistration registoCandidaturas) {
        this.registoCandidaturas = registoCandidaturas;
    }

    /**
     * @param listaAtribuicoes the listaAtribuicoes to set
     */
    public void setListaAtribuicoes(AtribuitionList listaAtribuicoes) {
        this.listaAtribuicoes = listaAtribuicoes;
    }

    /**
     * @param dataInicioSubCandidatura the dataInicioSubCandidatura to set
     */
    public void setDataInicioSubCandidatura(Date dataInicioSubCandidatura) {
        this.dataInicioSubCandidatura = dataInicioSubCandidatura;
    }

    /**
     * @param dataFimSubCandidatura the dataFimSubCandidatura to set
     */
    public void setDataFimSubCandidatura(Date dataFimSubCandidatura) {
        this.dataFimSubCandidatura = dataFimSubCandidatura;
    }

    /**
     * @param tipoEvento the tipoEvento to set
     */
    public void setTipoEvento(EventType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * @param eventState the eventState to set
     */
    public void setEventState(EventState eventState) {
        this.eventState = eventState;
    }

    public boolean setToReceivingAplications() {
        if (this.eventState instanceof EventStateDefinedFAE) {
            this.eventState = new EventStateToReceivingApplications();
            return true;
        }
        return false;
    }

}
