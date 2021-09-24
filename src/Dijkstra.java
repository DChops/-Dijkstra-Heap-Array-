//import java.util.*;
//public class Dijkstra {
//	
//	private int no_of_vert;
//	private LinkedList<Edge>[] edge_List;
//	private int start_Vertex;
//	private Boolean[] S;
//	private int[] pred;
//	private int[] dist; 
//	private int[] heap;
//	private int heapsize;
//
//
//	public Dijkstra(int no_of_vert, LinkedList<Edge>[] edge_List, int start_Vertex) {
//		super();
//		this.no_of_vert = no_of_vert;
//		
//		this.edge_List= (LinkedList<Edge>[]) new LinkedList<?>[this.no_of_vert];
//		for(int i=0; i<this.no_of_vert; i++) {
//			this.edge_List[i] = new LinkedList<Edge>();
//		}
//		
//		for(int i=0; i<this.no_of_vert; i++) {
//			this.edge_List[i] = (LinkedList<Edge>) edge_List[i].clone();
//		}
//		
//		this.start_Vertex = start_Vertex;
//		
//		this.heap = new int[this.no_of_vert];
//		this.heapsize = no_of_vert;
//		
//		this.S = new Boolean[this.no_of_vert];
//		this.pred = new int[this.no_of_vert];
//		this.dist = new int[this.no_of_vert];
//		
//		for(int i=0; i<S.length; i++) {
//			S[i] = false;
//		}
//		for(int i=0; i<pred.length; i++) {
//			pred[i] = -1;
//		}
//		for(int i=0; i<dist.length; i++) {
//			dist[i] = 10000;
//		}
//		for(int i=0; i<heap.length; i++) {
//			heap[i] = i;
//		}
//		
//		dist[start_Vertex]=0;
//	}
//
//	private int Parent(int index)
//	{
//		return (index+1)/2 -1;
//	}
//	private int LeftChild(int index)
//	{
//		return 2*(index+1)- 1;
//	}
//	private int RightChild(int index)
//	{
//		return 2*(index+1);
//	}
//	private void Heapify(int index)
//	{
//		if(LeftChild(index)>=this.heapsize && RightChild(index)>=this.heapsize)
//		{
//			return;
//		}
//		
//		Heapify(LeftChild(index));
//		
//		if(RightChild(index)<this.heapsize)
//		{
//			Heapify(RightChild(index));
//		}
//		
//		if(RightChild(index)<this.heapsize && dist[heap[RightChild(index)]]<=dist[heap[LeftChild(index)]] && dist[heap[RightChild(index)]]<dist[heap[index]])
//		{
//			int temp = heap[index];
//			heap[index] = heap[RightChild(index)];
//			heap[RightChild(index)] = temp;
//		}
//		else if(dist[heap[LeftChild(index)]]<dist[heap[index]])
//		{
//			int temp = heap[index];
//			heap[index] = heap[LeftChild(index)];
//			heap[LeftChild(index)] = temp;
//		}
//	}
//	
//	private void FixHeap(int index)
//	{
//		if(LeftChild(index)>=this.heapsize && RightChild(index)>=this.heapsize)
//		{
//			return;
//		}
//		
//		if(RightChild(index)<this.heapsize && dist[heap[RightChild(index)]]<=dist[heap[LeftChild(index)]] && dist[heap[RightChild(index)]]<dist[heap[index]])
//		{
//			int temp = heap[index];
//			heap[index] = heap[RightChild(index)];
//			heap[RightChild(index)] = temp;
//			FixHeap(RightChild(index));
//		}
//		else if(dist[heap[LeftChild(index)]]<dist[heap[index]])
//		{
//			int temp = heap[index];
//			heap[index] = heap[LeftChild(index)];
//			heap[LeftChild(index)] = temp;
//			FixHeap(LeftChild(index)); 
//		}
//	}
//	private void Bubble(int index)
//	{
//		if( index==0 )
//		{
//			return;
//		}
//		else
//		{
//			if(heap[index]<heap[Parent(index)])
//			{
//				int temp = heap[Parent(index)];
//				heap[Parent(index)] = heap[index];
//				heap[index] = temp;
//				Bubble(Parent(index));
//			}
//		}
//	}
//	
//	private int GetElement()
//	{
//		int temp = heap[0];
//		heap[0] = heap[heapsize-1];
//		heapsize--;
//		return temp;
//	}
//	
//	public void Implement()
//	{
//		Heapify(0);
//		while(this.heapsize!=0)
//		{
//			int u = GetElement();
//			FixHeap(0);
//			S[u]=true;
//			for(int i=0; i<edge_List[u].size(); i++)
//			{
//				Edge v = new Edge(0,0);
//				v.setVertice(edge_List[u].get(i).getVertice());
//				v.setWeight(edge_List[u].get(i).getWeight());
//				
//				if( S[v.getVertice()]==false && dist[v.getVertice()]>dist[u]+v.getWeight())
//				{
//					dist[v.getVertice()]=dist[u]+v.getWeight();
//					pred[v.getVertice()]=u;
//					Bubble();
//				}
//			}
//		}
//	}
//
//	public int[] getPred() {
//		return pred;
//	}
//
//	public int[] getDist() {
//		return dist;
//	}
//}
