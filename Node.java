package god_bless_me;

import java.util.*;

public class Node implements Cloneable {

	String name;
	List inputComponents = new ArrayList();
	Map obligatedInputUnits= new HashMap();
	List outputComponents = new ArrayList();
	// below map is
	//for storing the integer value of obligated output wrt output component (Key)
	Map obligatedOutputUnits= new HashMap();
	
	Map currentOutputUnits= new HashMap();
	Map inputNodes=new HashMap();// key is input components and value is node number.
	Map outputNodes=new HashMap();// key is output components and value is node number.
	Map fullfilmentRate= new HashMap();// key is input components and value is fulfilment rate.
	
	Map resilience = new HashMap();// key is component and value is its resilience
	
	Map outputFlList = new HashMap();// key is component name and value is list of fulfilment value, the index of list represents time starting from 0
	
	
	public Node(Node temp) {
		this.currentOutputUnits = new HashMap(temp.currentOutputUnits);
	
	
	
		this.inputComponents = new ArrayList(temp.inputComponents);
		this.obligatedInputUnits= new HashMap(temp.obligatedInputUnits);
		this.outputComponents = new ArrayList(temp.outputComponents);
		// below map is
		//for storing the integer value of obligated output wrt output component (Key)
		this.obligatedOutputUnits= new HashMap(temp.obligatedOutputUnits);
		
		this.inputNodes=new HashMap(temp.inputNodes);// key is input components and value is node number.
		this.outputNodes=new HashMap(temp.outputNodes);// key is output components and value is node number.
		this.fullfilmentRate= new HashMap(temp.fullfilmentRate);// key is input components and value is fulfilment rate.
		
		this.resilience = new HashMap(temp.resilience);// key is component and value is its resilienc
	
	
	
	
	
	
	}
	
	public Node(Map currentOutputUnits) {
		super();
		this.currentOutputUnits = currentOutputUnits;
	}





	
	
	
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
	
	
}
