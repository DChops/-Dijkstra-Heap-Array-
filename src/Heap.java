import java.lang.Integer;
public class Heap{
	protected Keyval arr[];
	protected int index[];
	protected int source;
	protected int size;
	
	public Heap(int source, int size) {
		super();
		this.source = source;
		this.size = size;
		this.index = new int[size];
		
		this.arr = new Keyval[size];
		for(int t =0; t<size; t++)
		{
			this.arr[t] = new Keyval();
		}
		
		for(int i=0; i<size; i++)
		{
			this.arr[i].setVertex(i);
			this.arr[i].setWeight(Integer.MAX_VALUE);
			
			this.index[i] = i;//index is initially same as vertex
		}
		
		this.arr[source].setWeight(0);//source Vertex at source index
		
		Swap(source,0);//Heapify
	}
	
	protected int Parent(int index)
	{
		return (index+1)/2 -1;
	}
	protected int LeftChild(int index)
	{
		return 2*(index+1)- 1;
	}
	protected int RightChild(int index)
	{
		return 2*(index+1);
	}
	protected void Swap(int A, int B)
	{
		int vertex = this.arr[A].getVertex();
		this.arr[A].setVertex(this.arr[B].getVertex());
		this.arr[B].setVertex(vertex);
		
		int weight = this.arr[A].getWeight();
		this.arr[A].setWeight(this.arr[B].getWeight());
		this.arr[B].setWeight(weight);
		
		int temp = index[arr[A].getVertex()];
		index[arr[A].getVertex()]=index[arr[B].getVertex()];
		index[arr[B].getVertex()]=temp;
	}
	public int getSize() {
		return size;
	}
	
}
