package Test;
import StringCalc.StringCalculator;
import static org.junit.Assert.*;
import  edu.princeton.cs.introcs.*;
import  edu.princeton.cs.algs4.*;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
@Test
	public void test_empty_string(){
		
		Assert.assertEquals(0, StringCalculator.Add(""));
	}
@Test
	public void test_one_number(){
		Assert.assertEquals(1, StringCalculator.Add("1"));
	}
@Test
public void test_two_numbers(){
	Assert.assertEquals(3, StringCalculator.Add("1,2"));
	}
@Test 
public void test_many_numbers(){
	Assert.assertEquals(55, StringCalculator.Add("1,2,3,4,5,6,7,8,9,10"));
	}
@Test 
public void test_many_numbers_with_newline(){
	Assert.assertEquals(55, StringCalculator.Add("1,2,3\n4,5,6\n7,8,9,10"));
	}
@Test
public void test_many_numbers_only_with_newline(){
	Assert.assertEquals(55, StringCalculator.Add("1\n2\n3\n4\n5\n6\n7\n8\n9\n10"));
	}
}