package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import lapr.project.states.EventCreatedState;
import lapr.project.states.EventState;
import lapr.project.states.StartingEventState;
import lapr.project.utils.Data;

public class Event implements Serializable {
    private static final long serialVersionUID = 2L;
    private String title;
    private String eventDescription;
    private String local;
    private Data startDate;
    private Data endDate;
    private FAEList faeList;
    private OrganizerRegistration organizerRegistration;
    private ApplicationRegistration applicationRegistration;
    private AtribuitionList atribuitionList;
    private Data endingSubmissionDate;
    private EventType eventType;
    private EventState eventState;
    private AtribuitionStandList astdlst;

    public Event() {
        this.organizerRegistration = new OrganizerRegistration();
        this.faeList = new FAEList();
        this.applicationRegistration = new ApplicationRegistration();
        this.atribuitionList = new AtribuitionList();
        this.endDate = new Data();
        this.startDate = new Data();
        this.eventType = new Exhibition();
        this.eventState = new StartingEventState();
    }

    public Event(EventType eventType, String title,
            String descricao, String local, Data dataInicio, Data dataFim, Data dataInicioSubmissao,
            Data dataFimSubmissao, OrganizerRegistration registoOrganizadores, FAEList listaFae) {
        this.eventType = eventType;
        this.title = title;
        this.eventDescription = descricao;
        this.local = local;
        this.startDate = dataInicio;
        this.endDate = dataFim;
        this.endingSubmissionDate = dataFimSubmissao;
        this.organizerRegistration = new OrganizerRegistration(registoOrganizadores);
        this.faeList = new FAEList(listaFae);

        this.applicationRegistration = new ApplicationRegistration();
        this.atribuitionList = new AtribuitionList();
    }

    public void autoSetToClosedApplications() {
        Timer timer = new Timer();
        int year = endingSubmissionDate.getAno();
        int month = endingSubmissionDate.getMes();
        int day = endingSubmissionDate.getDia();
        //Date aux = new Date(year, month, day);
        //timer.schedule(new SetEventStateToClosedApplications(this), aux);
    } 

    public void autoSetToReceivingApplications() {
        Timer timer = new Timer();
        int year = endingSubmissionDate.getAno();
        int month = endingSubmissionDate.getMes();
        int day = endingSubmissionDate.getDia();
        //Date aux = new Date(year, month, day);
        //timer.schedule(new SetEventStateToReceivingAplications(this), aux);
    }

    public boolean setCreated() {
        if (this.eventState instanceof StartingEventState) {
            this.eventState = new EventCreatedState();
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
    
    public boolean isInState(EventState eventState){
        return this.getEventState().getClass().getSimpleName().equals(eventState.getClass().getSimpleName());
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

    public List<Application> getApplicationsWithoutAtribuition() {
        List<Application> applicationList = new ArrayList<>();
        for (Application a : applicationRegistration.getApplicationListElements()) {
            if (!atribuitionList.hasApplication(a)) {
                applicationList.add(a);
            }
        }
        return applicationList;
    }

    /**
     * @return the startDate
     */
    public Data getStartDate() {
        return startDate;
    }

    /**
     * @return the endDate
     */
    public Data getEndDate() {
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
    

    /**
     * @return the endingSubmissionDate
     */
    public Data getEndingSubmissionDate() {
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
     *
     * @param event
     * @param s
     */
    public void novaAtribuicao(Event event, Stand s) {
        astdlst.newAtribuition(event, s);
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
    public void setStartDate(Data startDate) {
        this.startDate = startDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Data endDate) {
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
    

    /**
     * @param endingSubmissionDate the endingSubmissionDate to set
     */
    public void setEndingSubmissionDate(Data endingSubmissionDate) {
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

    public void registaDados() {
        addList(astdlst);
    }

    private void addList(AtribuitionStandList astdlist) {
        this.astdlst = astdlist;
    }

    public boolean belongsToOrganizer(User u) {
        return organizerRegistration.hasOrganizer(u);
    }
    
//    @Override
//    public boolean equals(Object otherObject){
//        if(this==otherObject){
//            return true;
//        }
//        if (otherObject == null || getClass() != otherObject.getClass()) {
//            return false;
//        }
//        Event e = (Event) otherObject;
//        return this.eventDescription.equals(e.eventDescription)&& this.eventState.getClass().getSimpleName().equals(e.eventState.getClass().getSimpleName());
//    }
//    @Override
//    public int hashCode() {
//        int result = eventDescription.hashCode();
//        result = 31 * result + eventState.getClass().getSimpleName().hashCode();
//        return result;
//    }

}
