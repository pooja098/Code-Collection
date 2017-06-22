/*
 * this class provides the method to perform addition on larger numbers( ranging 10^32, i.e.atomic weight) in String format
*/
public class StringAddition {

	private static char carry='0';
	
	public static String addStrings(String m1, String m2){
		if(m1.length()<m2.length())
		{
			String temp=new String(m1);
		
			m1=m2;
			m2=temp;
			System.out.println("longer m1 : "+m1+"-  "+" shorter m2 : "+m2+"-");
		}
		
	//part 1: making strings of same length
		
		int diff= m1.length()-m2.length();
		System.out.println("diff : -"+diff+"-");
		for(int i=0; i<diff; i++)
			m2="0"+m2;
		
	//part 2: performing addition

		String sum="";
		for(int i=m1.length()-1; i>=0; i-- )
		{
			//System.out.println("sum: "+sum+"-");
			sum=addChar(m1.charAt(i), m2.charAt(i))+sum;
		}
		if(carry=='1')
		{
			carry='0';
			System.out.println("sum : "+sum+"-");
			return "1"+sum;
		}
		System.out.println("sum : "+sum+"-");
		return sum;
		
	}
	
	//method that adds characters
	private static String addChar(char c1, char c2) {	
		//assuming c1 and c2 fall into inclusive range of '0' to '9' 
		//System.out.println("c1, c2 : "+c1+"--"+c2);
		char sum=(char)(c1+c2+carry-2*48);		//ASCII values of 'c1', 'c2', 'carry' are added, then sum is assigned corresponding character to result of addition 
		carry='0';									//carry is made zero in every call as it is a static property
	
		int aa=(int)(c1+c2+carry-2*48);
		//System.out.println("ASCII sm : "+aa);
		if(sum>'9'){							//if resulting ASCII value is >(ASCII value of '9')
												//resulting char wont fall into (0,9) (inclusive)
			carry='1';							//for char sum > 9, carry for next addition will be '1'
			
			//System.out.println("chr sm carr : "+sum+"-");
			return Character.toString((char) (sum-10));				//subtraction will reduce ASCII value to make it <(ASCII value of '9')
		}
		//System.out.println("chr sm : "+sum+"-");
		return Character.toString(sum);									// otherwise original sum is returned
			
	}
	
}
