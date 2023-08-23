package soccerplatform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Okoli Augustine
 */
public class SoccerMatch {
    int Team1;
    int Team2;
    String location; 
    int matchId;
    int score;
    int goals;
    int goalCount;
    int goalCount2;
 
    Scanner scanner = new Scanner(System.in);


    public SoccerMatch(String team1, String team2, String league, String location, int matchId, int score, int goals) {
        this.Team1 = Team1;
        this.Team2 = Team2;
        this.location = location;
        this.matchId = matchId;
        this.score = score;
        this.goals = goals;
       
    }
    
     SoccerMatch() {
     
       }
     public void Welcome(){
         System.out.println("Welcome to Group 5 Soccer Prediction Platform!\n"
                 + "Please enter a command or select an option. \n1. "
                 + "1. Enter Team Selection & Prediction \n2. "
                 + "2. View upcoming matches \n3."
                 + " 3. View Match results\n"
                 + "4. View Match Positions \n"
                 + "Kindly note our Prediction will be base on their highest scores and\n "
                 +"we are working only with 11 teams only ");
         
       
     }
     void Teamselection() throws SQLException {
         
         System.out.println("Enter the First Team");
         String team1 = scanner.nextLine();
         // Second Team Collection
         System.out.println("Enter the Second Team");
         String team2 = scanner.nextLine();
         
         
         System.out.println("Our prediction will be base on \n"+ team1 +" vs "+ team2+".");
         
         // Database collection for teams
         try(Connection conn = getDBConnection()){
          String query = "SELECT goals FROM goal_table WHERE team_name = ?";
        // Database collection for team1  
          PreparedStatement stmt = conn.prepareStatement(query);
          stmt.setString(1, team1);
          ResultSet rs1 = stmt.executeQuery();
          if(rs1.next()){
              Team1 = rs1.getInt("goals");
          }
          
          
          // Database collection for  team2 
          
          PreparedStatement stmt2 = conn.prepareStatement(query);
          stmt2.setString(1, team2);
          ResultSet rs2 = stmt2.executeQuery();
          if(rs2.next()){
              Team2 = rs2.getInt("goals");
          }
            if (Team1 > Team2){
              System.out.println("The team likely to win : " + team1);
          }else if (Team1 < Team2){
              System.out.println("The team likely to win : " + team2);
          } else{
              System.out.println("There will be draw between: "+ team1 +"  vs "+ team2);
          }

          rs1.close();
          rs2.close();
          stmt.close();
          stmt2.close();
          
//          System.out.println("Predicted match score: "+ team1 + goals +"-"+goals
//          +"-" + team2);
          
         conn.close();
        
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoccerMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      
     }
     
     void UpcomingMatches() throws SQLException{
        System.out.println("Here is the list of all the upcoming Matches, you can select from ");
        
        
         // Database collection for upcoming Matches
        try(Connection conn = getDBConnection()){
          String query = "SELECT * FROM upcomingmatches";
          PreparedStatement stmt = conn.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
          while(rs.next()){
              System.out.println(rs.getInt("id")+"--"+rs.getString("team1")
                      +"-----"+rs.getString("versus")+"-----"+rs.getString("team2"));
          }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoccerMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
     void MatchResult () throws SQLException, ClassNotFoundException{
       
        // Database collection
        try(Connection conn = getDBConnection()){
          String query = "SELECT * FROM soccer_db.matches;";
          PreparedStatement stmt = conn.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
           while(rs.next()){
              System.out.println(rs.getInt("id")+"--"+rs.getString("Home")
                      +"-----"+rs.getString("Home_score")+"-----"+rs.getString("Away_score")
                      +"-----"+rs.getString("Away")+"-----"+rs.getString("Location"));
               }
        
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoccerMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
   
  }
     
      void Matchposition() throws SQLException{
          // Database collection
        try(Connection conn = getDBConnection()){
          String query = "SELECT * FROM soccer_db.team_position;";
          PreparedStatement stmt = conn.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
           while(rs.next()){
              System.out.println(rs.getInt("id")+"---"+rs.getString("name")
                    +"-----"+rs.getString("position's"));
               }
        
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(SoccerMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      }
     
      public static Connection getDBConnection() throws SQLException, ClassNotFoundException{
        String username = "root";
        String password = "marame123";
        String url = "jdbc:mysql://127.0.0.1:3306/soccer_db?useSSL=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,username,password);
    }

    void Austino() {
        System.out.println("Thank you for believing in Group 5 Predicting Platform\n"
              + "We hope to see you again next time");
    }
   }
   
      
     
      
      
      

