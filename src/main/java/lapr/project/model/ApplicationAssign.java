package lapr.project.model;

import java.util.List;

public class ApplicationAssign {
    
    private final Application application;
    private final List<FAE> faeList;

    /**
     * Object constructor
     * @param application Application to be assigned
     * @param faeList List of FAE for this assignment
     */
    public ApplicationAssign(Application application, List<FAE> faeList) {
        this.application = application;
        this.faeList = faeList;
    }

    /**
     * FAEList getter
     *
     * @return faeList
     */
    public List<FAE> getFAEList() {
        return faeList;
    }

    /**
     * Validate if the fae belongs to this assignment
     * @param fae fae to be validated
     * @return true if the fae belongs to the assignment
     */
    public boolean isFromFAE(FAE fae) {
        return faeList.contains(fae);
    }

    /**
     * Get the application assgnment
     *
     * @return application assigment
     */
    public Application getApplication() {
        return application;
    }

    /**
     * Validates if the application is the assign application
     *
     * @param application application to be validated
     * @return true if the application is the assign application
     */
    public boolean isForApplication(Application application) {
        return application.equals(application);
    }

    /**
     * Validates if the fae belongs to this assignment
     * @param fae FAE to be validated
     * @return true if the fae belongs to this assgnment
     */
    public boolean containsFAE(FAE fae) {
        for(FAE f : faeList) {
            if(f.equals(fae)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String s = "";
        for(FAE fae : faeList) {
            s = s.concat(fae.toString() + "\n");
        }
        return String.format("Candidatura: %s %nFAE: %s", application.toString(), s);
    }

}
