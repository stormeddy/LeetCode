
public class Permutation {
	//输出全排列
	//回溯法
	public void permute(int array[], int begin, int end)
	{
	    if (begin == end)
	    {
	        print(array, end);
	    }
	    else
	    {
	        for (int j = begin; j <= end; ++j)
	        {
	            swap(array,j,begin);
	            permute(array, begin+1, end); //recursive，enlarge problem's scope
	            swap(array,j,begin); //backtracking
	        }
	    }
	    return;
	}

	public void print(int array[], int end)
	{
	    for (int i = 0; i <= end; ++i)
	    {
	        System.out.print(array[i]);
	        if (i != end)
	        {
	            System.out.print("\t");
	        }
	    }
	    System.out.println();
	    return;
	}
	
	public void swap(int [] arr,int a,int b){
		int t=arr[a];
		arr[a]=arr[b];
		arr[b]=t;
	}
	 	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={1,2,3,4};
		Permutation permutation=new Permutation();
		permutation.permute(a, 0, a.length-1);
	}

}
