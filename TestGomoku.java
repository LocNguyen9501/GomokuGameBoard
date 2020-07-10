import org.junit.*;
import static org.junit.Assert.*;

public class TestGomoku{
  
  //Test numberInLines method
  @Test
  public void testNumberInLines(){
    //Test numberInLine blocks by the wall with rows =1, columns =1
    int[][] board1 = new int[4][4];
    board1[0][0]=1; board1[0][1]=1; board1[0][2]=1; board1[0][3]=0;
    board1[1][0]=1; board1[1][1]=1; board1[1][2]=1; board1[1][3]=1;
    board1[2][0]=1; board1[2][1]=1; board1[2][2]=1; board1[2][3]=0;
    board1[3][0]=0; board1[3][1]=1; board1[3][2]=0; board1[3][3]=1;
    assertEquals("Test numberInLine blocks by the wall for right direction",3,Gomoku.numberInLine(1,0,1,1,board1));
    assertEquals("Test numberInLine blocks by the wall for left direction",2,Gomoku.numberInLine(2,0,1,1,board1));
    assertEquals("Test numberInLine blocks by the wall for up direction", 2,Gomoku.numberInLine(0,1,1,1,board1));
    assertEquals("Test numberInLine blocks by the wall for down direction",3,Gomoku.numberInLine(0,2,1,1,board1));
    assertEquals("Test numberInLine blocks by the wall for upright direction",2,Gomoku.numberInLine(1,1,1,1,board1));
    assertEquals("Test numberInLine blocks by the wall for upleft direction",2,Gomoku.numberInLine(2,1,1,1,board1));
    assertEquals("Test numberInLine blocks by the wall for downleft direction",2,Gomoku.numberInLine(2,2,1,1,board1));
    assertEquals("Test numberInLine blocks by the wall for downright direction",3,Gomoku.numberInLine(1,2,1,1,board1));
    
    //Test number in line blocks by other type with rows =2, columns =2
    int[][] board2 = new int[5][5];
    board2[0][0]=2;board2[0][1]=2;board2[0][2]=2;board2[0][3]=2;board2[0][4]=2;
    board2[1][0]=2;board2[1][1]=1;board2[1][2]=1;board2[1][3]=1;board2[1][4]=2;
    board2[2][0]=2;board2[2][1]=1;board2[2][2]=1;board2[2][3]=1;board2[2][4]=2;
    board2[3][0]=2;board2[3][1]=1;board2[3][2]=1;board2[3][3]=1;board2[3][4]=2;
    board2[4][0]=2;board2[4][1]=2;board2[4][2]=2;board2[4][3]=2;board2[4][4]=2;
    assertEquals("Test numberInLine blocks by white for right direction",2,Gomoku.numberInLine(1,0,2,2,board2));
    assertEquals("Test numberInLine blocks by white for left direction",2,Gomoku.numberInLine(2,0,2,2,board2));
    assertEquals("Test numberInLine blocks by white for up direction", 2,Gomoku.numberInLine(0,1,2,2,board2));
    assertEquals("Test numberInLine blocks by white for down direction",2,Gomoku.numberInLine(0,2,2,2,board2));
    assertEquals("Test numberInLine blocks by white for upright direction",2,Gomoku.numberInLine(1,1,2,2,board2));
    assertEquals("Test numberInLine blocks by white for upleft direction",2,Gomoku.numberInLine(2,1,2,2,board2));
    assertEquals("Test numberInLine blocks by white for downleft direction",2,Gomoku.numberInLine(2,2,2,2,board2));
    assertEquals("Test numberInLine blocks by white for downright direction",2,Gomoku.numberInLine(1,2,2,2,board2));
  }
  
