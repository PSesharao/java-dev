import java.util.ArrayList;
import java.util.HashSet;

public class Assignment {
	
	private static String[] removeTheElements(String a[] , HashSet<String> exclusiveSet ) {
		
		String aCopy[] = new String[a.length-exclusiveSet.size()] ;
		int j= 0 ;
		for(int i=0 ; i<a.length ; i++) {
			if( !exclusiveSet.contains(a[i]) )
			{
				aCopy[j] = a[i] ;
				j++ ;
			}
		}
		return aCopy;
		
	} 
	
	public static void main(String[] args)
    {
		String a[] = {"tab1" , "tab2" , "tab3" , "tab4"  , "tabheaders"} ; 
		String b[] = {"tab1" , "tab2" , "tab3"} ; 
		
		HashSet<String> bSet = new HashSet<>();
		
		for(int i=0 ; i<b.length ; i++) {
			bSet.add(b[i]) ; 
		}
		
		// This for a[]-b[] + "tabheaders"
		
		HashSet<String> exclusiveSet = new HashSet<>(); 
		for(int i=0 ; i<a.length ; i++) {
			
			if(!bSet.contains(a[i]) && (a[i].compareToIgnoreCase("tabheaders")!=0)  ) 
			{
				exclusiveSet.add(a[i]) ; 
			}
		}
	

//       for(String s : exclusiveSet ) {
//    	   System.out.println(s);
//       }
       
       a = removeTheElements(a , exclusiveSet ) ;
       
       // After removal 
       
       for(int i=0 ; i<a.length ; i++) {
    	   System.out.println(a[i]); 
       }
       

       
    }
}
