package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoliticalPartyOperationControllerAdvice 
{
	@ExceptionHandler(Exception.class)
     public ResponseEntity<String>handleAllException(Exception e)
     {
		System.out.println("PoliticalPartyOperationControllerAdvice.handleAllException()");
    	 return new  ResponseEntity<String>("unknown internal error::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
     }
	
 	@ExceptionHandler(PoliticianNotFoundException.class)
    public ResponseEntity<String>handlePNFE(PoliticianNotFoundException pnfe)
    {
	System.out.println("PoliticalPartyOperationControllerAdvice.handlePNFE()");
   	 return new  ResponseEntity<String>("unknown internal error::"+pnfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
