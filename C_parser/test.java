import java_cup.runtime.*;
import Handler.*;
public class test{

 public static void main(String str[]) {
	 
	  //read from the file
	  FileStuff.readFile();
	  
	  myscanner myScannerObject = new myscanner();
	  parser parser_obj = new parser(myScannerObject);

      /* open input files, etc. here */
      Symbol parse_tree = null;

      try {
        if (FileStuff.debugMode)
          parse_tree = parser_obj.debug_parse();
        else
          parse_tree = parser_obj.parse();
      } catch (Exception e) {
        /* do cleanup here - - possibly rethrow e */
      } finally {
	/* do close out here */
      }
      Handler.HandleFlow.printFlow();
      
 }
}