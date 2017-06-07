package lapr.project.ui;

import lapr.project.controller.RatingController;
import lapr.project.model.EventCenter;
import lapr.project.model.FAERating;

import javax.swing.*;
import java.awt.*;

/**
 * Created by francisco on 04-06-2017.
 */
public class RatingUI extends JPanel {
    
    private final static long serialVersionUID =1L;
    private final RatingController ratingController;
    private final EventCenter eventCenter;

    public RatingUI(EventCenter center, RatingController ratingController) {
        this.ratingController = ratingController;
        this.eventCenter = center;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());
        this.add(panel);

        this.add(new JLabel("Global average: "));
        this.add(new JLabel(String.format("%f",center.getGlobalSubmissionAverageRating())));

        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }
}
