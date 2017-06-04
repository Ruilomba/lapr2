package lapr.project.model;

import java.io.Serializable;

public class EventCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    private EventRegistration eventRegistration;
    private UserRegistration userRegistration;
    private StandRegistration standRegistration;
    private AlgorithmRegistration algorithmRegistration;
//    private AlgorithmRegistration algorithmRegistration;

    public EventCenter() {
        eventRegistration = new EventRegistration();
        userRegistration = new UserRegistration();
        algorithmRegistration = new AlgorithmRegistration();
    }

    public EventRegistration getEventRegistration() {
        return eventRegistration;
    }

    public UserRegistration getUserRegistration() {
        return userRegistration;
    }

    public StandRegistration getStandRegistration() {
        return standRegistration;
    }
}

/*
 public AlgorithmRegistration getAlgorithmRegistration(){
 return algorithmRegistration;
 }

 public void setEventRegistration(EventRegistration eventRegistration) {
 this.eventRegistration = eventRegistration;
 }

 public void setUserRegistration(UserRegistration userRegistration) {
 this.userRegistration = userRegistration;
 }

 public void setAlgorithmRegistration(AlgorithmRegistration algorithmRegistration) {
 this.algorithmRegistration = algorithmRegistration;
 }
 */
