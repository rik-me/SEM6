import java.io.*;
import java.util.*;
public class puzzel{
	static Scanner sc = new Scanner(System.in);
	static void print(int[][] prime){
		for(int i=0;i<8;i++){
			System.out.print("_");
		}		
		System.out.println("_");
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(prime[i][j]==20) System.out.print("|"+"X");
				else System.out.print("|"+prime[i][j]);
			}
			System.out.println("|");
			for(int j=0;j<8;j++){
				System.out.print("_");
			}		
			System.out.println("_\n");
		}
	}	
	static void input(int[][] p,int[][] g) throws NullPointerException,IOException{
		System.out.println("Enter the Initial State : ");
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				int x = sc.nextInt();				
				p[i][j]=x;
			}
		}
		System.out.println("Enter the Goal State : ");
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				int x = sc.nextInt();
				g[i][j]=x;
			}
		}
		
	}
	static boolean isSameAsGoalState(int[][] prime,int[][] goal){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(prime[i][j]!=goal[i][j])
					return false;
			}
		}
		return true;
	}
	static boolean isMoveSafe(int x , int y){
		if(x>=0 && x<4 && y>=0 && y<4)
			return true;
		return false;
	}
	public static void main(String[] args) throws NullPointerException,IOException{
		//we take one primary array and pos
		int[][] prime = new int[4][4];
		int[][] goal = new int[4][4];
		int pos_x=0,pos_y=0;//stores the pos of blank cell
		input(prime,goal);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(prime[i][j]==20){
					pos_x=i;pos_y=j;
				}
			}
		}
		int counter=Integer.parseInt(args[0]);//we only allow 30 moves
		while( (counter) > 0 ){
			System.out.println("Goal State");
			print(goal);
			System.out.println("Current State:");
			print(prime);
			System.out.println("Press 4 to go left\nPress 8 to go up\nPress 6 to go right\nPress 2 to go down\n");
			//print the present state
			//ask for input , we have only 4 possible inputs
			System.out.println(counter+" moves left");				
			int move = sc.nextInt();
			//check if the move is possible
			int nx=0,ny=0;
			switch(move){
				case 8: nx=pos_x-1;ny=pos_y;break;
				case 2: nx=pos_x+1;ny=pos_y;break;
				case 4: nx=pos_x;ny=pos_y-1;break;
				case 6: nx=pos_x;ny=pos_y+1;break;
				default: nx=50;ny=50;
			}
			if(isMoveSafe(nx,ny)){
				//if possible make the move , just swap the pos_x with move
				int x = prime[nx][ny];
				prime[nx][ny] = prime[pos_x][pos_y];
				prime[pos_x][pos_y] = x;
				//update the present pos of blank 
				pos_x = nx;
				pos_y = ny;
				//check if same as goal state
				if(isSameAsGoalState(prime,goal)){
					System.out.println("You Win");
					break;
				}
				counter--;
			}
			else{
				System.out.println("Bad Move, Try again\n\n");
			}
			if(counter==0) {
				System.out.println("Sorry you are out of moves. Press 0 to exit or enter the number of moves you want.\n");
				counter = sc.nextInt();			
			}
		}			
	} 
}
