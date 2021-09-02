package god_bless_me;

import java.util.*;

public class Main {
	
	
	public static List mapToList(Map inputMap) {
		
		List newList=new ArrayList();
		Iterator it = inputMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        
	     
		        newList.add(pair.getValue());
	        
	        it.remove(); // avoids a ConcurrentModificationException

	    }
	    return newList;
		
		
		
	}
	
	
	public static List removeRedundant(List inputList) {
		
		 Set set = new LinkedHashSet<>(inputList);
		  
	        // create a list and copy all value of set
	        List returningList = new ArrayList<>(set);
	        return returningList;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		List nodeList=new ArrayList();
		
		System.out.println("Waheguru Ji Ka Khalsa Waheguru Ji Ki Fateh..!!");
		// get Inputs
		System.out.println("Enter total number of nodes");
		int totalNodes=scan.nextInt();
		
//		System.out.println("Enter total number of time frames");
//		
//		int totalTimeFrames=scan.nextInt();
		
		
		//List nodeListBeforeDisruption=new ArrayList();
		
		
		// create node objects
		
		for(int i=0;i<totalNodes;i++) {
			String name="node_"+i;
			Node newNode = new Node();
			newNode.name=name;
			nodeList.add(newNode);
		}
		
		//print newly created objects of Node class
		for(int i=0;i<nodeList.size();i++) {
			System.out.println(((Node)nodeList.get(i)).name);
			// get list of components primary node needs.
			
			System.out.println("Enter total components that are inputs for "+((Node)nodeList.get(i)).name);
			
			int inputCount=scan.nextInt();
			
			
			for(int j=0;j<inputCount;j++) {
				System.out.println("Enter the input component "+(j+1)+" (number)");
				int comp=scan.nextInt();
				((Node)nodeList.get(i)).inputComponents.add(comp);
				
				System.out.println("Enter obligated input quantity for component "+comp);
				float compUnit=scan.nextFloat();
				((Node)nodeList.get(i)).obligatedInputUnits.put(comp, compUnit);
				
				System.out.println("enter the input node or source node number for component "+comp);
				int inputNode=scan.nextInt();
				((Node)nodeList.get(i)).inputNodes.put(comp, inputNode);
						
			}
			
			
			
			
			
			
			System.out.println("Enter total components that are outputs for "+((Node)nodeList.get(i)).name);
			
			int outputCount=scan.nextInt();
			
			
			for(int j=0;j<outputCount;j++) {
				System.out.println("Enter the output component "+(j+1)+" (number)");
				int comp=scan.nextInt();
				((Node)nodeList.get(i)).outputComponents.add(comp);
				
				System.out.println("Enter obligated output quantity for component "+comp);
				float compUnit=scan.nextFloat();
				((Node)nodeList.get(i)).obligatedOutputUnits.put(comp, compUnit);
				
				System.out.println("enter the output node or consumer node number for component "+comp);
				int outputNode=scan.nextInt();
				((Node)nodeList.get(i)).outputNodes.put(comp, outputNode);
				
				System.out.println("enter the current output units for component "+comp);
				float currentOutput=scan.nextFloat();
				
				((Node)nodeList.get(i)).currentOutputUnits.put(comp, currentOutput);
					
				
				
				// calculate fulfillment rate.
				
				// fulfillment rate is percentage of orders meeting its obligation
				
				float fulfillmentValue= (currentOutput/compUnit)*100;
				
				((Node)nodeList.get(i)).fullfilmentRate.put(comp, fulfillmentValue);
				
				List tempList=new ArrayList();
				tempList.add(fulfillmentValue);
				((Node)nodeList.get(i)).outputFlList.put(comp, tempList);
				
			}
	
			
			//System.out.println(((Node)nodeList.get(i)).inputComponents);
			
			
			//nodeListBeforeDisruption.add(nodeList.get(i));
			
			}
		
		
		List nodeListBeforeDisruption = new ArrayList();
		//nodeListBeforeDisruption.addAll(nodeList);


		for(int gb=0;gb<nodeList.size();gb++) {
			
			
			nodeListBeforeDisruption.add(new Node((Node)nodeList.get(gb)));
		
		}
		
		
		
		//Map fulfilmentRateBeforeDisruption= 
		
		
		//impact the percentage decrease of output of nodes for some time frame and with some rate of recovery
		
		System.out.println("Enter the node number to be impacted");
		int impactedNodeIndex=scan.nextInt();
		
//		System.out.println("The node "+impactedNodeIndex+" has following output components: ");
//		System.out.println("Output components: "+((Node)nodeList.get(impactedNodeIndex)).outputComponents);
//		
//		System.out.println("Enter the output component to be impacted: ");
//		int impactedComponent= scan.nextInt();
//		
		
		System.out.println("Enter the percentage reduction in the output of node "+impactedNodeIndex);
		int impactedPercentage=scan.nextInt();
		
		
		
//		int newCurrentOutput=(int) ((Node)nodeList.get(impactedNodeIndex)).currentOutputUnits.get(impactedComponent);
//		
//		newCurrentOutput=newCurrentOutput-((newCurrentOutput*impactedPercentage)/100);
//		
//		((Node)nodeList.get(impactedNodeIndex)).currentOutputUnits.put(impactedComponent,newCurrentOutput);
		
		
		//calculate needed time frames with respect to rate of recovery
		System.out.println("Enter percentage rate of recovery");
		int rateOfRecovery=scan.nextInt();
		//int timeFramesNeeded=(int) Math.ceil(100/rateOfRecovery);
		
		int timeFramesNeeded=6;
		System.out.println("Total time frames needed for recovery are: "+timeFramesNeeded);
		
		
	
		
		
		
		
		// identify impacted nodes.
		//create a list of impacted nodes
		
		
		System.out.println("outputn nodes for node 0 are: "+((Node)nodeList.get(0)).outputNodes);
		
		System.out.println("creating list of indexes of impacted nodes");
		
		
		
		
		
//		List impactedNodeList=(List) ((Node)nodeList.get(impactedNodeIndex)).outputNodes.get(impactedComponent);
		
		// create a fundtion that takes a map and returns a list of its values
		
		
		
		
		List impactedNodeList=mapToList(((Node)nodeList.get(impactedNodeIndex)).outputNodes);
		impactedNodeList=removeRedundant(impactedNodeList);
		
		
		boolean isAdded=true;
		
		System.out.println("imapcted node list before loop is = "+impactedNodeList);
		
		System.out.println("current output before entering loop for node 0 is "+((Node)nodeList.get(0)).currentOutputUnits);
		
		
		while(isAdded) {
			isAdded=false;
			for(int mp=0;mp<impactedNodeList.size();mp++) {
				
				
				
				List tempList=mapToList(((Node)nodeList.get((int) impactedNodeList.get(mp))).outputNodes);
				
				//System.out.println("current impacted node = "+impactedNodeList.get(mp));

//				System.out.println("its output nodes are "+ tempList);
				
				
				for(int kk=0;kk<tempList.size();kk++) {
					
					
					if(!(impactedNodeList.contains(tempList.get(kk)))) {
					
						impactedNodeList.add(tempList.get(kk));
						isAdded=true;				
						
					}
					
					
				}
				
			}
		}
		
		
		
		System.out.println("impacted nodes are: "+impactedNodeList);
		

		System.out.println("current output after creating impacted node list for node 0 is "+((Node)nodeList.get(0)).currentOutputUnits);


		//update the output of impacted nodes

		
		
		for(int pk=0;pk<impactedNodeList.size();pk++) {
			
			
			//node to be worked upon is below
			//(Node)nodeList.get((int)impactedNodeList.get(0));
			
			
			 Iterator it = ((Node)nodeList.get((int)impactedNodeList.get(pk))).currentOutputUnits.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			      //  System.out.println(pair.getKey() + " = " + pair.getValue());
			        
			        
			        float tempCurrentOutput=(float) pair.getValue();
			      tempCurrentOutput=tempCurrentOutput-((tempCurrentOutput*impactedPercentage)/100);

			      ((Node)nodeList.get((int)impactedNodeList.get(pk))).currentOutputUnits.put(pair.getKey(), tempCurrentOutput);	
			//        it.remove(); // avoids a ConcurrentModificationException
			    }
			
			
			System.out.println("for impacted node "+impactedNodeList.get(pk));
			System.out.println("impactedPercentage = "+impactedPercentage);
			
			  System.out.println("before disruption");
			    System.out.println(((Node)nodeListBeforeDisruption.get((int)impactedNodeList.get(pk))).currentOutputUnits+"\n\n");
			    System.out.println("after disruption");
			    System.out.println(((Node)nodeList.get((int)impactedNodeList.get(pk))).currentOutputUnits+"\n\n");
			
		}
		
		
		
		//recalculate fulfillment rate of all nodes
		
		for(int dd=0;dd<nodeList.size();dd++) {
			
			Node tempNode=(Node)nodeList.get(dd);
			
			
			 Iterator it = (tempNode.currentOutputUnits).entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        //System.out.println(pair.getKey() + " = " + pair.getValue());
			        
			        float fullfillmentRate=((float)((Node)nodeList.get(dd)).currentOutputUnits.get(pair.getKey()) )/((float)((Node)nodeList.get(dd)).obligatedOutputUnits.get(pair.getKey()) );
			        fullfillmentRate=fullfillmentRate*100;
			        
			        
			        ((Node)nodeList.get(dd)).fullfilmentRate.put(pair.getKey(),fullfillmentRate);
			        
			        
			        ((List)((Node)nodeList.get(dd)).outputFlList.get(pair.getKey())).add(fullfillmentRate);
			        
			        it.remove(); // avoids a ConcurrentModificationException
			    }
			
			    
			    
			    System.out.println("before disruption");
			    System.out.println(((Node)nodeListBeforeDisruption.get(dd)).fullfilmentRate+"\n\n");
			    System.out.println("after disruption");
			    System.out.println(((Node)nodeList.get(dd)).fullfilmentRate+"\n\n");
			
		}
		
		
		
		
		
		//List impactedNodeList=new ArrayList();
	
