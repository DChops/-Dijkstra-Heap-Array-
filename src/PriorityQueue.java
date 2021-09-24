
public class PriorityQueue extends Heap{

	public PriorityQueue(int source, int size) {
		super(source, size);
		// TODO Auto-generated constructor stub
	}
	
	protected void FixHeap(int index)
	{
		if(LeftChild(index)>=this.size && RightChild(index)>=this.size)
		{
			return;
		}
		if(RightChild(index)<this.size && arr[RightChild(index)].getWeight()<=arr[LeftChild(index)].getWeight() && arr[RightChild(index)].getWeight()<arr[index].getWeight())
		{
			Swap(index, RightChild(index));
			FixHeap(RightChild(index));
		}
		else if(arr[LeftChild(index)].getWeight()<arr[index].getWeight())
		{
			Swap(index, LeftChild(index));
			FixHeap(LeftChild(index)); 
		}
	}
	
	protected int GetElement()
	{
		int temp = arr[0].getVertex();
		Swap(0,size-1);
		index[arr[size-1].getVertex()]=-1;//This element is no longer in the heap
		size--;
		FixHeap(0);
		
		return temp;
	}
	
	private void Bubble(int index)
	{
		if(index==0)
		{
			return;
		}
		else
		{
			if(arr[index].getWeight()<arr[Parent(index)].getWeight())
			{
				Swap(index, Parent(index));
				Bubble(Parent(index));
			}
		}
	}
	
	protected void UpdateHeap(Keyval A)
	{
		arr[index[A.getVertex()]].setWeight(A.getWeight());
		Bubble(index[A.getVertex()]);
	}
	
	protected Keyval[] ReturnHeap()
	{
		return arr;
	}
}
