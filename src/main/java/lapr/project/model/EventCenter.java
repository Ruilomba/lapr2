package lapr.project.model;

import java.io.Serializable;

public class EventCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    private EventRegistration eventRegistration;
    private UserRegistration userRegistration;
    private StandRegistration standRegistration;
    private AlgorithmRegistration algorithmRegistration;
    private ApplicationRegistration appRegistration;
    //    private AlgorithmRegistration algorithmRegistration;

    public EventCenter() {
        eventRegistration = new EventRegistration();
        userRegistration = new UserRegistration();
        algorithmRegistration = new AlgorithmRegistration(AlgorithmRegistration.initializeAlgorithmRegister());
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

    public ApplicationRegistration getApplicationRegistration() {
        return appRegistration;
    }

    /**
     * @return the algorithmRegistration
     */
    public AlgorithmRegistration getAlgorithmRegistration() {
        return algorithmRegistration;
    }

    public float getGlobalSubmissionAverageRating(){
        float submissionCount = 0;
        float sum = 0;

        for(Event e : eventRegistration.getEventList()){
            for (Application app : e.getApplicationRegistration().getApplicationListElements()){
                for(FAERating f : app.getRatings()){
                    sum += f.getAverageRating();
                    submissionCount += 1;
                }
            }
        }
        return submissionCount > 0 ? sum/submissionCount : 0;
    }

}