
public class AtomR {

	private String name;
	private String mass;
	private AtomR left=null;
	private AtomR right=null;
	
	public AtomR(String data)
	{
		String[] tokens=data.split(" ");
		this.name=tokens[0];
		this.mass=tokens[1];
	}

	public String getName() {
		return name;
	}

	public String getMass() {
		return mass;
	}
	
	public AtomR getLeft() {
		return this.left;	
	}
	
	public AtomR getRight() {
		return this.right;	
	}

	public void setRight(AtomR newNode) {
		this.right=newNode;
	}
	
	public void setLeft(AtomR newNode) {
		this.left=newNode;
	}
}
