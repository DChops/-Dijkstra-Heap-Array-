import java.util.LinkedList;
import java.lang.Integer;

public class Dijkstra_Algo {
	
	protected int no_of_vert;
	protected LinkedList<Edge>[] edge_List;
	protected int start_Vertex;
	protected Boolean[] S;
	protected int[] pred;
	protected int[] dist; 
	protected PriorityQueue pq;


	public Dijkstra_Algo(int no_of_vert, LinkedList<Edge>[] edge_List, int start_Vertex) {
		super();
		this.no_of_vert = no_of_vert;
		
		this.edge_List= (LinkedList<Edge>[]) new LinkedList<?>[this.no_of_vert];
		for(int i=0; i<this.no_of_vert; i++) {
			this.edge_List[i] = new LinkedList<Edge>();
		}
		
		for(int i=0; i<this.no_of_vert; i++) {
			this.edge_List[i] = (LinkedList<Edge>) edge_List[i].clone();
		}
		
		this.start_Vertex = start_Vertex;
		
		this.pq = new PriorityQueue(start_Vertex, no_of_vert);//Priority Queue Initialized
		
		this.S = new Boolean[this.no_of_vert];
		this.pred = new int[this.no_of_vert];
		this.dist = new int[this.no_of_vert];
		
		for(int i=0; i<S.length; i++) {
			S[i] = false;
		}
		for(int i=0; i<pred.length; i++) {
			pred[i] = -1;
		}
		for(int i=0; i<dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start_Vertex]=0;
	}
	
	public void Implement()
	{
		while(this.pq.getSize()>0)
		{
			int u = pq.GetElement();
			S[u]=true;
			for(int i=0; i<edge_List[u].size(); i++)
			{
				Edge v = new Edge(0,0);
				v.setVertex(edge_List[u].get(i).getVertex());
				v.setWeight(edge_List[u].get(i).getWeight());
				
				if( S[v.getVertex()]==false && dist[v.getVertex()]>dist[u]+v.getWeight())
				{
					dist[v.getVertex()]=dist[u]+v.getWeight();
					pred[v.getVertex()]=u;
					
					Keyval K = new Keyval(v.getVertex(),dist[v.getVertex()]);
					pq.UpdateHeap(K);
				}
			}
			
		}
	}
	
	public int[] getPred() {
		return pred;
	}

	public int[] getDist() {
		return dist;
	}

}