  //Test is open method
  @Test 
  public void testIsOpen(){
    //Test isOpen that return true for 8 directions with columns=2; rows =2
    int[][] board3 = new int[6][6];
    board3[0][0]=0;board3[0][1]=0;board3[0][2]=0;board3[0][3]=0;board3[0][4]=0;board3[0][5]=0;
    board3[1][0]=0;board3[1][1]=1;board3[1][2]=1;board3[1][3]=1;board3[1][4]=1;board3[1][5]=0;
    board3[2][0]=0;board3[2][1]=1;board3[2][2]=1;board3[2][3]=1;board3[2][4]=1;board3[2][5]=0;
    board3[3][0]=0;board3[3][1]=1;board3[3][2]=1;board3[3][3]=1;board3[3][4]=1;board3[3][5]=0;
    board3[4][0]=0;board3[4][1]=0;board3[4][2]=0;board3[4][3]=0;board3[4][4]=0;board3[4][5]=0;
    assertTrue("Test isOpen that return true in right direction",Gomoku.isOpen(1,0,2,2,board3));
    assertTrue("Test isOpen that return true in left direction",Gomoku.isOpen(2,0,2,2,board3));
    assertTrue("Test isOpen that return true in up direction", Gomoku.isOpen(0,1,2,2,board3));
    assertTrue("Test isOpen that return true in down direction",Gomoku.isOpen(0,2,2,2,board3));
    assertTrue("Test isOpen that return true in upright direction",Gomoku.isOpen(1,1,2,2,board3));
    assertTrue("Test isOpen that return true in up left direction",Gomoku.isOpen(2,1,2,2,board3));
    assertTrue("Test isOpen that return true in downleft Direction",Gomoku.isOpen(2,2,2,2,board3));
    assertTrue("Test isOpen that return true in downright Direction",Gomoku.isOpen(1,2,2,2,board3));
    
    
    //Test isOpen that return false case1: because can't find empty button for 8 directions with rows =2, columns=2
    int[][] board4 = new int[6][6];
    board4[0][0]=2;board4[0][1]=2;board4[0][2]=2;board4[0][3]=2;board4[0][4]=2;board4[0][5]=2;
    board4[1][0]=2;board4[1][1]=1;board4[1][2]=1;board4[1][3]=1;board4[1][4]=1;board4[1][5]=2;
    board4[2][0]=2;board4[2][1]=1;board4[2][2]=1;board4[2][3]=1;board4[2][4]=1;board4[2][5]=2;
    board4[3][0]=2;board4[3][1]=1;board4[3][2]=1;board4[3][3]=1;board4[3][4]=1;board4[3][5]=2;
    board4[4][0]=2;board4[4][1]=2;board4[4][2]=2;board4[4][3]=2;board4[4][4]=2;board4[4][5]=2;
    assertFalse("Test isOpen that return false(case1) in right direction",Gomoku.isOpen(1,0,2,2,board4));
    assertFalse("Test isOpen that return false(case1) in left direction",Gomoku.isOpen(2,0,2,2,board4));
    assertFalse("Test isOpen that return false(case1) in up direction", Gomoku.isOpen(0,1,2,2,board4));
    assertFalse("Test isOpen that return false(case1) in down direction",Gomoku.isOpen(0,2,2,2,board4));
    assertFalse("Test isOpen that return false(case1) in upright direction",Gomoku.isOpen(1,1,2,2,board4));
    assertFalse("Test isOpen that return false(case1) in up left direction",Gomoku.isOpen(2,1,2,2,board4));
    assertFalse("Test isOpen that return false(case1) in downleft Direction",Gomoku.isOpen(2,2,2,2,board4));
    assertFalse("Test isOpen that return false(case1) in downright Direction",Gomoku.isOpen(1,2,2,2,board4));
    
    //Test isOpen that return false case 2: being blocked for 8 directions with columns=2; rows =2
    int[][] board5 = new int[6][6];
    board5[0][0]=0;board5[0][1]=0;board5[0][2]=0;board5[0][3]=0;board5[0][4]=0;board5[0][5]=0;
    board5[1][0]=0;board5[1][1]=2;board5[1][2]=2;board5[1][3]=2;board5[1][4]=2;board5[1][5]=0;
    board5[2][0]=0;board5[2][1]=2;board5[2][2]=1;board5[2][3]=2;board5[2][4]=2;board5[2][5]=0;
    board5[3][0]=0;board5[3][1]=2;board5[3][2]=2;board5[3][3]=2;board5[3][4]=2;board5[3][5]=0;
    board5[4][0]=0;board5[4][1]=0;board5[4][2]=0;board5[4][3]=0;board5[4][4]=0;board5[4][5]=0;
    assertFalse("Test isOpen that return false case 2 in right direction",Gomoku.isOpen(1,0,2,2,board5));
    assertFalse("Test isOpen that return false case 2 in left direction",Gomoku.isOpen(2,0,2,2,board5));
    assertFalse("Test isOpen that return false case 2 in up direction", Gomoku.isOpen(0,1,2,2,board5));
    assertFalse("Test isOpen that return false case 2 in down direction",Gomoku.isOpen(0,2,2,2,board5));
    assertFalse("Test isOpen that return false case 2 in upright direction",Gomoku.isOpen(1,1,2,2,board5));
    assertFalse("Test isOpen that return false case 2 in up left direction",Gomoku.isOpen(2,1,2,2,board5));
    assertFalse("Test isOpen that return false case 2 in downleft Direction",Gomoku.isOpen(2,2,2,2,board5));
    assertFalse("Test isOpen that return false case 2 in downright Direction",Gomoku.isOpen(1,2,2,2,board5));
  }
 
