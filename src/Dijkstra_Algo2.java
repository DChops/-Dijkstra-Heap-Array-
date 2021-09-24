import java.util.LinkedList;

public class Dijkstra_Algo2 extends Dijkstra_Algo{

	protected NewQueue pq;
	protected int[][] array;
	
	public Dijkstra_Algo2(int no_of_vert, LinkedList<Edge>[] edge_List, int start_Vertex) {
		super(no_of_vert, edge_List, start_Vertex);
		pq = new NewQueue(start_Vertex, no_of_vert);
		array = new int[no_of_vert][no_of_vert];
		
		for(int i=0; i<no_of_vert; i++)
		{
			for(int j=0; j<edge_List[i].size(); j++)
			{
				array[i][edge_List[i].get(j).getVertex()] = edge_List[i].get(j).getWeight();
			}
		}
	}
	public void Implement()
	{
		int k = pq.getSize();
		while(k>0)
		{
			int u = pq.GetElement();
			S[u]=true;
			for(int i=0; i<no_of_vert; i++)
			{
				if(array[u][i]==0)
				{
					continue;
				}
				Edge v = new Edge(0,0);
				v.setVertex(i);
				v.setWeight(array[u][i]);
				
				if( S[v.getVertex()]==false && dist[v.getVertex()]>dist[u]+v.getWeight())
				{
					dist[v.getVertex()]=dist[u]+v.getWeight();
					pred[v.getVertex()]=u;
					
					Keyval K = new Keyval(v.getVertex(),dist[v.getVertex()]);
					pq.UpdateHeap(K);
				}
			}
			k--;
		}
	}
}
