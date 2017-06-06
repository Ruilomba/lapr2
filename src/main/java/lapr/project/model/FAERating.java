package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

public class FAERating {
    private final FAE ratingFae;
    private final List<RatingParameter> ratingParameters;
    private float topicKnowledge;
    private float applicationsAdequency;
    private float invitationQuantity;
    private float overallRecomendation;

    /**
     * Constructor
     * @param ratingFae FAE responsible for this rating
     * @param ratingParameters Parameters to be rated
     */
    public FAERating(FAE ratingFae, List<RatingParameter> ratingParameters) {
        this.ratingFae = ratingFae;
        this.ratingParameters = ratingParameters;
    }

    public FAERating(FAE ratingFae, float topicKnowledge, float applicationsAdequency, float invitationQuantity, float overallRecomendation) {
        this.ratingFae = ratingFae;
        this.setApplicationsAdequency(applicationsAdequency);
        this.setTopicKnowledge(topicKnowledge);
        this.setInvitationQuantity(invitationQuantity);
        this.setOverallRecomendation(overallRecomendation);
        this.ratingParameters = new ArrayList<>();
    }
    /**
     * Checks if the rating belongs to the FAE
     * @return true if the rating's FAE equals the FAE
     */
    public boolean isFromFAE(FAE fae) {
        return ratingFae.equals(fae);
    }

    /**
     * Applies the FAE rating for the selected parameter
     * Throws IllegalArgumentException if the value is out of range of the parameter min and max values
     * @param ratingParameter the parameter to be rated
     * @param value value of the rating
     */
    public void applyRating(RatingParameter ratingParameter, float value){
        for (RatingParameter arp : ratingParameters) {
            if(arp.equals(ratingParameter)){
                arp.applyRating(value);
                return;
            }
        }
    }

    public void setTopicKnowledge(float topicKnowledge) {
        if(topicKnowledge < 0 || topicKnowledge > 5){
            throw new IllegalArgumentException(String.format("Rating value is out of range - range between %f and %f", 0, 5));
        }
        this.topicKnowledge = topicKnowledge;
    }

    public void setApplicationsAdequency(float applicationsAdequency) {
        if(applicationsAdequency < 0 || applicationsAdequency > 5){
            throw new IllegalArgumentException(String.format("Rating value is out of range - range between %f and %f", 0, 5));
        }
        this.applicationsAdequency = applicationsAdequency;
    }

    public void setInvitationQuantity(float invitationQuantity) {
        if(invitationQuantity < 0 || invitationQuantity > 5){
            throw new IllegalArgumentException(String.format("Rating value is out of range - range between %f and %f", 0, 5));
        }
        this.invitationQuantity = invitationQuantity;
    }

    public void setOverallRecomendation(float overallRecomendation) {
        if(overallRecomendation < 0 || overallRecomendation > 5){
            throw new IllegalArgumentException(String.format("Rating value is out of range - range between %f and %f", 0, 5));
        }
        this.overallRecomendation = overallRecomendation;
    }

    public float getTopicKnowledge() {
        return topicKnowledge;
    }

    public float getApplicationsAdequency() {
        return applicationsAdequency;
    }

    public float getInvitationQuantity() {
        return invitationQuantity;
    }

    public float getOverallRecomendation() {
        return overallRecomendation;
    }

    /**
     * Gets rating parameter by name
     * @param name rating parameter name
     * @return rating parameter
     */
    public RatingParameter getParameterByName(String name){
        for (RatingParameter rp : this.ratingParameters){
            if(rp.getName().equals(name)){
                return rp;
            }
        }
        return null;
    }

    /**
     * Gets ratings
     * @return parameter ratings
     */
    public List<RatingParameter> getParameters(){
        return this.ratingParameters;
    }

    /**
     * Gets the average rating value of the parameters for this rating
     * @return average rating
     */
    float getAverageRating(){
        float sum = this.getApplicationsAdequency() + this.getTopicKnowledge() + this.getInvitationQuantity() + this.getOverallRecomendation();
        return sum/4;
    }
    /*float getAverageRating(){
        if(ratingParameters.size() > 0){
            float averageRating = 0;
            for (RatingParameter arp : ratingParameters){
                averageRating += arp.getValue();
            }
            return averageRating/ratingParameters.size();
        }
        return 0;
    }*/
}
