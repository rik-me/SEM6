import java.util.*;
class tower2{
    static HashMap<String,Deque<Integer>> H;
    int size;
    public tower2(int N){
        size=N;
        H = new HashMap<String,Deque<Integer>>();
        H.put("SRC",new ArrayDeque<Integer>(N));
        H.put("DEST",new ArrayDeque<Integer>(N));
        H.put("AUX",new ArrayDeque<Integer>(N));
        //fill the source
        for(int i=N;i>0;i--){
            H.get("SRC").push(i);
        }
        printNicely();
    }
    static void printNicely(){
        Iterator s = H.get("SRC").iterator();
        Iterator d = H.get("DEST").iterator();
        Iterator a = H.get("AUX").iterator();
        System.out.println("*************************************");
        System.out.print("SOURCE : ");
        while(s.hasNext())   System.out.print(s.next()+" ");
        System.out.println();
        System.out.print("DEST : ");
        while(d.hasNext())   System.out.print(d.next()+" ");
        System.out.println();
        System.out.print("AUX : ");
        while(a.hasNext())   System.out.print(a.next()+" ");
        System.out.println();
    }
    public static void f(int N,String src,String dest,String aux){
        if(N>0){
            f(N-1,src,aux,dest);
            //System.out.println(src+" to "+dest);
            int move = H.get(src).pop();
            H.get(dest).push(move);
            printNicely();
            f(N-1,aux,dest,src);
        }
    }
    public static void main(String[] args){
        String src = "SRC",dest = "DEST" , aux = "AUX";
        int N = Integer.parseInt(args[0]);
        tower2 t = new tower2(N);
        t.f(N,src,dest,aux);
    }
}