//		for(int i=0;i<nodeList.size();i++) {
//			
//			if(((int)((Node)nodeList.get(i)).inputNodes.get(impactedComponent))==impactedNodeIndex) {
//				//update the output of impacted nodes
//				
//				System.out.println("(Node)nodeList.get(i)).inputNodes = "+((Node)nodeList.get(i)).inputNodes);
//				System.out.println("impactedComponent = "+impactedComponent);
//				System.out.println("(Node)nodeList.get(i)).inputNodes.get(impactedComponent)) "+((Node)nodeList.get(i)).inputNodes.get(impactedComponent));
//				System.out.println("impactedNodeIndex = "+impactedNodeIndex);
//				System.out.println("(Node)nodeList.get(i)).currentOutputUnits" + ((Node)nodeList.get(i)).currentOutputUnits);
//				
//				
//				
//				//int tempCurrentOutput=(int) ((Node)nodeList.get(i)).currentOutputUnits.get(impactedNodeIndex);
//				int tempCurrentOutput=(int) ((Node)nodeList.get(i)).currentOutputUnits.get(impactedComponent);
//				tempCurrentOutput=tempCurrentOutput-((tempCurrentOutput*impactedPercentage)/100);
//
//				
//				((Node)nodeList.get(i)).currentOutputUnits.put(impactedComponent,tempCurrentOutput);
//
//				//recalculate fulfillment rate.
//				
//				System.out.println("(Node)nodeList.get(i)).obligatedOutputUnits = "+((Node)nodeList.get(i)).obligatedOutputUnits);
//				System.out.println("impactedComponent = "+impactedComponent);
//			
//				
//				
//				int tempObligatedOutputUnits=(int)((Node)nodeList.get(i)).obligatedOutputUnits.get(impactedComponent);
//				int tempCurrentOutputUnits=(int)((Node)nodeList.get(i)).currentOutputUnits.get(impactedComponent);
//				float tempfulfillmentValue= (tempCurrentOutputUnits/tempObligatedOutputUnits)*100;
//				
//				((Node)nodeList.get(i)).fullfilmentRate.put(impactedComponent, tempfulfillmentValue);
//				
//			}	
//		}
//		
		
			// measure resilience of the individual nodes and hence final supply chain.
