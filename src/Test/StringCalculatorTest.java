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
public void test_two_number(){
	Assert.assertEquals(3, StringCalculator.Add("1,2"));
	}
}
