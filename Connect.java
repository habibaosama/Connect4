package p7;
import java.util.Scanner;
public class Connect {
	//Global variables
  static char [][] board =  new char[6][7];
   static char turn;
   static int cntR=0;
   static int cntY=0;
  
  public static void initializeBoard() {
	  for (int i=0; i< board.length; i++){
			for (int j=0; j< board[0].length; j++){
				board[i][j] = '.';
			}
		}
  }
  
  
  public static void displayBoard() {
	
             System.out.println(" 1    2   3   4   5   6   7 ");
             System.out.println("-----------------------------");
             
            for(int i=0; i<board.length; i++) {
            	System.out.print("|");
        		for(int j=0; j<board[0].length; j++ ) {
        			System.out.printf(" %c |",board[i][j]);
        		}
        		System.out.println();
        		System.out.println();
        	}
            System.out.println(" 1    2   3   4   5   6   7 ");
            System.out.println("-----------------------------");
            System.out.println("To End the Game Enter '11'");
            
    	}
    
  public static int play(char turn, int col) {
    	for(int i=board.length-1; i>=0; i--) {
    		if(board[i][col]=='.') {
    			if(turn=='R') 
    				board[i][col]='R';
    			else
    				board[i][col]='Y';
    			return 1;
    			 			
    		}
    	}
    	System.out.println("* INVALID Playagain *");
    	return 0;
    	
    }
      
  public static void playerR() {
    	int c=0, col=0;
    	turn='R';
    	while(c==0) {
    		Scanner input = new Scanner(System.in);
    		System.out.println("PLAYER'S R turn ");
    		System.out.print("Choose column:");
    	      col= input.nextInt()-1;
    	      // the user write 11 but I subtract 1 so for me is 10
    		if(col==10) {
    			if(cntR>cntY)
	                System.out.print("PLAYER R is the Winner "  + cntR + " : " + cntY );
	            else if(cntY>cntR)
	            	System.out.print("PLAYER Y is the Winner " + cntR + " : " + cntY);
	            else
	            	System.out.println("DRAW"+ cntR + " : " + cntY );
    		    System.exit(0);
        		
        		
        	}else if(col>=7 || col<0) {
        		c=0;
        		System.out.println("* INVALID Playagain *");
        		
        	}else {
        		c= play(turn,col);
        	}
        	
    	}
    	
    
    }
    
    public static void playerY() {
    	int c=0, col;
    	
    	 turn='Y';
    	while(c==0) {
    		Scanner input = new Scanner(System.in);
    		
    		System.out.println("PLAYER'S Y turn ");
    		System.out.print("Choose column:");
    	      col= input.nextInt()-1;
    	      
    	      if(col==10) { 
    	      if(cntR>cntY)
	                System.out.print("PLAYER R is the Winner "  + cntR + " : " + cntY );
    	      
    	      else if(cntY>cntR)
	            	System.out.print("PLAYER Y is the Winner " + cntR + " : " + cntY);
	            else
	            	System.out.println("DRAW"+ cntR + " : " + cntY );
      			
      		    System.exit(0);
          		
          		
          	}else if(col>=7 || col<0) {
          		c=0;
          		System.out.println("* INVALID Playagain *");
          		
          	}else {
          		c= play(turn,col);
          	}
        	
    	}
    	 
    	
    	
    }
    
    public static int points(char turn) {
    	//check horizontal
    	
    	
    	for(int i=0; i<board.length; i++) {
    		for(int j=0; j<board[i].length -3; j++) {
    			if(board[i][j]==turn && board[i][j+1]==turn && board[i][j+2]==turn && board[i][j+3]==turn) {
                       return 1;
    		
    			}		
    		 }
    	}
    	// check vertical
    	for(int i=0; i<board.length -3; i++) {
    		for(int j=0; j<board[0].length; j++) {
    			if(board[i][j]==turn && board[i+1][j]==turn && board[i+2][j]==turn && board[i+3][j]==turn) {
    				return 1;
    			}
    		}
    	}
    
    	//check diagonal upward
    	
    	for(int i=3; i<board.length ; i++) {
    		for(int j=0; j<board[0].length -3 ; j++) {
    			if(board[i][j]==turn && board[i-1][j+1]==turn && board[i-2][j+2]==turn && board[i-3][j+3]==turn)
    				return 1;
    		}
    	}
    	
    	//check diagonal downward
    	for(int i=2 ; i>=0; i--) {
    		for(int j=3; j>=0; j--) {
    			if(board[i][j]==turn && board[i+1][j+1]==turn && board[i+2][j+2]==turn && board[i+3][j+3]==turn)
    				return 1;
    		}
    	}
    	
    	
    	
    	return 0;
    }
    
    
    
    
    public static void main(String[] args) {
    	int x =1;
    	   
       initializeBoard();
        displayBoard();
    	     
        while(x==1) {
        	
    	        playerR();
    	        
    	        if(points('R')==1) {
    	        	cntR++;
    	        	displayBoard();
    	        	initializeBoard();
    	        	displayBoard();
    	        System.out.println("PLAYER'S R points " + cntR );
    	        System.out.println("PLAYER'S Y points " + cntY );
    	        }else {
    	        	 displayBoard();
    	        	 System.out.println("PLAYER'S R points " + cntR );
    	    	     System.out.println("PLAYER'S Y points " + cntY );
    	        }
    	       
    	        playerY();
    	        
    	        if(points('Y')==1) {
    	        	cntY++;
    	        	displayBoard();
    	        	initializeBoard();
    	        	displayBoard();
   	        	    System.out.println("PLAYER'S R points " + cntR);
   	    	        System.out.println("PLAYER'S Y points " + cntY);
    	        }else {
    	        	displayBoard();
   	        	    System.out.println("PLAYER'S R points " + cntR);
   	    	        System.out.println("PLAYER'S Y points " + cntY);
    	        }
    	        	         
        }
        
        
    }  	
}	
    


