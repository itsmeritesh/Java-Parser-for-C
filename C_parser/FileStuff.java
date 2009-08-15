import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.Ostermiller.util.StringTokenizer;


public class FileStuff {

	static BufferedReader bufferedReaderObject;
	static String lastRead="",inputProgram ="",tobefiltered;
	static String fileName = "E:/First_Semester/MFC/parser/jlex/2input3.c";
	static StringTokenizer st;
	static boolean commentFlag = false;
	static boolean debugMode = true;
	
	public static void readFile()
	{
		String data="";
		try
		{			
			bufferedReaderObject = new BufferedReader(new FileReader(fileName));

			while((data = bufferedReaderObject.readLine()) != null) {
				//myParserObject.decideParse(data);
               // System.out.println("message received"+data);
				
				if(data.contains("(")||data.contains(")")||data.contains("{")||data.contains("}") 
						||data.contains("do") || data.contains("while") || data.contains("break")
						|| data.contains("if")|| data.contains("else") || data.contains("switch")
						|| data.contains("case")|| data.contains("break")||data.contains("/*")
						|| data.contains("*/"))
				{ 
					inputProgram += data;
					System.out.println(data);
				}
			}		
			
			st = new StringTokenizer(inputProgram, " \t\n\r\f", "=#<>{}()+;*");			 

		} 
		catch (Exception e)
		{
			System.out.println("Exception in InitClass.readFileLine : " + e.getMessage());
		}
	}
	
	public static String getToken()
	{
		if(st.hasMoreTokens())
		{
			String str = st.nextToken();
			if(FileStuff.debugMode) System.out.println("token : "+str);
			return str;
		}
		else {
			myscanner.eofFlag = true ;
			return " ";
		}
	}
	  
}

