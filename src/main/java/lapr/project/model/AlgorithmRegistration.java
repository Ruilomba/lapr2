package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmRegistration implements Serializable {

    private List<AssignmentAlgorithm> assignmentAlgorithmsList;
    
    public AlgorithmRegistration() {
        assignmentAlgorithmsList = new ArrayList<>();
    }

    public AlgorithmRegistration(List<AssignmentAlgorithm> assignmentAlgorithmsList) {
        this.assignmentAlgorithmsList = assignmentAlgorithmsList;       
    }

    public List<AssignmentAlgorithm> getAssignmentAlgorithmsList() {
        return this.assignmentAlgorithmsList;
    }
    
    public void setAssignmentAlgorithmsList(List algorithms) {
        assignmentAlgorithmsList = new ArrayList<>(algorithms);
    }
}