  //Test isEnded method
  @Test
  public void testIsEnded(){
    //Test isEnded that return true case1:sum in 1 directions = winCondition for columns =2, columns =2, winCondition =3
    int[][] board6 = new int[6][6];
    board6[0][0]=2;board6[0][1]=0;board6[0][2]=0;board6[0][3]=0;board6[0][4]=0;board6[0][5]=0;
    board6[1][0]=0;board6[1][1]=2;board6[1][2]=0;board6[1][3]=0;board6[1][4]=0;board6[1][5]=0;
    board6[2][0]=2;board6[2][1]=2;board6[2][2]=2;board6[2][3]=0;board6[2][4]=0;board6[2][5]=0;
    board6[3][0]=0;board6[3][1]=2;board6[3][2]=2;board6[3][3]=0;board6[3][4]=0;board6[3][5]=0;
    board6[4][0]=2;board6[4][1]=0;board6[4][2]=2;board6[4][3]=0;board6[4][4]=0;board6[4][5]=0;
    
    assertTrue("Test isEnded that return true case1 in right+left direction",Gomoku.isEnded(2,2,board6,3));
    assertTrue("Test isEnded that return true case1 in up+down direction", Gomoku.isEnded(2,2,board6,3));
    assertTrue("Test isEnded that return true case1 in upright+downleft direction",Gomoku.isEnded(2,2,board6,3));
    assertTrue("Test isEnded that return true case1 in up left+downright direction",Gomoku.isEnded(2,2,board6,3));
    
    //Test isEnded that return true case1:sum in 2 directions = winCondition for columns =2, columns =2, winCondition =3
    int[][] board7 = new int[6][6];
    board7[0][0]=0;board7[0][1]=0;board7[0][2]=0;board7[0][3]=0;board7[0][4]=0;board7[0][5]=0;
    board7[1][0]=0;board7[1][1]=2;board7[1][2]=2;board7[1][3]=2;board7[1][4]=0;board7[1][5]=0;
    board7[2][0]=0;board7[2][1]=2;board7[2][2]=2;board7[2][3]=2;board7[2][4]=0;board7[2][5]=0;
    board7[3][0]=0;board7[3][1]=2;board7[3][2]=2;board7[3][3]=2;board7[3][4]=0;board7[3][5]=0;
    board7[4][0]=0;board7[4][1]=0;board7[4][2]=0;board7[4][3]=0;board7[4][4]=0;board7[4][5]=0;
    
    assertTrue("Test isEnded that return true case2 in right+left direction",Gomoku.isEnded(2,2,board7,3));
    assertTrue("Test isEnded that return true case2 in up+down direction", Gomoku.isEnded(2,2,board7,3));
    assertTrue("Test isEnded that return true case2 in upright+downleft direction",Gomoku.isEnded(2,2,board7,3));
    assertTrue("Test isEnded that return true case2 in up left+downright direction",Gomoku.isEnded(2,2,board7,3));
    
    //Test isEnded that return false case1: doesn't have enough to satisfy winCondition columns =2,rows=2,winCondition=4
    int[][] board8 = new int[6][6];
    board8[0][0]=0;board8[0][1]=0;board8[0][2]=0;board8[0][3]=0;board8[0][4]=0;board8[0][5]=0;
    board8[1][0]=0;board8[1][1]=2;board8[1][2]=2;board8[1][3]=2;board8[1][4]=0;board8[1][5]=0;
    board8[2][0]=0;board8[2][1]=2;board8[2][2]=2;board8[2][3]=2;board8[2][4]=0;board8[2][5]=0;
    board8[3][0]=0;board8[3][1]=2;board8[3][2]=2;board8[3][3]=2;board8[3][4]=0;board8[3][5]=0;
    board8[4][0]=0;board8[4][1]=0;board8[4][2]=0;board8[4][3]=0;board8[4][4]=0;board8[4][5]=0;
    
    assertFalse("Test isEnded that return false case1 in right+left direction",Gomoku.isEnded(2,2,board8,4));
    assertFalse("Test isEnded that return false case1 in up+down direction", Gomoku.isEnded(2,2,board8,4));
    assertFalse("Test isEnded that return false case1 in upright+downleft direction",Gomoku.isEnded(2,2,board8,4));
    assertFalse("Test isEnded that return false case1 in up left+downright direction",Gomoku.isEnded(2,2,board8,4));
    
    //Test isEnded that return false case2: have more than winCondition with rows=2,columns=2, winCondition=3
    int[][] board9 = new int[6][6];
    board9[0][0]=2;board9[0][1]=0;board9[0][2]=0;board9[0][3]=0;board9[0][4]=0;board9[0][5]=0;
    board9[1][0]=0;board9[1][1]=2;board9[1][2]=2;board9[1][3]=2;board9[1][4]=0;board9[1][5]=0;
    board9[2][0]=2;board9[2][1]=2;board9[2][2]=2;board9[2][3]=2;board9[2][4]=0;board9[2][5]=0;
    board9[3][0]=0;board9[3][1]=2;board9[3][2]=2;board9[3][3]=2;board9[3][4]=0;board9[3][5]=0;
    board9[4][0]=2;board9[4][1]=0;board9[4][2]=2;board9[4][3]=0;board9[4][4]=0;board9[4][5]=0;
    
    assertFalse("Test isEnded that return false case2 in right+left direction",Gomoku.isEnded(2,2,board9,3));
    assertFalse("Test isEnded that return false case2 in up+down direction", Gomoku.isEnded(2,2,board9,3));
    assertFalse("Test isEnded that return false case2 in upright+downleft direction",Gomoku.isEnded(2,2,board9,3));
    assertFalse("Test isEnded that return false case2 in upleft+downright direction",Gomoku.isEnded(2,2,board9,3));
  }
  
