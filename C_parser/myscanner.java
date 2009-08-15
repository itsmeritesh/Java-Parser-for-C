// Simple Example Scanner Class

import java.util.ArrayList;
import java_cup.runtime.*;



public class myscanner implements Scanner {
  /* single lookahead character */
  protected static String next_char,token;
  public static String lastScanned ="";
  static boolean eofFlag = false ;
  static String[] dataTypesArray = {"int","float","double","char","void","enum"};
  static ArrayList<String> dataTypes= new ArrayList<String>();
  // since cup v11 we use SymbolFactories rather than Symbols
  private static SymbolFactory sf = new DefaultSymbolFactory();

  /* advance input by one character */
  protected static void advance()
    throws java.io.IOException
    {
	  next_char = FileStuff.getToken();
	  //new java_cup.runtime.Symbol sym;
	  
	 
       }

  /* initialize the scanner */
  public static void init()
    throws java.io.IOException
    {initialize();
	  advance(); }

  private static void initialize()
  {
	  for(int i=0;i< 5;i++)
		   dataTypes.add(dataTypesArray[i]);
	  
  }
  /* recognize and return the next complete token */
  public  Symbol next_token()
    throws java.io.IOException
    {
	  
      for (;;)
      {  
    	  //next_char = next_char.toLowerCase().trim();
    	  next_char = next_char.trim();
    	 // System.out.println(next_char);
    	  
    	  if(eofFlag) 
    	  {
    		  return sf.newSymbol("EOF",sym.EOF);
    	  }
    	  
    	  if(next_char.equals("(") )
    	  {  advance(); return sf.newSymbol("LEFTPARAN",sym.LEFTPARAN); }
    	  
    	  else if(next_char.equals(")") )
    	  {  advance(); return sf.newSymbol("RIGHTPARAN",sym.RIGHTPARAN); }
    	  
    	  else if(next_char.equals("{") )
    	  {  advance(); return sf.newSymbol("LEFTBRACE",sym.LEFTBRACE); }
    	  
    	  else if(next_char.equals("}") )
    	  {  advance(); return sf.newSymbol("RIGHTBRACE",sym.RIGHTBRACE); }
    	  
    	  else if(next_char.equals("while") )
    	  {  advance(); return sf.newSymbol("IF",sym.IF); }

    	  else if(next_char.equals("do") )
    	  {  advance(); return sf.newSymbol("DO",sym.DO); }

    	  else if(next_char.equals("for") )
    	  {  advance(); return sf.newSymbol("IF",sym.IF); }

    	  else if(next_char.equals(";") )
    	  {  advance(); return sf.newSymbol("SEMI",sym.SEMI); }

    	  else if(next_char.equals("if") )
    	  {  advance(); return sf.newSymbol("IF",sym.IF); }

    	  else if(next_char.equals("else") )
    	  {  advance(); return sf.newSymbol("ELSE",sym.ELSE); }

    	  else if(next_char.equals(",") )
    	  {  advance(); return sf.newSymbol("COMMA",sym.COMMA); }

    	  else if(dataTypes.contains(next_char) )
    	  {  advance(); return sf.newSymbol("RETURNTYPE",sym.RETURNTYPE); }

    	  else if(next_char.equals("typedef") ||next_char.equals("extern") ||next_char.equals("static") ||
    			  next_char.equals("auto") ||next_char.equals("register") )    			
    	  {  advance(); return sf.newSymbol("SPECIFIER",sym.SPECIFIER); }

    	  else if(next_char.equals("switch") )
    	  {  advance(); return sf.newSymbol("SWITCH",sym.SWITCH); }
    	  
    	  else if(next_char.equals("case") )
    	  {  advance(); return sf.newSymbol("CASE",sym.CASE); }
    	  
    	  else if(next_char.equals("break") )
    	  {  advance(); return sf.newSymbol("BREAK",sym.BREAK); }
    	  
    	  else if(next_char.equals("\\=") || next_char.equals("==") )    		  
    	  {  advance();
    	   System.out.println("riteshM");
    	  return sf.newSymbol("EQUALS",sym.EQUALS); }
    	  
    	  else if(next_char.equals(">"))    		  
    	  {  advance();
    	  return sf.newSymbol("GT",sym.GT); }
    	  
    	  else if(next_char.equals("<"))    		  
    	  {  advance();
    	  return sf.newSymbol("LT",sym.LT); }
    	    	  	  
    	  else if(next_char.equals("!"))    		  
    	  {  advance();
    	  return sf.newSymbol("EXCL",sym.EXCL); }
    	    	 
    	  
    	  
    	  else if(next_char.matches(".[a-zA-Z0-9_]+"))
    	  {  
    		//  String var=next_char;
    		  lastScanned = next_char;
    		  advance(); return sf.newSymbol(new String(lastScanned),sym.VARIABLE); }
    	  else  	  
    	  advance();
     	      /* in this simple scanner we just ignore everything else */
	      System.out.println("shouldnt be coming here");
	      //System.exit(0);
      }
    }
};

