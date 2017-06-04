/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.states;

import java.util.TimerTask;
import lapr.project.model.Event;

/**
 *
 * @author RuiSL
 */
public class SetEventStateToClosedApplications extends TimerTask {
    private Event event;
    
    
    public SetEventStateToClosedApplications(Event event){
        this.event=event;
    }

    @Override
    public void run() {
        if(event.getEventType() instanceof EventStateReceivingApplications){
            this.event.setEventState(new EventStateClosedApplications());
        }
    }
    
    
}
