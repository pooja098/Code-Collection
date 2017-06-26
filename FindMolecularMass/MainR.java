
//long time= System.currentTimeMillis() --- this gives current time in milliseconds  

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class MainR {

	public static void main(String[] args) throws IOException{
		long start= System.currentTimeMillis();			//this gives current time in milliseconds  

		Scanner sc1=new Scanner(new File("/home/pooja/dataFiles for java programs/atomicdata.txt"));
		BSTofAtom bst=new BSTofAtom();
		//int flag=0;
		while(sc1.hasNextLine())
		{			
	//		System.out.print(flag++);
			String data=sc1.nextLine();
			
			AtomR atom=new AtomR(data);
			
			bst.addNode(atom);
	//		System.out.println("nod added : "+atom.getName()+ "   "+atom.getMass());
		}
		
		sc1.close();
		
	/*
		AtomR check= bst.searchTree("H");
		if(check!=null)
			System.out.println(check.getName());
		while(check.getRight()!=null){		//testing of the searchTree method
			System.out.println("search : "+check.getRight().getName());
			check=bst.searchTree(check.getRight().getName());
			System.out.println("found : "+check.getName());
		}
	*/
		MoleculeR.setBST(bst);
	
	/*	MoleculeR h2o=new MoleculeR("H2O20");
		System.out.println( "mass of H2O20 : "+h2o.getM_Weight());
	*/
		Scanner sc2=new Scanner(System.in);
		String input="";
		System.out.println("Welocme to FindMolecularWieght Program !");
		System.out.println("Enter 'exit' when you want to terminate th e program");
		while(true)
		{
			System.out.println();
			System.out.println("-> Enter the formula of the molecule :");
			input=sc2.nextLine();
			if(input.equals("exit"))
				break;
			MoleculeR molecule=new MoleculeR(input);
			System.out.println("Mass of "+input+" is "+molecule.getM_Weight()+"--");
		}
		sc2.close();
		System.out.println("Running time : "+(System.currentTimeMillis()-start));
	}
}
