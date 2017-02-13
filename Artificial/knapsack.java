import java.util.*;

class solComparator implements Comparator<solution>{
	public int compare(solution s1, solution s2){
		if(s1.value==s2.value) return 0;
		else if(s1.value<s2.value) return 1;
		else return -1;
	}
}

class solution{
	public int[] data;
	public int size;
	public int value;
	public int weight;
	public solution(int n){
		size = n;		
		value = 0;
		weight = 0 ;
		data = new int[n];
		for(int i=0;i<n;i++){
			int x = ((int)(Math.random()*10000000))%2;
			data[i] = x;
		}
	}
	public void calculateValue(int[] w,int[] v){
		for(int i=0;i<size;i++){
			if(data[i]==1){
				weight += w[i];
				value += v[i];	
			}
		}	
	}
	public boolean isPossible(int capacity){
		return weight <= capacity;
	}

	public solution mutate(){
		solution s1 = this;
		int randomIndex = ((int)(Math.random()*10000000))%size;
		s1.data[randomIndex] = 1-s1.data[randomIndex];
		return s1;
	}
	
	public void crossover(solution s, solution s1, solution s2){
		for(int i=0;i<size;i++){
			s1.data[i] = s.data[i];
			s2.data[i] = this.data[i];
		}
		for(int i=size/2;i<size;i++){
			int t = s1.data[i];
			s1.data[i] = s2.data[i];
			s2.data[i] = t;
		}
	}
}



class knapsack{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] w = new int[n];
		int[] v = new int[n];
		for(int i=0;i<n;i++){
			w[i]= sc.nextInt();
			v[i]= sc.nextInt();
		}		
		int capacity = sc.nextInt();
		double crossoverProb = sc.nextDouble();
		double mutationProb = sc.nextDouble();
		int numberOfIterations = sc.nextInt();
		int populationSize = sc.nextint();		
		solution[] s = new solution[populationSize];
		for(int i=0;i<populationSize;i++){
			solution t = new solution(n);
			t.calculateValue(w,v);
			if(t.weight>capacity) i--;	
			else s[i] = t;					
		}		
		Arrays.sort(s,new solComparator());	
		while(numberOfIterations>0){
			int k=0;
			for(int i=populationSize/2;i<n;){
				int random = ((int)(Math.random()*10000000))%100;
				if(random>crossoverprob) {
					solution t1 = new solution(n);
					solution t2 = new solution(n);
					int x = ((int)(Math.random()*10000000))%n/2;
					int y = ((int)(Math.random()*10000000))%n/2;
					s[x].crossover(s[y],t1,t2);
					k++;
					s[i++] = t1;
					if(i<n) s[i++]= t2;
				}
				if(random>mutationProb) {
					int x = ((int)(Math.random()*10000000))%n/2;
					int y = ((int)(Math.random()*10000000))%n/2;
					solution t = s[k++].mutate();
					s[i++]=t;
				}				
			}
			numberOfIterations--;
			Arrays.sort(s,new solComparator());
		}	
		System.out.println(s[0].value);
	}
}

