package lapr.project.controller;


import java.util.List;
import lapr.project.model.EventCenter;
import lapr.project.model.Stand;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Miguel Barros
 */
public class ShowEventStandInformationController {

    private final EventCenter eventCenter;

    public ShowEventStandInformationController(EventCenter eventCenter) {

        this.eventCenter = eventCenter;

    }

    public List<Stand> getShowEventStandInformation() {

        return eventCenter.getStandRegistration().getListStands();
    }

    public String[] getStandAsStrings() {
        List<Stand> stands = getShowEventStandInformation();
        String[] data = new String[stands.size()];
        for (Stand std : stands) {
            data[data.length] = std.toString();
        }
        return data;
    }
}
