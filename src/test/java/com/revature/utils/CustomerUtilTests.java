package com.revature.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerUtilTests {

	public static CustomerUtil customerUtil;
	public static int i;
	public static int j;
	public static int k;
	public static int result;

	@BeforeAll
	public static void setCustomerUtil() {
		System.out.println("In Before All");
		customerUtil = new CustomerUtil();

	}

	@BeforeEach
	public void setInts() {
		System.out.println("in before each");
		i = 7;
		j = 5;
		k = 0;
	}

	@AfterEach
	public void clearResult() {
		System.out.println("In After Each");
		result = 0;
	}

	@AfterAll
	public void clearCustomerUtil() {
		System.out.println("In after all");
		customerUtil = null;
	}

	@Test
	public void testAdd() {
		System.out.println("Testing add");
		result = customerUtil.add(i, j);
		assertEquals(result, 12);
	}

}
