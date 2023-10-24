package SBV_utility;

import org.junit.Assert;

public class ExceptionHandling {

	public static void HandleExecption(Exception e, String sError) throws Exception{
		try {
		Logs.error(sError);
		Assert.fail();
		}catch(Exception e1) {
			e1.printStackTrace();
			Assert.fail(sError);
		}
	}
	public static void HandleAssertion(String sError) {
		try {
			Logs.error(sError);
			Assert.fail(sError);
		}catch(Exception e) {
			Assert.fail(sError);
		}
	}
}
