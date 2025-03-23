package com.nt.advice;

public class PoliticianNotFoundException extends RuntimeException

{
   public PoliticianNotFoundException()
   {
	   super();
   }
   public PoliticianNotFoundException(String msg)
   {
	   super(msg);
   }
}
