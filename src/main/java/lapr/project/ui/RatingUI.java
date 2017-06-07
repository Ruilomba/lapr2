package lapr.project.ui;

import lapr.project.controller.RatingController;
import lapr.project.model.EventCenter;
import lapr.project.model.FAERating;

import javax.swing.*;
import java.awt.*;

/**
 * Created by francisco on 04-06-2017.
 */
public class RatingUI extends JFrame {
    
    private final static long serialVersionUID =1L;
    private final RatingController ratingController;
    private final EventCenter eventCenter;

    public RatingUI(EventCenter center, RatingController ratingController) {
        super("Submission Rating");
        this.ratingController = ratingController;
        this.eventCenter = center;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());
        this.add(panel);

        this.add(new JLabel("Global average: "));
        this.add(new JLabel(String.format("%f",center.getGlobalSubmissionAverageRating())));

        this.add(new JLabel("FAE’s knowledge about the event topic:"));
        this.add(new JLabel(String.format("%f",center.getGlobalSubmissionAverageTopicKnowledgeRating())));

        this.add(new JLabel("Application adequacy for the event:"));
        this.add(new JLabel(String.format("%f",center.getGlobalSubmissionAverageApplicationAdequancyRating())));

        this.add(new JLabel("Invitations quantity adequacy for the application:"));
        this.add(new JLabel(String.format("%f",center.getGlobalSubmissionAverageInvitationQuantityRating())));

        this.add(new JLabel("Overall recommendation:"));
        this.add(new JLabel(String.format("%f",center.getGlobalSubmissionAverageOverallRating())));

        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }


}