// nodeListBeforeDisruption
//		rateOfRecovery
//		timeFramesNeeded
		
		
		
		
		
		
			for(int i=0;i<nodeList.size();i++) {
				
				if(impactedNodeList.contains(i)) {
				
				Map newTempFlRate=((Node)nodeList.get(i)).fullfilmentRate;
				
				
				Iterator it = newTempFlRate.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        //System.out.println(pair.getKey() + " = " + pair.getValue());
			        
			        if(  ((Node)nodeListBeforeDisruption.get(i)).fullfilmentRate.get(pair.getKey())!= ((Node)nodeList.get(i)).fullfilmentRate.get(pair.getKey())   ) {
			        	float val=0;
			        	float previousVal=(float)((Node)nodeListBeforeDisruption.get(i)).fullfilmentRate.get(pair.getKey());
		        		float newVal=(float)((Node)nodeList.get(i)).fullfilmentRate.get(pair.getKey());

			        	for(int k=0;k<timeFramesNeeded;k++) {
			        		
			        		System.out.println("for node: "+((Node)nodeList.get(i)).name);
			        		//System.out.println("newVal in time frames are: "+newVal);
			        		//float rough=(float)newVal*((float)rateOfRecovery/100);
			        		
			        		
			        		
			        		// if new val <= previous value
			        		// check if alternate services are available in this time frame
			        		
			        		// if alternate service are available, generate units available
			        		// and add it to existing output units
			        		// recalculate recovery rate
			        		//find dependent nodes and update their fullfilment rate
			        		
			
			        		
			        		
			        		
			        		
			        		newVal=newVal+(newVal*((float)rateOfRecovery/100));
			        		
			        	
			        		
			        		//System.out.println("newVal*(rateOfRecovery/100 "+rough);
			        		
			        		
			        		//System.out.println("rateOfRecovery/100: "+rateOfRecovery/100);
			        		
					        ((List)((Node)nodeList.get(i)).outputFlList.get(pair.getKey())).add(newVal);

			        		
			        		val=val+ (previousVal-newVal);
			        		
			        	}
			        	val=val/(previousVal*timeFramesNeeded);
			        	
			        	float resilience= 1-val;
			        	
			        	((Node)nodeList.get(i)).resilience.put(pair.getKey(), resilience);
			        	
			        }
			        
			        it.remove(); // avoids a ConcurrentModificationException
			         
			    }
				
			}
				
			}
		
		int n=0;
		float sum=0;
			for(int i=0;i<nodeList.size();i++) {
				
				Map newTempresilience=((Node)nodeList.get(i)).resilience;
				
				
				System.out.println("Resilience for each component of node "+ ((Node)nodeList.get(i)).name+" is as follows:");
				
				System.out.println(((Node)nodeList.get(i)).resilience);
				
				Iterator it = newTempresilience.entrySet().iterator();
			   
				int count=0;
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry)it.next();
					float t= (float)((Node)nodeList.get(i)).resilience.get(pair.getKey());
					sum=sum+t;
					count++;
			    }
				n=n+count;
			}
			
			System.out.println("Resilience for complete supply chain is "+ (sum/n));
		
	
			
			//fullfillmentrate list is below.
			System.out.println("\n\n\n\n fullfillmentrate list is below.\n\n");
			for(int i=0;i<nodeList.size();i++) {
				
				Node tempNode=(Node)nodeList.get(i);
				
				System.out.println("for node : "+tempNode.name);
				System.out.println(tempNode.outputFlList);
				
			}
			
				
	}

}

