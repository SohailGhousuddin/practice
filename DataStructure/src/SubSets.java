import java.util.ArrayList;

public class SubSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    System.out.println("String Testing");
    
    int[] set1= {1,2};
    ArrayList<Integer> set2 = new ArrayList<>();
    for(int s:set1)
    {
    	set2.add(s);
    }
   // print_Set(set2);
    SubSetsFun(set2);
    

	}
	
	public static void SubSetsFun(ArrayList<Integer> givenArray)
	{
		ArrayList<Integer> subsetArray = new ArrayList<>();
		helper(givenArray,subsetArray,0);
		
		
	}
	
	public static void helper(ArrayList<Integer> givenArray, ArrayList<Integer> subsetArray,int i)
	{
		
		
		if(i==givenArray.size())
		{
			
			print_Set(subsetArray);
			return;
		}
		
		else
		{
			subsetArray.add(i,null);
			helper(givenArray,subsetArray,i+1);
			subsetArray.add(i,givenArray.get(i));
			helper(givenArray,subsetArray,i+1);
			
		}
		
	}
	
	public static void print_Set(ArrayList<Integer> arraytoPrint)
	{
		System.out.println();
		for(int i=0;i<arraytoPrint.size()-1l;i++)
		{
			System.out.println(arraytoPrint.get(i)+",");
		}
	}
}
