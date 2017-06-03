package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.states.EventCreatedState;
import lapr.project.states.EventState;

public class EventRegistration {

    private List<Event> eventList;

    public EventRegistration() {
        eventList = new ArrayList<Event>();
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> listaEventos) {
        this.eventList = eventList;
    }
    public List<Event> getEventsOfState(EventState eventState){
        List<Event> AuxEventList=new ArrayList<>();
        for(Event e : eventList){
            if(e.getEventState().getClass().getSimpleName().equals(eventState.getClass().getSimpleName())){
                AuxEventList.add(e);
            }
        }
        return AuxEventList;
    }
    
    /**
     * a ser editado
//        public List<Event> getAvailableToApplicationEventList() {
//
//        List<Event> EventListAvailable = new ArrayList<>();
//        for (Event e : eventList) {
//            Data dataAtual = Data.dataAtual();
//            if ((e.getDataFimSub().isMaior(dataAtual)) == true) {
//                listaEventosValidos.add(e);
//            }
//        }
//        return listaEventosValidos;
//    }

    /*
    public List<Organizer> getListaOrganizadores() {
        List<Organizer> listaOrganizadores = new ArrayList<>();
        for (Evento e : listaEventos) {
            List<Organizador> listaAux = e.getListaOrganizadores();
            for (Organizador o : listaAux) {
                if (!listaOrganizadores.contains(o)) {
                    listaOrganizadores.add(o);
                }
            }
        }
        return listaOrganizadores;
    }


    public List<FAE> getListaFaes() {
        List<FAE> listaFaes = new ArrayList<>();
        for (Evento e : listaEventos) {
            List<FAE> listaAux = e.getListaFae().getListaFAE();
            for (FAE fae : listaAux) {
                if (!listaFaes.contains(fae)) {
                    listaFaes.add(fae);
                }
            }
        }
        return listaFaes;
    }


*/
    public List<Event> getOrganizerEvents(User u){
        List<Event> organizerEvents= new ArrayList<>();
        
        for(Event e : organizerEvents){
            if(e.belongsToOrganizer(u)){
                organizerEvents.add(e);
            }
        }
        return organizerEvents;
    }
    

    
    public Event newEvent() {
        return new Event();
    }

    public void registerEvento(Event e) {
        if (validatesEvent(e)) {
            eventList.add(e);
        }
    }

    /*
    public Event getEvento(String title) {
        for (Event e : eventList) {
            if (title.equalsIgnoreCase(e.getTitle())) {
                return e;
            }
        }
        return null;
    }
    */

    public Event getEvent(Event e) {
        int index = eventList.indexOf(e);
        if (index < 0) {
            return null;
        }
        return eventList.get(index);
    }

    public boolean validatesEvent(Event e) {
        if (eventList.contains(e)) {
            return false;
        }
        return true;
    }

    /*
    public List<Event> getListaEventosFAEValidosDecisao(User u) {
        List<Event> output = new ArrayList<Event>();
        Data today = Data.dataAtual();
        for (Evento e : listaEventos) {
            if (e.verificaFAEPertence(u) && today.isMaior(e.getDataFimSub())) {
                output.add(e);
            }
        }
        return output;
    }
    */
}
