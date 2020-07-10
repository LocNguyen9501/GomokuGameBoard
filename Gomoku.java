import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.*;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import java.util.*;
import javafx.scene.layout.BorderPane;

/**
 * This is the Gomoku class
 * @author: Liam Nguyen
 * @version 1.0
 * @since December 1,2019
 */
public class Gomoku extends Application{
 //This is the restart button
 private Button restart; 
 
 //This stores the array of buttons
 private Button[][] button;
 
 //This stores the boolean value to make sure when the game is ended
 private boolean gameEnd = false;
 
 //This stores the value of each button 0:empty, 1:black, 2:white
 private int[][] board;
 
//This stores the output of numberInLine method
 private int count;
 
 //This stores the condition to win
 private int winCondition;
 
 //This stores the number of time the button is clicked on to prevent from being click multiple times
 private int[][] clickCount;
 
 //This stores the value to switch turn 1: Black turn , 2: White turn
 private int turn = 1;

 /**
  * This method get the turn black or white
  * @return the value of player who is playing
  */
  public int getTurn(){
    return this.turn;
  }
  
  /**
   * This method set the turn for black player
   *@return the black turn value
   */
  public int setTurnBlack(){
    return this.turn = 1;
  }
  
  /**
   * This method set the turn for white player
   *@return the white turn value
   */
  public int setTurnWhite(){
   return this.turn = 2;
  }
  
