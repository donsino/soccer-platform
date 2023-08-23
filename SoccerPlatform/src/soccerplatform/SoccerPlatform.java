package soccerplatform;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SoccerPlatform {
    
    
 
    public static void main(String[] args) throws ClassNotFoundException {  
     Scanner scanner = new Scanner(System.in);
     SoccerMatch match = new SoccerMatch();
    
     match.Welcome();
     switch(scanner.nextInt()){
        // CASE 1
        case 1:{
         try {
             match.Teamselection();
         } catch (SQLException ex) {
             Logger.getLogger(SoccerPlatform.class.getName()).log(Level.SEVERE, null, ex);
         }
            break;
            }
        // CASE 2
        case 2:{
         try {
             match.UpcomingMatches();
         } catch (SQLException ex) {
             Logger.getLogger(SoccerPlatform.class.getName()).log(Level.SEVERE, null, ex);
         }
            break;
            }
        // CASE 3
        case 3:{
         try {
             match.MatchResult();
         } catch (SQLException ex) {
             Logger.getLogger(SoccerPlatform.class.getName()).log(Level.SEVERE, null, ex);
         }
            break; 
            }
        // CASE 4
        case 4:{
         try {
             match.Matchposition();
         } catch (SQLException ex) {
             Logger.getLogger(SoccerPlatform.class.getName()).log(Level.SEVERE, null, ex);
         }
            break;
          }
        // DEFAULT 
        default:{
               match.Austino();
            break;
            }
   
       }
   }
}

