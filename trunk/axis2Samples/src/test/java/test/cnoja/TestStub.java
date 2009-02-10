/**
 * Title：TestStub.java
 * Description：axis2Samples
 * Copyright：Copyright (c)2009 Sobey,Inc
 * Company：Sobey,Inc
 * @author Zheng.Won &lt;<a href="mailto:hbyw618@hotmail.com">hbyw618@hotmail.com</a>&gt; 2009-2-10 下午03:06:59
 * @version 0.9 beta
 */
package test.cnoja;

import java.rmi.RemoteException;

import junit.framework.TestCase;

import org.apache.axis2.AxisFault;

import sample.axisversion.ExceptionException0;
import sample.axisversion.GetVersionResponse;
import sample.axisversion.VersionCallbackHandler;
import sample.axisversion.VersionStub;

/**
 *
 *
 *
 *
 **/
public class TestStub extends TestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void testStub() {
		try {
			VersionStub stub = new VersionStub();
			GetVersionResponse version = stub.getVersion();
			assertNotNull(version.get_return());
			stub.startgetVersion(new VersionCallbackHandler() {
				@Override
				public void receiveResultgetVersion(GetVersionResponse result) {
					assertNotNull(result.get_return());
				}
			});
		} catch (AxisFault e) {
			fail(e.toString());
		} catch (ExceptionException0 e1) {

			e1.printStackTrace();
			fail();
		} catch (RemoteException e2) {
			e2.printStackTrace();
			fail();
		}

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

}
