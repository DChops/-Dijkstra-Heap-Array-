import java.util.*;
public class DIjkstraAPP {

	public static void main(String[] args)
	{
		long[] store1 = new long[100];
		long[] store2 = new long[100];
		int counter1=0, counter2 =0;
		
		for(int t =1000; t<10000; t+=100)
		{
			int SIZE = t;
			LinkedList<Edge>[] Edges = (LinkedList<Edge>[]) new LinkedList<?>[SIZE];
			for(int i=0; i<SIZE; i++) {
				Edges[i] = new LinkedList<Edge>();
			}
			
			for(int i=SIZE-1; i>0; i--)
			{
				Edge E = new Edge(i-1,1);
				Edges[i].add(E);
			}

			Dijkstra_Algo2 p2 = new Dijkstra_Algo2(SIZE,Edges,SIZE-1);
			Dijkstra_Algo p = new Dijkstra_Algo(SIZE,Edges,SIZE-1);
		
			long start2 = System.nanoTime();
			p2.Implement();
			long end2 = System.nanoTime();
			
			long start = System.nanoTime();
			p.Implement();
			long end = System.nanoTime();
			
			store1[counter1++]=end-start;
			store2[counter2++]=end2-start2;
		}
		
		for(int i=0; i<100; i++)
		{
			System.out.print(store1[i]+",");
		}
		
		System.out.println("-----------Array 2-------------");
		
		for(int i=0; i<100; i++)
		{
			System.out.print(store2[i]+",");
		}
	}

}
