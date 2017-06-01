package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import lapr.project.states.EventState;


    public class Event implements Serializable {


    private String titulo;
    private String textoDescritivo;
    private String local;
    private Date dataInicio;
    private Date dataFim;
    private FAEList FaeList;
    private OrganizerRegistration registoOrganizadores;
    private ApplicationRegistration registoCandidaturas;
    private AtribuitionList listaAtribuicoes;
    private Date dataInicioSubCandidatura;
    private Date dataFimSubCandidatura;
    private EventType tipoEvento;
    private EventState eventState;

    
}