  /**
   * This is the start method
   *@param primaryStage the board that we play on
   */
  public void start(Stage primaryStage){
    BorderPane pane = new BorderPane();
    GridPane gridPane = new GridPane();
    //This get parameters from main method to build a board
    switch(getParameters().getRaw().size()){
      case 1:
        button = new Button[19][19];
        clickCount = new int[19][19];
        board = new int[19][19];
        //This loops goes through each button and assign 0 to the value of it
        for(int i=0; i<button.length;i++){
          for(int j=0;j<button[0].length;j++){
            board[i][j] =0;
          }
        }
        winCondition = Integer.parseInt(getParameters().getRaw().get(0));
        break;
      case 2:
        button = new Button[Integer.parseInt(getParameters().getRaw().get(0))][Integer.parseInt(getParameters().getRaw().get(1))];
        clickCount = new int[Integer.parseInt(getParameters().getRaw().get(0))][Integer.parseInt(getParameters().getRaw().get(1))];
        board = new int[Integer.parseInt(getParameters().getRaw().get(0))][Integer.parseInt(getParameters().getRaw().get(1))];
        //This loops goes through each button and assign 0 to the value of it
        for(int i=0; i<button.length;i++){
          for(int j=0;j<button[0].length;j++){
            board[i][j] =0;
          }
        }
        winCondition = 5;
        break;
      case 3:
        button = new Button[Integer.parseInt(getParameters().getRaw().get(1))][Integer.parseInt(getParameters().getRaw().get(2))];
        clickCount = new int[Integer.parseInt(getParameters().getRaw().get(1))][Integer.parseInt(getParameters().getRaw().get(2))];
        board = new int[Integer.parseInt(getParameters().getRaw().get(1))][Integer.parseInt(getParameters().getRaw().get(2))];
        //This loops goes through each button and assign 0 to the value of it
        for(int i=0; i<button.length;i++){
          for(int j=0;j<button[0].length;j++){
            board[i][j] =0;
          }
        }
        winCondition= Integer.parseInt(getParameters().getRaw().get(0));
        break;
      default:
        button = new Button[19][19];
        clickCount = new int[19][19];
        board = new int[19][19];
        //This loops goes through each button and assign 0 to the value of it
        for(int i=0; i<button.length;i++){
          for(int j=0;j<button[0].length;j++){
            board[i][j] =0;
          }
        }
        winCondition = 5;
    }
    
    //Loops through each button to set size, background and event
    for(int i=0; i< button.length;i++){
      for(int j=0; j<button[i].length;j++){
        clickCount[i][j] = 0;
        button[i][j] = new Button();
        button[i][j].setPrefSize(30,30);
        button[i][j].setBackground(new Background(new BackgroundFill(Color.PERU,null,new Insets(1.0))));
        gridPane.add(button[i][j],i,j);
        button[i][j].setOnAction(e->{
          //Loops through each buttons
      for(int n=0; n<button.length;n++){
        for(int m=0; m<button[n].length;m++){
          if(e.getSource() == button[n][m]){
            if(movable(n,m,board,winCondition,getTurn())== true && gameEnd == false){
            if(getTurn() == 1 && clickCount[n][m] <1){
              board[n][m]= 1;
              button[n][m].setBackground(new Background(new BackgroundFill(Color.PERU,null,new Insets(1.0)),
                                                        new BackgroundFill(Color.BLACK,new CornerRadii(50),new Insets(3.0))));
              clickCount[n][m]++;
               
              if(isEnded(n,m,board,winCondition) == false){
              setTurnWhite();
              }
              else
                gameEnd = true;
            }
            else if(getTurn()== 2&& clickCount[n][m] <1){
              board[n][m]= 2;
              button[n][m].setBackground(new Background(new BackgroundFill(Color.PERU,null,new Insets(1.0)),
                                                        new BackgroundFill(Color.WHITE,new CornerRadii(50),new Insets(3.0))));
              clickCount[n][m]++;
              
              if(isEnded(n,m,board,winCondition) == false){
              setTurnBlack();
              }
              else
                gameEnd = true;
          }
         }
        }
       }
      }
      });
      } 
    }
    
    //Restart button
    Button restart = new Button("New Game");
    restart.setOnAction(a->{
               //This loops through each button to reste
      for(int i=0; i<button.length;i++){
        for(int j=0; j< button[0].length;j++){
          board[i][j] = 0;
          button[i][j].setBackground(new Background(new BackgroundFill(Color.PERU,null,new Insets(1.0))));
          clickCount[i][j]=0;
          gameEnd = false;
        }
      }});
    
    pane.setCenter(gridPane);
    pane.setTop(restart);
    
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Gomoku");
    primaryStage.show();
  }
  
  

  
  /**
   * This is the helper method that counts the number of same type in specific direction
   *@param dirX helps indicate Ox direction
   *@param dirY helps indicate Oy direction
   *@param rows the row index of the button we need to check
   *@param columns the column index of the button we need to check
   *@param board contains the value of buttons in the board
   *@return the number of same type in specific direction
   */
  public static int numberInLine(int dirX,int dirY,int rows, int columns,int[][] board){
    int count =0;
    int indexX=0;
    int indexY =0;
    //dirX and dirY here is a way for me to specify direction it is like your String direction
    if(dirX==1 && dirY==0){
      //This loop checks for the number of same type in right direction
        while(rows+indexX< board.length && board[rows][columns] == board[rows+indexX][columns]){
        count++;
        indexX++;
      }
    }
    if(dirX==2 && dirY==0){
      //This loop checks for the number of same type in left direction
        while(rows-indexX >=0 && board[rows][columns] == board[rows-indexX][columns]){
        count++;
        indexX++;
        }
      }
    if(dirX==0 && dirY==1){
      //This loop checks for the number of same type in the up direction
        while(columns-indexY >=0 && board[rows][columns] == board[rows][columns-indexY]){
        count++;
        indexY++;
      }
    }
    if(dirX==0 && dirY==2){
      //This loop checks for the number of same type in down direction
        while(columns+indexY<board[0].length && board[rows][columns] == board[rows][columns+indexY]){
        count++;
        indexY++;
      }
    }
    if(dirX==1 && dirY==1){
      //This loop checks for the number of same type in upright direction
        while(rows+indexX<board.length && columns-indexY>=0 && board[rows][columns] == board[rows+indexY][columns-indexY]){
        count++;
        indexX++;
        indexY++;
      }
    }
    if(dirX==2 && dirY==1){
      //This loop checks for the number of same type in upleft direction
        while(rows-indexX>=0 && columns-indexY>=0 && board[rows][columns] == board[rows-indexX][columns-indexY]){
        count++;
        indexX++;
        indexY++;
      }
    }
    if(dirX==1 && dirY==2){
      //This loop checks for the number of same type in the downright direction
        while(rows+indexX<board.length && columns+ indexY< board[0].length && board[rows][columns] == 
          board[rows+indexX][columns+indexY]){
          count++;
          indexX++;
          indexY++;
        }
    }
    if(dirX==2 && dirY==2){
      //This loop check for the number of same type in the leftdown direction
        while(rows-indexX>=0 && columns+indexY<board[0].length && 
              board[rows][columns] == board[rows-indexX][columns+indexY]){
        count++;
        indexX++;
        indexY++;
      }
    }
    return count;
    
  }
  