  //Test movable method
  @Test
  public void testMovable(){
    //Test four-four rule
    //Test the method fail when up+down and upleft+downright direction satisfy three-three is wrong with winCondition =4
    int[][] board10 = new int[6][6];
    board10[0][0]=0;board10[0][1]=0;board10[0][2]=0;board10[0][3]=0;board10[0][4]=0;board10[0][5]=0;
    board10[1][0]=0;board10[1][1]=0;board10[1][2]=0;board10[1][3]=0;board10[1][4]=0;board10[1][5]=0;
    board10[2][0]=0;board10[2][1]=0;board10[2][2]=2;board10[2][3]=0;board10[2][4]=0;board10[2][5]=0;
    board10[3][0]=0;board10[3][1]=0;board10[3][2]=2;board10[3][3]=2;board10[3][4]=0;board10[3][5]=0;
    board10[4][0]=0;board10[4][1]=0;board10[4][2]=2;board10[4][3]=0;board10[4][4]=2;board10[4][5]=0;
    
    assertFalse("Test movable fail when up+down and upleft+downright satisfy four-four",Gomoku.movable(2,2,board10,4,2));
    
    //Test the method fail when up+down and upright+downleft direction satisfy three-three is wrong with winCondition =4
    int[][] board11 = new int[6][6];
    board11[0][0]=0;board11[0][1]=0;board11[0][2]=0;board11[0][3]=0;board11[0][4]=0;board11[0][5]=0;
    board11[1][0]=0;board11[1][1]=0;board11[1][2]=0;board11[1][3]=0;board11[1][4]=0;board11[1][5]=0;
    board11[2][0]=0;board11[2][1]=0;board11[2][2]=2;board11[2][3]=0;board11[2][4]=0;board11[2][5]=0;
    board11[3][0]=0;board11[3][1]=2;board11[3][2]=2;board11[3][3]=0;board11[3][4]=0;board11[3][5]=0;
    board11[4][0]=2;board11[4][1]=0;board11[4][2]=2;board11[4][3]=0;board11[4][4]=0;board11[4][5]=0;
    
    assertFalse("Test movable fail when up+down and upright+downleft satisfy four-four",Gomoku.movable(2,2,board11,4,2));
    
    //Test the method fail when up+down and right+left direction satisfy three-three is wrong with winCondition =4
    int[][] board12 = new int[6][6];
    board12[0][0]=0;board12[0][1]=0;board12[0][2]=0;board12[0][3]=0;board12[0][4]=0;board12[0][5]=0;
    board12[1][0]=0;board12[1][1]=0;board12[1][2]=0;board12[1][3]=0;board12[1][4]=0;board12[1][5]=0;
    board12[2][0]=0;board12[2][1]=0;board12[2][2]=2;board12[2][3]=2;board12[2][4]=2;board12[2][5]=0;
    board12[3][0]=0;board12[3][1]=0;board12[3][2]=2;board12[3][3]=0;board12[3][4]=0;board12[3][5]=0;
    board12[4][0]=0;board12[4][1]=0;board12[4][2]=2;board12[4][3]=0;board12[4][4]=0;board12[4][5]=0;
    
    assertFalse("Test movable fail when up+down and right+left satisfy four-four",Gomoku.movable(2,2,board12,4,2));
    
    //Test three-three rule
    //Test the method fail when up+down and upleft+downright direction satisfy three-three is wrong with winCondition =4
    int[][] board13 = new int[6][6];
    board13[0][0]=0;board13[0][1]=0;board13[0][2]=0;board13[0][3]=0;board13[0][4]=0;board13[0][5]=0;
    board13[1][0]=0;board13[1][1]=0;board13[1][2]=0;board13[1][3]=0;board13[1][4]=0;board13[1][5]=0;
    board13[2][0]=0;board13[2][1]=0;board13[2][2]=2;board13[2][3]=0;board13[2][4]=0;board13[2][5]=0;
    board13[3][0]=0;board13[3][1]=0;board13[3][2]=2;board13[3][3]=2;board13[3][4]=0;board13[3][5]=0;
    board13[4][0]=0;board13[4][1]=0;board13[4][2]=0;board13[4][3]=0;board13[4][4]=0;board13[4][5]=0;
    
    assertFalse("Test movable fail when up+down and upleft+downright satisfy three-three ",Gomoku.movable(2,2,board13,4,2));
    
    //Test the method fail when up+down and upright+downleft direction satisfy three-three is wrong with winCondition =4
    int[][] board14 = new int[6][6];
    board14[0][0]=0;board14[0][1]=0;board14[0][2]=0;board14[0][3]=0;board14[0][4]=0;board14[0][5]=0;
    board14[1][0]=0;board14[1][1]=0;board14[1][2]=0;board14[1][3]=0;board14[1][4]=0;board14[1][5]=0;
    board14[2][0]=0;board14[2][1]=0;board14[2][2]=2;board14[2][3]=0;board14[2][4]=0;board14[2][5]=0;
    board14[3][0]=0;board14[3][1]=2;board14[3][2]=2;board14[3][3]=0;board14[3][4]=0;board14[3][5]=0;
    board14[4][0]=0;board14[4][1]=0;board14[4][2]=0;board14[4][3]=0;board14[4][4]=0;board14[4][5]=0;
    
    assertFalse("Test movable fail when up+down and upright+downleft satisfy three-three ",Gomoku.movable(2,2,board14,4,2));
    
    //Test the method fail when up+down and right+left direction satisfy three-three is wrong with winCondition =4
    int[][] board15 = new int[6][6];
    board15[0][0]=0;board15[0][1]=0;board15[0][2]=0;board15[0][3]=0;board15[0][4]=0;board15[0][5]=0;
    board15[1][0]=0;board15[1][1]=0;board15[1][2]=0;board15[1][3]=0;board15[1][4]=0;board15[1][5]=0;
    board15[2][0]=0;board15[2][1]=0;board15[2][2]=2;board15[2][3]=2;board15[2][4]=0;board15[2][5]=0;
    board15[3][0]=0;board15[3][1]=0;board15[3][2]=2;board15[3][3]=0;board15[3][4]=0;board15[3][5]=0;
    board15[4][0]=0;board15[4][1]=0;board15[4][2]=0;board15[4][3]=0;board15[4][4]=0;board15[4][5]=0;
    
    assertFalse("Test movable fail when up+down and right+left satisfy three-three ",Gomoku.movable(2,2,board15,4,2));
    
    /*Test when the method returns true 
    * when up+down and left+right don't satisfy three-three is wrong with winCondition =4,rows=2,columns=0,turn=1
    */
    int[][] board16 = new int[3][3];
    board16[0][0]=1;board16[0][1]=0;board16[0][2]=0;
    board16[1][1]=1;board16[1][2]=0;board16[1][2]=0;
    board16[2][1]=0;board16[2][2]=1;board16[2][2]=1;
    
    assertTrue("Test movable true up+down and upleft+downright don't satisfy three-three",
               Gomoku.movable(2,1,board16,4,1));
    
    /*Test when the method returns true 
    * when up+down and upleft+downright don't satisfy three-three is wrong with winCondition =4,rows=0,columns=0,turn=1
    */
    int[][] board17 = new int[3][3];
    board17[0][0]=0;board17[0][1]=0;board17[0][2]=0;
    board17[1][1]=1;board17[1][2]=1;board17[1][2]=0;
    board17[2][1]=1;board17[2][2]=0;board17[2][2]=1;
    
    assertTrue("Test movable true up+down and upleft+downright don't satisfy three-three",
               Gomoku.movable(0,0,board17,4,1));
    
    /*Test when the method returns true 
    * when up+down and upright+downleft don't satisfy three-three is wrong with winCondition =4,rows=2,columns=2,turn=1
    */
    int[][] board18 = new int[3][3];
    board18[0][0]=0;board18[0][1]=0;board18[0][2]=0;
    board18[1][1]=0;board18[1][2]=1;board18[1][2]=1;
    board18[2][1]=1;board18[2][2]=0;board18[2][2]=1;
    
    assertTrue("Test movable true up+down and upleft+downright don't satisfy three-three",
               Gomoku.movable(2,2,board18,4,1));
  }
  

}