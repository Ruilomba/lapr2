package lapr.project.model;

import java.util.List;

/**
 * AssignmentRating class
 */
public class AssignmentRating {

    private SubmissionAssignment assignmet;
    private List<FAERating> faeRatingList;

    public AssignmentRating(SubmissionAssignment assignmet, List<FAERating> faeRatingList) {
        this.assignmet = assignmet;
        this.faeRatingList = faeRatingList;
    }


}
