package assignment2;
import java.util.Scanner;
public class SubSetSumRecursion49 {
	public static int[][] find(int a[],int currSum,int index,int sum,int sol[],int subSets[][])
	{
		if(currSum == sum)
		{
			int set[] = new int[0];
			for(int i=0;i<sol.length; i++)
			{
				if(sol[i]==1)
					set = addElement(set,a[i]);
			}
			subSets = addSet(subSets,set);
		}
		else if(index == a.length)
			return subSets;
		else
		{
			sol[index] = 1;
			currSum += a[index];
			subSets = find(a, currSum, index, sum, sol, subSets);
			currSum -= a[index];
			sol[index] = 0;
			subSets = find(a, currSum, index, sum, sol, subSets);
		}
		return subSets;
	}
	private static int[][] addSet(int[][] subSets, int[] set) {
		int currLen=subSets.length;
		int temp[][] = new int[currLen+1][]; 	
		for(int i=0;i<currLen;i++)
			temp[i]=subSets[i];
		temp[currLen] = set;
		return temp;
	}
	private static int[] addElement(int[] set, int e) {
		int currLen=set.length;
		int temp[] = new int[currLen+1]; 
		for(int i=0;i<currLen;i++)
			temp[i]=set[i];
		temp[currLen] = e;
		return temp;
	}
	private static void printTuples(int [][] tuples) {
		for(int i=0;i<tuples.length;i++) {
			System.out.print("<");
			for(int j=0;j<tuples[i].length;j++)
				if(j==tuples[i].length-1)
					System.out.print(tuples[i][j]);
				else 
					System.out.print(tuples[i][j] + ",");
			System.out.print(">");
			System.out.println();
	   }		
	}
	public static void main(String[] args) {
  	  int l;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array :");
		l = sc.nextInt();
		System.out.println("Enter "+(l)+" elements into array:");
		int a[] = new int[l],d;
		for(int i=0;i<l;i++)
			a[i]=sc.nextInt();
		System.out.println("Enter the sum :");
		d=sc.nextInt();
		sc.close();
      int[] solution = new int[a.length];
      int subSets[][] = new int[0][];
      subSets = find(a, 0, 0, d, solution,subSets);
      printTuples(subSets);
    }
   /* public static void find(int[] a, int currSum, int index, int sum,
          int[] solution) {
        if (currSum == sum) {
          for (int i = 0; i < solution.length; i++) {
            if (solution[i] == 1) {
              System.out.print( a[i]+" ");
            } 
          }
          System.out.println();
        } else if (index == a.length) {
        	return;
        } else {
          solution[index] = 1;// select the element
          currSum += a[index];
          find(a, currSum, index + 1, sum, solution);
          currSum -= a[index];	
          solution[index] = 0;// do not select the element
          find(a, currSum, index + 1, sum, solution);
        }
        return;
      }
      public static void main(String[] args) {
    	  int l;
  		Scanner sc = new Scanner(System.in);
  		System.out.println("Enter the length of array :");
  		l = sc.nextInt();
  		System.out.println("Enter "+(l)+" elements into array:");
  		int a[] = new int[l],d;
  		for(int i=0;i<l;i++)
  			a[i]=sc.nextInt();
  		System.out.println("Enter the sum :");
  		d=sc.nextInt();
  		sc.close();
        int[] solution = new int[a.length];
        find(a, 0, 0, d, solution);
      }
      */
}