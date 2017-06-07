package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.ui.RatingUI;

import javax.swing.*;

/**
  * Rating Controller
  */
public class RatingController {

    public JFrame showGlobalAverageRating(EventCenter center){
        return new RatingUI(center, this);
    }
}
