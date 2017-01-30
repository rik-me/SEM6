import java.util.*;

class tictactoe{
	public static char[][] a ;
	public void printMatrix(){
		int u;
		for(int i=0;i<3;i++){
                        for(int j=0;j<2;j++){
				u=i*3+j+1;
				if(a[i][j]==' ')
                               		System.out.print(u+"|");
				else
					System.out.print(a[i][j]+"|");
                        }
			if(a[i][2]==' ')
				System.out.println(i*3+3);
			else
				System.out.println(a[i][2]);
			if(i!=2){
				for(int j=0;j<6;j++){
					System.out.print("_");
				}
			}
			System.out.println();
                }
	}

	public static boolean check(){
		boolean ans=false;
		if(a[0][0]==a[0][1] && a[0][1] == a[0][2] && a[0][0]!=' ') ans=true;
		else if(a[1][0]==a[1][1] && a[1][1] == a[1][2] && a[1][0]!=' ') ans=true;
		else if(a[2][0]==a[2][1] && a[2][1] == a[2][2] && a[2][0]!=' ') ans=true;
		else if(a[0][0]==a[1][0] && a[1][0] == a[2][0] && a[0][0]!=' ') ans=true;
                else if(a[0][1]==a[1][1] && a[1][1] == a[2][1] && a[0][1]!=' ') ans=true;
                else if(a[0][2]==a[1][2] && a[1][2] == a[2][2] && a[0][2]!=' ') ans=true;
		else if(a[0][0]==a[1][1] && a[1][1] == a[2][2] && a[0][0]!=' ') ans=true;
		else if(a[2][0]==a[1][1] && a[1][1] == a[0][2] && a[2][0]!=' ') ans=true;
		return ans;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		a = new char[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				a[i][j]=' ';
			}
		}
		tictactoe t = new tictactoe();
		t.printMatrix();
		System.out.println("User 1, name?");
		String user1 = sc.nextLine();
		System.out.println("User 2, name?");
		String user2 = sc.nextLine();
		boolean turn = true;
		while(true){
			t.printMatrix();
			if(turn){
				System.out.println(user1+" play your move");
				int k = sc.nextInt();	
				k--;
				int i = k/3;
				int j = k%3;
				if(a[i][j]!=' '){
					System.out.println("Invalid input. Please enter correct input again.");
					continue;
				}
				a[i][j] = 'O';
			}
			else{
				System.out.println(user2+" play your move");
                                int k = sc.nextInt();
				k--;
                                int i = k/3;
                                int j = k%3;
				if(a[i][j]!=' '){
                                        System.out.println("Invalid input. Please enter correct input again.");
                                        continue;
                                }
				a[i][j] = 'X';
			}
			if(check()){
				if(turn) System.out.println("Winner is "+user1);
				else System.out.println("Winner is "+user2);
				t.printMatrix();
				break;
			}
			turn = !turn;
		}	
	}
}
