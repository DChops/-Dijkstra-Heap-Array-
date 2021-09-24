import java.lang.Integer;
public class NewQueue extends PriorityQueue{

	public NewQueue(int source, int size) {
		super(source, size);
		// TODO Auto-generated constructor stub
	}
	
	protected int GetElement()
	{
		int j;
		for(j=0; j<this.size; j++)
		{
			if(arr[j].getVertex()!=-1)
			{
				break;
			}
		}
		
		Keyval min = new Keyval(arr[j].getVertex(),arr[j].getWeight());
		
		for(int i=j+1; i<this.size; i++)
		{
			if(arr[i].getVertex()!=-1 && arr[i].getWeight()<min.getWeight())
			{
				min.setVertex(arr[i].getVertex());
				min.setWeight(arr[i].getWeight());
			}
		}
		
		arr[index[min.getVertex()]].setVertex(-1);
		this.index[min.getVertex()] = -1;
		
		return min.getVertex();
	}
	
	protected void UpdateHeap(Keyval A)
	{
		arr[index[A.getVertex()]].setWeight(A.getWeight());
	}
}
