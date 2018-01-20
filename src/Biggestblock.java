
/*
    CIS 209 INTRO TO JAVA
    CHAPTER 8 PROJECT
    11-20-17
    
    PROBLEM: LARGEST BLOCK
    GIVEN A SQUARE MATRIX 0 -1
    FIND MAX SQUARE SUB-MATRIX
    WHOSE ELEMENTS ARE ALL 1S.
    PROMPT USER TO ENTER NUMBER
    OF ROWS IN SUB MATRIX.
 */

  import java.util.Scanner;

public class Biggestblock {
    /*MAIN METHOD*/
	public static void main(String[] args) {
	//SCANNER SYSTEM	
	Scanner input = new Scanner(System.in);
	//PRINT USER PROMPT
	System.out.print("Enter number of rows in matrix: ");
	//DECLARE SIZE INTEGER
	int size = input.nextInt();
	//INT DOUBLE ARRAY - SIZE
	int[][]m = new int[size][size];
	//PRINT LINE ENTER MATRIX BY ROW
	System.out.println("Enter matrix Row by Row: ");
	//FOR LOOP: I SET TO 0 
	for(int i = 0; i < m.length; i++)
		//FOR LOOP: J SET TO 0
		for(int j = 0; j < m[i].length; j++)
			//ROW: I COLUMN: J
			m[i][j] = input.nextInt();
	//INT I LOCATION FIND BIGGEST BLOCK
	int[] location = findBiggestBlock(m);
	//IF LOCATION NOT NULL
	if(location != null)
	{
		//PRINT F - SQUARE SUB MATRIX 
		System.out.printf("Max square sub-matrix is at (%d, %d) with size %d",
				location[0], location[1], location[2]);
	}
}
	//FIND BIGGEST BLOCK ARRAY METHOD	
	public static int[] findBiggestBlock(int[][] m)
	{
		//INT HIGHEST SQUARE SET TO NULL
		int[] highestSquare = null;
		//INT HIGHEST SIZE SET TO 0
		int highestSize = 0; 
		//FOR LOOP I SET TO 0
		for(int i = 0; i < m.length; i++)
		{
			//FOR LOOP J SET TO 0
			for(int j = 0; j < m[0].length; j++)
			{
				//INT OCCURRENCE - M, I, J
				int occurrence = getOccurrence(m, i, j);
				//OCCURRENCE LESS THAN 2
				if(occurrence < 2) continue;
				//SCAN SQUARE 
				if (scanSquare(m, i, j, occurrence) && occurrence > highestSize)
				{   //HIGHEST SIZE SET TO OCCURRENCE
					highestSize = occurrence; 
					//HIGHEST SQUARE SET TO NEW INT ARRAY
					highestSquare = new int[] {i, j, occurrence};
					
				}
			}
		}
		      //RETIRM HIGHEST SQUARE
		      return highestSquare; 
	}
	
	//PUBLIC METHOD GET OCCURRENCE
	public static int getOccurrence(int[][] m, int row, int column)
	{
		//OCCURRENCE SET TO 0
		int occurrence = 0; 
		//IF COLUMN SET TO LENGTH MINUS 1
		if(column == m[0].length -1) return 0;
		//FOR LOOP J SET TO COLUMN
		for(int j = column; j < m[0].length; j++)
		{
			//ROW J EQUALS 1
			if (m[row][j] == 1)
			{   //OCCURRENCE INCREMENT
				occurrence++;
				//J SET TO LENGTH - 1
				if (j == m[0].length - 1) return occurrence;
			} 
			//ELSE IF OCCURRENCE GREATER THAN 1
			else if (occurrence > 1) return occurrence;
		//ELSE RETURN 0	
		else return 0;
		}
	     return 0; 
	}
	//PUBLIC BOOLEAN SCAN SQUARE INT ARRAY
	public static boolean scanSquare(int[][] m, int row, int column, int occurrence)
	{
		//IF ROW PLUS OCCURRENCE M LENGTH
		if (row + occurrence > m.length) return false;
		//FOR LOOP: I  OCCURRENCE
		for(int i = row; i < occurrence + row; i++)
		{
			//FOR LOOP J SET TO COLUMN
			for(int j = column; j < occurrence + column; j++)
			{
				//IF M I J ARRAY RETURN FALSE
				if (m[i][j] == 0) return false;
			}
		}
		//RETURN TRUE 
		   return true; 
	}
}
