package zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class ZKClient {

	public static void main(String[] args) throws Exception {
		String CONN="192.168.31:2181,192.168.3.32:2181,192.168.3.21:2181";
		ZooKeeper zk = new ZooKeeper(CONN,5000,null);//5000session timeout
		Thread.sleep(3000);
		zk.create("/yxxy", "yxxy".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		Thread.sleep(2000);
		zk.close();
	}
}
