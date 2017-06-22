
public class BSTofAtom {

	private AtomR root=null;
	
	public int addNode(AtomR newNode){
		int errorFlag=0;
		if(root==null){
			root=newNode;
	//		System.out.println("root node : "+newNode.getName());
		}
		else
		{
			AtomR temp=root;
			AtomR track=null;
			char flag=' ';
			while(temp!=null)
			{
				track=temp;
	//			System.out.print(" -> "+temp.getName());
				if(temp.getName().compareToIgnoreCase(newNode.getName())<0)
				{
					temp=temp.getRight();
					flag='r';
					continue;
				}
				else if(temp.getName().compareTo(newNode.getName())>0)
				{
					temp=temp.getLeft();
					flag='l';
					continue;
				}
				else
				{
					System.out.println("comparision error : "+"temp-name -> "+temp.getName()+"new-name -> "+newNode.getName());
					break;
				}
			}
			
			if(flag=='r')
				track.setRight(newNode);
			else if(flag=='l')
				track.setLeft(newNode);
			else 
			{
				System.out.println("error: track-node -> "+track.getName());
				errorFlag=1;
				return errorFlag;
			}
	//		System.out.println();
	//		System.out.println("node added : "+newNode.getName());
			
		}
		return errorFlag;
	}

	public AtomR searchTree(String nam){
		AtomR temp=root;
		AtomR track= null;
		while(temp!=null)
		{
			track=temp;
			if(temp.getName().compareToIgnoreCase(nam)<0)	//temp is lexicographically smaller than nam
			{
				temp=temp.getRight();
			}
			else if(temp.getName().compareToIgnoreCase(nam)>0)	//temp is lexicographically bigger than nam
			{
				temp=temp.getLeft();
			}
			else if(temp.getName().compareToIgnoreCase(nam)==0)
			{
	//			System.out.println("element found !");
				return temp;
			}
		}
		System.out.println("error : no such element !");
		return null;
	}
}

