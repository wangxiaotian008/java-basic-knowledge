package test.zookeeper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback.DataCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class BasicApiTest {

	public static void main(String[] args) {
		try {
			CountDownLatch countDownLatch = new CountDownLatch(1);
			ZooKeeper zooKeeper = new ZooKeeper(ZookeeperConnectionConst.ZOOKEEPER_URLS,
					ZookeeperConnectionConst.ZOOKEEPER_SESSION_TIMEOUT, new Watcher() {

						@Override
						public void process(WatchedEvent event) {
							
							System.out.println(event.toString());
							KeeperState state = event.getState();

							switch (state) {
							case AuthFailed:

								break;
							case ConnectedReadOnly:

								break;

							case Disconnected:

								break;
							case Expired:

								break;
							case NoSyncConnected:

								break;

							case SaslAuthenticated:

								break;

							case SyncConnected:

								System.out.println("SyncConnected....");
								countDownLatch.countDown();
								break;
							case Unknown:

								break;

							default:
								break;
							}
							
							
							EventType type = event.getType();

							switch (type) {
							case NodeChildrenChanged:

								break;
							case NodeCreated:

								break;
							case NodeDataChanged:

								break;
							case NodeDeleted:

								break;
							case None:

								break;

							default:
								break;
							}

						}
					});
			
			countDownLatch.await();
			System.out.println(zooKeeper.toString());
			String create = zooKeeper.create("/ooxx", "oldData".getBytes(Charset.forName("UTF-8")), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
			
			Stat stat = new Stat();
			byte[] data = zooKeeper.getData("/ooxx", new Watcher() {
				
				@Override
				public void process(WatchedEvent event) {
					EventType type = event.getType();

					switch (type) {
					case NodeChildrenChanged:

						break;
					case NodeCreated:

						System.out.println("node /ooxx created");
						break;
					case NodeDataChanged:
						System.out.println("node /ooxx changed");
						// 因为watcher只会watch一次，所以如果这个节点被改变好几次，就需要重新添加watch
						try {
							zooKeeper.getData("/ooxx",this,stat);
						} catch (KeeperException | InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case NodeDeleted:

						break;
					case None:

						break;

					default:
						break;
					}
					
				}
			}, stat);
			System.out.println("data=====>"+new String(data));
			System.out.println("stat====>" +stat +"version==" + stat.getVersion());
			Stat setData = zooKeeper.setData("/ooxx", "newData".getBytes(Charset.forName("UTF-8")), 0);
			
			String ctx = "contextdata";
			// 通过异步来获取结果
			System.out.println("Async call == >start");
			zooKeeper.getData("/ooxx", false, new DataCallback() {

				@Override
				public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
					// TODO Auto-generated method stub
					System.out.println("Async call == >" + new String(data));
					
				}
				
			}, ctx);
			System.out.println("Async call == >end");
			System.out.println("stat1====>" +setData +"version==" + setData.getVersion());
			Stat setData2 = zooKeeper.setData("/ooxx", "newData1".getBytes(Charset.forName("UTF-8")), setData.getVersion());
			System.out.println("stat2====>" +setData2 +"version==" + setData2.getVersion());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
