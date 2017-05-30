package lapr.project.model;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by francisco on 30-05-2017.
 */
public class FAEList {
    private List<FAE> faeList;

    /**
     * Object constructor
     * @param faeList list of FAE's
     */
    public FAEList(List<FAE> faeList) {
        this.faeList = new ArrayList<FAE>(faeList);
    }

    /**
     * get List of Fae's
     * @return list of fae's
     */
    public List<FAE> getFaeList() {
        return new ArrayList<FAE>(this.faeList);
    }

    /**
     * Adds fae to the list
     * @param fae fae member
     * @return true if added with success
     */
    public boolean registerFAEMember(FAE fae) {
        return this.faeList.add(fae);
    }

    /**
     * Returns the fae that the user belongs to
     * @param user User
     * @return null if the user does not exist in the list
     */
    public FAE getFAE(User user) {
        for (FAE fae : faeList) {
            if (fae.isUser(user)) {
                return fae;
            }
        }
        return null;
    }
    /**
     * validates if the list is empty
     * @return true if empty
     */
    public boolean isEmpty() {
        return faeList.isEmpty();
    }

    /**
     * Validates if the users exists in the fae list
     * @param user User
     * @return true if the user exists
     */
    boolean hasFAE(User user) {
        for (FAE fae : faeList) {
            if (fae.isUser(user)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Constructs a new FAW
     * @return
     */
    public static FAE newFAE() {
        return new FAE();
    }
}
