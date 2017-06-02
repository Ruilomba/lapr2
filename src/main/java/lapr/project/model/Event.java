package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import lapr.project.states.EventCreatedState;
import lapr.project.states.EventState;
import lapr.project.states.EventStateClosedApplications;
import lapr.project.states.EventStateDefinedFAE;
import lapr.project.states.EventStateReceivingApplications;
import lapr.project.states.SetEventStateToClosedApplications;
import lapr.project.states.SetEventStateToReceivingAplications;
import lapr.project.states.StartingEventState;


    public class Event implements Serializable {


    private String title;
    private String eventDescription;
    private String local;
    private Date startDate;
    private Date endDate;
    private FAEList faeList;
    private OrganizerRegistration organizerRegistration;
    private ApplicationRegistration applicationRegistration;
    private AtribuitionList atribuitionList;
    private Date startingSubmissionDate;
    private Date endingSubmissionDate;
    private EventType eventType;
    private EventState eventState;

    
    
    public Event() {
        this.organizerRegistration = new OrganizerRegistration();
        this.faeList = new FAEList();
        this.applicationRegistration = new ApplicationRegistration();
        this.atribuitionList = new AtribuitionList();
        this.endDate = new Date();
        this.startDate = new Date();
        this.startingSubmissionDate = new Date();
        this.eventType=new Exhibition();
        this.eventState=new StartingEventState();
    }
    
    public Event(EventType eventType,String title,
            String descricao, String local, Date dataInicio, Date dataFim, Date dataInicioSubmissao,
            Date dataFimSubmissao, OrganizerRegistration registoOrganizadores, FAEList listaFae) {
        this.eventType=eventType;
        this.title = title;
        this.eventDescription = descricao;
        this.local = local;
        this.startDate = dataInicio;
        this.endDate = dataFim;
        this.startingSubmissionDate = dataInicioSubmissao;
        this.endingSubmissionDate = dataFimSubmissao;
        this.organizerRegistration = new OrganizerRegistration(registoOrganizadores);
        this.faeList = new FAEList(listaFae);

        this.applicationRegistration = new ApplicationRegistration();
        this.atribuitionList = new AtribuitionList();
    }   
    
    public void autoSetToClosedApplications(){
        Timer timer = new Timer();
        timer.schedule(new SetEventStateToClosedApplications(this), endingSubmissionDate);
    }
    public void autoSetToReceivingApplications(){
        Timer timer = new Timer();
        timer.schedule(new SetEventStateToReceivingAplications(this), startingSubmissionDate);
    }
    public boolean setCreated(){
        if(this.eventState instanceof StartingEventState) {
            this.eventState= new EventCreatedState();
            return true;
        }
        return false;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the eventDescription
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @return the faeList
     */
    public FAEList getFaeList() {
        return faeList;
    }

    /**
     * @return the organizerRegistration
     */
    public OrganizerRegistration getOrganizerRegistration() {
        return organizerRegistration;
    }

    /**
     * @return the applicationRegistration
     */
    public ApplicationRegistration getApplicationRegistration() {
        return applicationRegistration;
    }

    /**
     * @return the atribuitionList
     */
    public AtribuitionList getAtribuitionList() {
        return atribuitionList;
    }

    /**
     * @return the startingSubmissionDate
     */
    public Date getStartingSubmissionDate() {
        return startingSubmissionDate;
    }

    /**
     * @return the endingSubmissionDate
     */
    public Date getEndingSubmissionDate() {
        return endingSubmissionDate;
    }

    /**
     * @return the eventType
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * @return the eventState
     */
    public EventState getEventState() {
        return eventState;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param eventDescription the eventDescription to set
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @param faeList the faeList to set
     */
    public void setFaeList(FAEList faeList) {
        this.faeList = faeList;
    }

    /**
     * @param organizerRegistration the organizerRegistration to set
     */
    public void setOrganizerRegistration(OrganizerRegistration organizerRegistration) {
        this.organizerRegistration = organizerRegistration;
    }

    /**
     * @param applicationRegistration the applicationRegistration to set
     */
    public void setApplicationRegistration(ApplicationRegistration applicationRegistration) {
        this.applicationRegistration = applicationRegistration;
    }

    /**
     * @param atribuitionList the atribuitionList to set
     */
    public void setAtribuitionList(AtribuitionList atribuitionList) {
        this.atribuitionList = atribuitionList;
    }

    /**
     * @param startingSubmissionDate the startingSubmissionDate to set
     */
    public void setStartingSubmissionDate(Date startingSubmissionDate) {
        this.startingSubmissionDate = startingSubmissionDate;
    }

    /**
     * @param endingSubmissionDate the endingSubmissionDate to set
     */
    public void setEndingSubmissionDate(Date endingSubmissionDate) {
        this.endingSubmissionDate = endingSubmissionDate;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    /**
     * @param eventState the eventState to set
     */
    public void setEventState(EventState eventState) {
        this.eventState = eventState;
    }

    
    
    
}
