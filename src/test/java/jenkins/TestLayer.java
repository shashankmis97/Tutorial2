package jenkins;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLayer {
	
	@Test
	public void validateInteger() {
		System.out.println("Validating Integer");
		Assert.assertEquals(2, 2);
	}
	@Test
	public void validateBoolean() {
		System.out.println("Validating Boolean");
		Assert.assertTrue(true);
	}
}
