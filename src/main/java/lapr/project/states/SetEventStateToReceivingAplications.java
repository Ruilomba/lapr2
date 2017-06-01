/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.states;

import lapr.project.model.Event;
import java.util.TimerTask;

/**
 *
 * @author RuiSL
 */
public class SetEventStateToReceivingAplications extends TimerTask {

    private Event event;

    public SetEventStateToReceivingAplications(Event event) {
        this.event = event;
    }

    @Override
    public void run() {
        if(this.event.getEventState() instanceof EventStateDefinedFAE){
            this.event.setToReceivingAplications();
        }
    }

}
