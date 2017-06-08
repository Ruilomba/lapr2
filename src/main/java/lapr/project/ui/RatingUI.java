package lapr.project.ui;

import lapr.project.controller.RatingController;
import lapr.project.model.EventCenter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by francisco on 04-06-2017.
 */
public class RatingUI extends JPanel {

    private final static long serialVersionUID = 1L;
    private final RatingController ratingController;
    private final EventCenter eventCenter;

    public RatingUI(EventCenter center, RatingController ratingController) {
        this.ratingController = ratingController;
        this.eventCenter = center;
        this.setLayout(new SpringLayout());
        this.add(new JLabel("Global average: "));
        this.add(new JLabel(String.format("%f", center.getGlobalSubmissionAverageRating())));
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }
}

/*
RatingParameter parameter1 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
RatingParameter parameter2 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
RatingParameter parameter3 = new RatingParameter("FAE’s knowledge about the event topic", 0, 5, 0);
List<RatingParameter> list = new ArrayList<>();
list.add(parameter1);
list.add(parameter2);
list.add(parameter3);
User user = new User("Gastão", "gastao@fdv.com", "ogastao", "gaston");
FAE fae = new FAE(user);
FAERating faeRating = new FAERating(fae, list);
System.out.println("corrid");
*/
