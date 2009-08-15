package Handler;
import java.util.ArrayList;
import java.util.Hashtable;
//import java.util.Enumeration;

public class HandleFlow {

	static ArrayList<GraphNode> graphList = new ArrayList<GraphNode>();
	
	static ArrayList<String> functionsList = new ArrayList<String>();
	
	static ArrayList<ParentFunction> parentFunctionList = new ArrayList<ParentFunction>();
	
	public static String currentParentFunction="";
	
	
	public static  synchronized void insertNode(String nodeName,String action)
	{
	     if(action.equals("function")){
			graphList.add(new GraphNode(nodeName));
			//functionsList.add(nodeName);
	      }
	      else if(action.equals("parent"))
	      {
	    	  graphList.add(new GraphNode(nodeName));
				ParentFunction temp  = new ParentFunction(nodeName);
				//System.out.println("functionList count = " + functionsList.size());						
				
				parentFunctionList.add(temp); 
	      }
	      else if(action.equals("parentdef"))
	      {
	    	  return;
	      }
		functionsList.add(nodeName);
	}	
	
	public static void insertParentNode(String nodeName)
	{	
			
			//functionsList.add(nodeName);
		
	}	
	public static void printFlow()
	{
		String temp ="";
		for(int i=functionsList.size()-1;i>=0;i--)
		{
			temp=functionsList.get(i);
			if(isParent(temp))
				{
				 System.out.println("\n Predicate Logic for " + temp.replace("#", ""));
				 currentParentFunction = temp.replace("#", "");
				}
			else if(temp.contains("ifstmt"))
				System.out.print(temp.replace("ifstmt", "") + "  ->  (");
			else
				{
				//if(!temp.equals(currentParentFunction))	
			//	if(isParent(temp+"#"))
				   System.out.println(temp + "  ^  ");
				}
			
		}
		
	}
	public static void printFlow1()
	{
		System.out.println("ParentFunctionList.size = " + parentFunctionList.size());
		for(int i=0;i<parentFunctionList.size();i++)
			{
			 ParentFunction temp = parentFunctionList.get(i);
			  System.out.println("Function Name :" +temp.functionName);
			  for(int j=0;j<temp.innerFunctions.size();j++)
				  System.out.println(" ^ " + temp.innerFunctions.get(j));
			}
	}	
	public static void insideIf()
	{
		insertNode(")","function");
	}
	static int functionListCount =0;
	
	public static String getNextString()
	{
		if(functionsList.get(functionListCount)==null)
			return null;
		else return functionsList.get(functionListCount++);
	}
	public static boolean isParent(String str)
	{
		
		for(int i=0;i<parentFunctionList.size();i++)
			if(str.equals(parentFunctionList.get(i).functionName ))
				return true;
		return false;
	}
}

