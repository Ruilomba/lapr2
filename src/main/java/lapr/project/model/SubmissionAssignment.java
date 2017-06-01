package lapr.project.model;

import java.util.List;

public class SubmissionAssignment {
    private final Application submission;
    private final List<FAE> faeList;
    private final List<FAERating> faeRatings;

    /**
     * Object constructor
     * @param submission assigned Submission
     * @param faeList List of FAE for this submission
     */
    public SubmissionAssignment(Application submission, List<FAE> faeList, List<FAERating> faeRatings) {
        this.submission = submission;
        this.faeList = faeList;
        this.faeRatings = faeRatings;
    }

    /**
     * FAERating getter
     * @return The submission raqting
     */
    public FAERating getFAERating(FAE fae) {
        for(FAERating faeRating : this.faeRatings){
            if(faeRating.isFromFAE(fae)){
                return faeRating;
            }
        }
        return null;
    }

    /**
     * FAEList getter
     * @return faeList
     */
    public List<FAE> getFAEList() {
        return faeList;
    }

    /**
     * Validate if the fae belongs to this submission
     * @param fae fae to be validated
     * @return true if the fae belongs to the submission
     */
    public boolean isFromFAE(FAE fae) {
        return faeList.contains(fae);
    }

    /**
     * Get the assigned submission
     *
     * @return assigned submission
     */
    public Application getSubmission() {
        return submission;
    }

    /**
     * Validates if the submission is the assigned submission
     *
     * @param submission submission to be validated
     * @return true if the submission is the assigned submission
     */
    public boolean isForApplication(Application submission) {
        return submission.equals(submission);
    }

    /**
     * Validates if the fae belongs to this submission
     * @param fae FAE to be validated
     * @return true if the fae belongs to this submission
     */
    public boolean containsFAE(FAE fae) {
        for(FAE f : faeList) {
            if(f.equals(fae)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the average rating from all FAE's
     * @return the average rating
     */
    public float getAverageRating(){
        if(this.faeRatings.size() > 0){
            float ratingSum = 0;
            for(FAERating sr : this.faeRatings){
                ratingSum += sr.getAverageRating();
            }

            return  ratingSum/this.faeRatings.size();
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "";
        for(FAE fae : faeList) {
            s = s.concat(fae.toString() + "\n");
        }
        return String.format("Candidatura: %s %nFAE: %s", submission.toString(), s);
    }

}
