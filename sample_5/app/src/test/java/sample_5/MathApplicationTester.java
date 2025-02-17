package sample_5;

import sample_5.MathApplication;
import sample_5.CalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;


@ExtendWith(MockitoExtension.class)
public class MathApplicationTester {
	
   MathApplication mathApplication = new MathApplication();
   @Mock CalculatorService mCalculatorService;

   @Test
   public void testAdd(){
      //add the behavior of calc service to add two numbers
      when(mCalculatorService.add(10.0,20.0)).thenReturn(30.00);
		
      //test the add functionality
      assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
       
      //verify the behavior
      verify(mCalculatorService).add(10.0, 20.0);
   }
}