  /**
   * This method checks for the empty in specific direction
   * @param dirX helps indicate in Ox direction
   * @param dirY helps indicate in Oy direction
   * @param rows helps indicate the position of the one we need to check
   * @param columns helps indicate the position of the one we need to check
   * @param board the array of value of buttons
   * @return boolean value if there is an empty button in specific direction
   */
  public static boolean isOpen(int dirX, int dirY, int rows, int columns, int[][] board){
    if(dirX==1 && dirY==0){
      if(board[rows][columns]==0){
        return true;
      }else{
        int saveRows = rows;
        rows = rows + numberInLine(1,0,saveRows,columns,board);
        if(rows<board.length)
        return board[rows][columns]==0;
        else
          return false;
      }
    }
    else if(dirX ==2 && dirY ==0){
      if(board[rows][columns]==0){
        return true;
      }else{
        int saveRows = rows;
        rows = rows - numberInLine(2,0,saveRows,columns,board);
        if(rows >=0)
        return  board[rows][columns]==0;
        else
          return false;
      }
    }
    else if(dirX==0 && dirY==1){
    if(board[rows][columns]==0){
        return true;
      }else{
        int saveColumns = columns;
        columns = columns - numberInLine(0,1,rows,saveColumns,board);
        if(columns >=0)
        return board[rows][columns]==0;
        else
          return false;
      }
    }
    else if(dirX==0 && dirY ==2){
     if(board[rows][columns]==0){
        return true;
      }else{
        int saveColumns = columns;
        columns = columns + numberInLine(0,2,rows,saveColumns,board);
        if(columns<board[0].length)
          return board[rows][columns]==0;
        else
          return false;
      }
    }
    else if(dirX==1 && dirY==2){
     if(board[rows][columns]==0){
        return true;
      }else{
        int saveRows = rows;
        int saveColumns = columns;
        rows = rows + numberInLine(1,2,saveRows,saveColumns,board);
        columns = columns + numberInLine(1,2,saveRows,saveColumns,board);
        if(rows<board.length && columns<board[0].length)
         return  board[rows][columns]==0;
        else
          return false;
      }
    }
    else if(dirX==2 && dirY==1){
     if(board[rows][columns]==0){
        return true;
      }else{
        int saveRows = rows;
        int saveColumns = columns;
        rows = rows - numberInLine(2,1,saveRows,saveColumns,board);
        columns = columns - numberInLine(2,1,saveRows,saveColumns,board);
        if(rows>=0 && columns>=0)
        return board[rows][columns]==0;
        else
          return false;
      }
    }
    else if(dirX ==1 && dirY ==1){
      if(board[rows][columns]==0){
        return true;
      }else{
        int saveRows = rows;
        int saveColumns = columns;
        rows = rows + numberInLine(1,1,saveRows,saveColumns,board);
        columns = columns - numberInLine(1,1,saveRows,saveColumns,board);
        if(rows< board.length && columns>=0)
          return board[rows][columns]==0;
        else
          return false;
      }
    }
    else{
      if(board[rows][columns]==0){
        return true;
      }else{
        int saveRows = rows;
        int saveColumns = columns;
        rows = rows - numberInLine(2,2,saveRows,saveColumns,board);
        columns = columns + numberInLine(2,2,saveRows,saveColumns,board);
        if(rows>=0 && columns<board[0].length)
          return  board[rows][columns]==0;
        else
          return false;
      }
    }
   }
  
