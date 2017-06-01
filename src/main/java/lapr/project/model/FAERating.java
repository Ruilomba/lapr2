package lapr.project.model;

import java.util.List;

public class FAERating {
    private final FAE ratingFae;
    private final List<RatingParameter> ratingParameters;

    /**
     * Constructor
     * @param ratingFae FAE responsible for this rating
     * @param ratingParameters Parameters to be rated
     */
    public FAERating(FAE ratingFae, List<RatingParameter> ratingParameters) {
        this.ratingFae = ratingFae;
        this.ratingParameters = ratingParameters;
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
     * Gets the average rating value of the parameters for this rating
     * @return average rating
     */
    float getAverageRating(){
        if(ratingParameters.size() > 0){
            float averageRating = 0;
            for (RatingParameter arp : ratingParameters){
                averageRating += arp.getValue();
            }
            return averageRating/ratingParameters.size();
        }
        return 0;
    }
}
