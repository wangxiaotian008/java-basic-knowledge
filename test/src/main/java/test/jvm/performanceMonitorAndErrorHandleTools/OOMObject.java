package test.jvm.performanceMonitorAndErrorHandleTools;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 * @author Administrator
 *
 */
public class OOMObject {

	public byte[] placeholder = new byte[64*1024];
	
	public static void main(String[] args) throws InterruptedException {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		for (int i = 0; i < 1000; i++) {
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		
		System.gc();
		
		Thread.sleep(3*60*1000);
	}
}
