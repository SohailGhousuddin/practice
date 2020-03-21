package sample.sort.test;

public class QuickSort {
	private int arr[];
	private int length;
	
	public void qSort(int[] array)
	{
		this.arr= array;
		length = array.length;
		QuickSortArray(0,length-1);
		
		
	}
	
	public void QuickSortArray(int lowIndex, int highIndex)
	{
		 int i = lowIndex;
	        int j = highIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = arr[lowIndex+(highIndex-lowIndex)/2];
	        // Divide into two arrays
	        while (i <= j) {
	            /**
	             * In each iteration, we will identify a number from left side which 
	             * is greater then the pivot value, and also we will identify a number 
	             * from right side which is less then the pivot value. Once the search 
	             * is done, then we exchange both numbers.
	             */
	            while (arr[i] < pivot) {
	                i++;
	            }
	            while (arr[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowIndex < j)
	        	QuickSortArray(lowIndex, j);
	        if (i < highIndex)
	        	QuickSortArray(i, highIndex);
	}
	 private void exchangeNumbers(int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is testing");
		
		int[] adArray= {2,7,30,54,1,10,33,25,47,59};
		QuickSort qs = new QuickSort();
		qs.qSort(adArray);
		for(int i=0;i<adArray.length;i++)
		{
			System.out.print(adArray[i]);
			System.out.print(",");
		}
		
		

	}

}
