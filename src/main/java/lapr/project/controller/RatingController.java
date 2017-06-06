package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.ui.RatingUI;

import javax.swing.*;

/**
  * Rating Controller
  */
public class RatingController {

    public JFrame showGlobalAverageRating(EventCenter center){
        System.out.println("asas");
        return new RatingUI(center, this);
    }
}
