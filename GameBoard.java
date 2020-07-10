public class GameBoard{
  private int[][] board;
  
  private int winCondition;
  
  private boolean isEnded;
  
  public GameBoard(int rows, int columns){
    for(int i=0; i< rows;i++){
      for(int j=0; j< columns; j++){
        board[i][j] =0;
      }
    }
  }
  
  public int numberInLine(int dirX,int dirY,int rows, int columns,int[][] board){
    int count =0;
    int indexX=0;
    int indexY =0;
    if(dirX==1 && dirY==0){
        while(rows+indexX< board.length && board[rows][columns] != board[rows+indexX][columns]){
        count++;
        indexX++;
      }
    }
    else if(dirX==2 && dirY==0){
        while(rows-indexX >=0 && board[rows][columns] != board[rows-indexX][columns]){
        count++;
        indexX++;
        }
      }
    else if(dirX==0 && dirY==1){
        while(columns-indexY >=0 && board[rows][columns] != board[rows][columns-indexY]){
        count++;
        indexY++;
      }
    }
    
    if(dirX==0 && dirY==2){
        while(columns+indexY<board[0].length && board[rows][columns] != board[rows][columns+indexY]){
        count++;
        indexY++;
      }
    }
    if(dirX==1 && dirY==1){
        while(rows+indexX<board.length && columns-indexY>=0 && board[rows][columns] != board[rows+indexY][columns-indexY]){
        count++;
        indexX++;
        indexY++;
      }
    }
    if(dirX==2 && dirY==1){
        while(rows-dirX>=0 && columns-dirY>=0 && board[rows][columns] != board[rows-dirX][columns-dirY]){
        count++;
        indexX++;
        indexY++;
      }
    }
    if(dirX==1 && dirY==2){
        while(rows+indexX<board.length && columns+ indexY< board[0].length && board[rows][columns] != 
          board[rows+indexX][columns+indexY]){
          count++;
          indexX++;
          indexY++;
        }
    }
    if(dirX==2 && dirY==2){
        while(rows-indexX>=0 && columns+indexY < board[0].length && 
              board[rows][columns] != board[rows-indexX][columns+indexY]){
        count++;
        indexX++;
        indexY++;
      }
    }
    return count;
  }
  
  public boolean isOpen(int dirX, int dirY, int rows, int columns, int[][] board){
    if(dirX==1 && dirY==0){
      if(board[rows][columns]==0){
        return true;
      }else{
        rows = rows + numberInLine(dirX,dirY,rows,columns,board);
        return (rows < board.length && board[rows][columns]==0);
      }
    }
    else if(dirX ==2 && dirY ==0){
      if(board[rows][columns]==0){
        return true;
      }else{
        rows = rows - numberInLine(dirX,dirY,rows,columns,board);
        return (rows >=0 && board[rows][columns]==0);
      }
    }
    else if(dirX==0 && dirY==1){
    if(board[rows][columns]==0){
        return true;
      }else{
        rows = rows - numberInLine(dirX,dirY,rows,columns,board);
        return (rows >=0 && board[rows][columns]==0);
      }
    }
    else if(dirX==0 && dirY ==2){
     if(board[rows][columns]==0){
        return true;
      }else{
        columns = columns - numberInLine(dirX,dirY,rows,columns,board);
        return (columns>=0 && board[rows][columns]==0);
      }
    }
    else if(dirX==1 && dirY==2){
     if(board[rows][columns]==0){
        return true;
      }else{
        rows = rows + numberInLine(dirX,dirY,rows,columns,board);
        columns = columns - numberInLine(dirX,dirY,rows,columns,board);
        return (rows<board.length && columns>=0 && board[rows][columns]==0);
      }
    }
    else if(dirX==2 && dirY==1){
     if(board[rows][columns]==0){
        return true;
      }else{
        rows = rows - numberInLine(dirX,dirY,rows,columns,board);
        columns = columns + numberInLine(dirX,dirY,rows,columns,board);
        return (rows>=0 && columns<board[0].length && board[rows][columns]==0);
      }
    }
    else if(dirX ==1 && dirY ==1){
      if(board[rows][columns]==0){
        return true;
      }else{
        rows = rows + numberInLine(dirX,dirY,rows,columns,board);
        columns = columns + numberInLine(dirX,dirY,rows,columns,board);
        return (rows< board.length && columns<board[0].length && board[rows][columns]==0);
      }
    }
    else{
      if(board[rows][columns]==0){
        return true;
      }else{
        rows = rows - numberInLine(dirX,dirY,rows,columns,board);
        columns = columns - numberInLine(dirX,dirY,rows,columns,board);
        return (rows>=0 && columns>=0 && board[rows][columns]==0);
      }
    }
    }
  
  
  public boolean movable(int rows, int columns, int[][] board, int winCondition){
    if(isEnded == true){
      return false;
    }
    else{
      int count4 =0;
      //Check for four-four rule
      if(numberInLine(1,1,rows,columns,board) + numberInLine(2,2,rows,columns,board) >=winCondition+1)
        count4++;
      else if(numberInLine(0,1,rows,columns,board) + numberInLine(0,2,rows,columns,board)>=winCondition+1)
        count4++;
      else if(numberInLine(1,2,rows,columns,board) + numberInLine(2,1,rows,columns,board)>=winCondition+1)
        count4++;
      else if(numberInLine(1,0,rows,columns,board) + numberInLine(2,0,rows,columns,board)>=winCondition+1)
        count4++;
      
      int count3=0;
      //Check for three-three rule
      if(isOpen(1,1,rows,columns,board) == true || isOpen(2,2,rows,columns,board) == true){
        if(numberInLine(1,1,rows,columns,board) + numberInLine(2,2,rows,columns,board) >=winCondition-1)
          count3++;
      }
      else if(isOpen(0,1,rows,columns,board)== true || isOpen(0,2,rows,columns,board) == true){
        if(numberInLine(0,1,rows,columns,board) + numberInLine(0,2,rows,columns,board)>=winCondition-1)
          count3++;
      }
      else if(isOpen(1,2,rows,columns,board) == true || isOpen(2,1,rows,columns,board) == true){
        if(numberInLine(1,2,rows,columns,board) + numberInLine(2,1,rows,columns,board) >=winCondition-1)
          count3++;
      }
      else if(isOpen(1,0,rows,columns,board) == true || isOpen(2,0,rows,columns,board) == true){
        if(numberInLine(1,0,rows,columns,board) + numberInLine(2,0,rows,columns,board)>=winCondition-1)
          count3++;
    }
      //Check if it is legal or not
      if(count4>1 && count3>1){
        return false;
      }
      else{
        return true;
      }
    }
  }
  
    public boolean isEnded(int rows, int columns, int board[][], int winCondition){
      int count5 =0;
      if(numberInLine(1,1,rows,columns,board) + numberInLine(2,2,rows,columns,board)==winCondition-1)
        count5++;
      else if(numberInLine(0,1,rows,columns,board) + numberInLine(0,2,rows,columns,board)==winCondition-1)
        count5++;
      else if(numberInLine(1,2,rows,columns,board) + numberInLine(2,1,rows,columns,board)==winCondition-1)
        count5++;
      else if(numberInLine(1,0,rows,columns,board) + numberInLine(2,0,rows,columns,board)==winCondition-1)
        count5++;
      
      if(count5>0)
        return true;
      else
        return false;
    }

}