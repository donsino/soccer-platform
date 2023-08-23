package soccerplatform;

import java.util.Date;

/**
 *
 * @author Okoli Augustine
 */
public class Matchresults {
    String Home;
    String Away;
    int Home_score;
    int Away_score;

    public Matchresults(String Home, String Away, int Home_score, int Away_score, Date matchDate) {
        this.Home = Home;
        this.Away = Away;
        this.Home_score = Home_score;
        this.Away_score = Away_score;
       
    }

    //To change body of generated methods, choose Tools | Templates.
    Matchresults() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}

  