  /**
    * This class check if the next move is legal or not
    * @param rows indicates the rows position of the one we need to check
    * @param columns indicates the columns position of the one we need to check
    * @param board the array stores the value of each button
    * @param winCondition condition to win
    * @param turn store which player is playing
    * @return the boolean value if player can make a move or not
    */
  public static boolean movable(int rows, int columns, int[][] board, int winCondition, int turn){
      board[rows][columns] = turn;
      
      //This stores the number of time the new move makes four groups
      int count4 =0;
      //Check for four-four rule
      if(numberInLine(1,1,rows,columns,board) + numberInLine(2,2,rows,columns,board)==winCondition)
        count4++;
      if(numberInLine(0,1,rows,columns,board) + numberInLine(0,2,rows,columns,board)==winCondition)
        count4++;
      if(numberInLine(1,2,rows,columns,board) + numberInLine(2,1,rows,columns,board)==winCondition)
        count4++;
      if(numberInLine(1,0,rows,columns,board) + numberInLine(2,0,rows,columns,board)==winCondition)
        count4++;
      
      //This stores the number of time the new move makes a 3 groups with an empty button at the end of each group
      int count3=0;
      //Check for three-three rule
      if(isOpen(1,1,rows,columns,board) == true && isOpen(2,2,rows,columns,board) == true){
        if(numberInLine(1,1,rows,columns,board) + numberInLine(2,2,rows,columns,board)== winCondition-1)
        {
          count3++;
        }
      }
      if(isOpen(0,1,rows,columns,board) == true && isOpen(0,2,rows,columns,board) == true){
        if(numberInLine(0,1,rows,columns,board) + numberInLine(0,2,rows,columns,board)==winCondition-1)
        {
          count3++;
        }
      }
      if(isOpen(1,2,rows,columns,board) == true && isOpen(2,1,rows,columns,board) == true){
        if(numberInLine(1,2,rows,columns,board) + numberInLine(2,1,rows,columns,board)==winCondition-1)
        {
          count3++;
        }
      }
      if(isOpen(1,0,rows,columns,board) == true && isOpen(2,0,rows,columns,board) == true){
        if(numberInLine(1,0,rows,columns,board) + numberInLine(2,0,rows,columns,board)==winCondition-1)
        {
          count3++;
        }
    }
      board[rows][columns] = 0;
      //Check if it is legal or not
      if(count4>1 || count3>1){
        System.out.println("Illegeal Step. Please make another step");
        return false;
      }
      else{
        return true;
      }
  }
    
  /**
   * This method check if the player win or not
   * @param rows stores the row index of the one the player is going to play
   * @param columns stores the column index of the one the player is going to play
   * @param board stores the value of button in the board
   * @param winCondition the condition to win
   * @return the player win or not
   */
    public static boolean isEnded(int rows, int columns, int[][] board, int winCondition){
      int count5 =0;
      if(numberInLine(1,1,rows,columns,board) + numberInLine(2,2,rows,columns,board)==winCondition+1)
        count5++;
       if(numberInLine(0,1,rows,columns,board) + numberInLine(0,2,rows,columns,board)==winCondition+1)
        count5++;
      if(numberInLine(1,2,rows,columns,board) + numberInLine(2,1,rows,columns,board)==winCondition+1)
        count5++;
      if(numberInLine(1,0,rows,columns,board) + numberInLine(2,0,rows,columns,board)==winCondition+1)
        count5++;
      
      if(count5>0)
      {
        System.out.println("Win!");
        return true;
      }
      else
        return false;
    }

  /**
   * This is the main method
   * @param args the string user put in to create the game
   */
  public static void main(String[] args){
    Application.launch(args);
  }
  
}