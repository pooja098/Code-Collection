
public class MoleculeR {

	private String formula;
	private String m_weight="";
	static private BSTofAtom atomic_table=null;
	
	public MoleculeR(String formla)
	{
		this.formula=formla;
	}

	public static void setBST(BSTofAtom head)
	{
		atomic_table=head;
	}
	
	private void addM_Weight(String wt)
	{
		m_weight=StringAddition.addStrings(m_weight, wt);
	}
	
	public String getM_Weight()
	{
		int error_code=findWeight(0);
		if (error_code != 0){
			System.out.println(" error finding weight !");
			return null;
		}
		else
			return m_weight;
	}
	
	private int findWeight(int start){
		
		String weight="";
		for(int i=start; i<formula.length(); i++)
		{
			char currentChar=formula.charAt(i);
			System.out.print(" -> "+currentChar+"  ");
			
			if (currentChar>='A' && currentChar<='Z')
			{
				//System.out.println("len : "+formula.length());
				String ele_name="";
				if( (i+1) < formula.length())
				{
					int step_forward_index=i+1;
				
					while ( step_forward_index<formula.length() && formula.charAt(step_forward_index)>='a' && formula.charAt(step_forward_index)<='z' ) 
					{	step_forward_index++;
					System.out.println(step_forward_index);}
					
					ele_name=formula.substring(i, step_forward_index);
					i=step_forward_index-1;
					//System.out.println("if ele-name : "+ele_name);
				}
				else ele_name=Character.toString(currentChar);
					
					System.out.print("element : "+ele_name+" /");
				
					String ele_mass=atomic_table.searchTree(ele_name).getMass();
					System.out.println("  mass : "+ele_mass);
				
					weight=StringAddition.addStrings(weight, ele_mass);
					
				
				
			}
			else
				switch(currentChar)
				{
					case '(':						//beginning of new group is found
					{									
						//weight=StringAddition.addStrings(weight, findWeight(i+1) );
					
						i=findWeight(i+1);			//function will return the index where the group started here ends
						System.out.println();
						break;
					}
					case ')':						//end of group	
					{
					
					// part 1: check if there is a number following the ')' and finding it if it is
						int step_forward_index=i+1;
						if(formula.charAt(step_forward_index)>='0' && formula.charAt(step_forward_index)<='9')
						{
							while( step_forward_index<formula.length() && formula.charAt(step_forward_index)>='0' && formula.charAt(step_forward_index)<='9')
								step_forward_index++;
						
							int multiplier=Integer.parseInt(formula.substring(i+1, step_forward_index));
						
							for(int j=1; j<multiplier; j++)
								weight=StringAddition.addStrings(weight, weight);
						}
					//part 2: adding the weight of the group between '(' and ')' to the m_weight
						this.addM_Weight(weight);
					
						return step_forward_index;
					}
					case '2':						//multiplier is found i.e. '3' in "NH3"; '2' or '4' in Na2SO4
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
					{
					//part 1: finding element name preceding the integer number 
						
						String ele_name="";
						int step_back_index=i-1;
						
						while(formula.charAt(step_back_index)>='a' && formula.charAt(step_back_index)<='z')					//finding element name
							step_back_index--;
						
						System.out.println("back:"+step_back_index+"- i:"+i);
						if (step_back_index!=(i-1))
							ele_name=formula.substring(step_back_index, i);
						else ele_name=Character.toString(formula.charAt(step_back_index));
						System.out.println( "element to search : "+ele_name);
						
					//part 2: finding whole multiplier number(in case of polymer it can be >9)
						
						int multiplier;
						if( (i+1)<formula.length())
						{
							int step_forwrd_index=i+1;
						
							while( step_forwrd_index<formula.length() && formula.charAt(step_forwrd_index)>='0' && formula.charAt(step_forwrd_index)<='9' )
								step_forwrd_index++;
						
							multiplier=Integer.parseInt(formula.substring(i,step_forwrd_index));
							i=step_forwrd_index-1;
						}
						else multiplier=Integer.parseInt(formula.substring(i,i+1));
						
					//part 3: adding mass multiplier times
						
						String ele_mass=atomic_table.searchTree(ele_name).getMass();
						System.out.println("mult : "+multiplier);
						for(int j=1; j<multiplier; j++)
							{
							System.out.println("Wegt : "+weight+"-  "+"ele-mass : "+ele_mass+"-");
							weight=StringAddition.addStrings(weight, ele_mass);
							
							}

//TODO : implement multiplication method for long number strings as replacement of for loop
		
						break;
					}
				default :
					System.out.println(" error : loop index i : "+i+"  currentChar : "+currentChar);
					
			}
		}
		this.addM_Weight(weight);
		return 0;
	}
}