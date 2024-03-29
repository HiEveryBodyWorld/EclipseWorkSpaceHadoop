package zookeeper;

import java.util.Random;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.EventType;

public class TankMaster {

	static String status= "ACTIVE";
	
	
	public static void main(String[] args) throws Exception {
		String CONN="192.168.31:2181,192.168.3.32:2181,192.168.3.21:2181";
		ZooKeeper zk = new ZooKeeper(CONN,5000,null);//5000session timeout
		String IP="192.168.3.24";
		String port=new Random().nextInt(500)+"";
		System.out.println(port);

		if(zk.exists("/tank/master", new MasterWatcher())!=null){//节点已经被创建
			status = "STANDBY";
		}else{
			zk.create("/tank/master", (IP+":"+port).getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
			status = "ACTIVE";
			System.out.println("启动就是active");
		}
		Thread.sleep(Integer.MAX_VALUE);
	}
	
	static class MasterWatcher implements Watcher{

		public void process(WatchedEvent e) {
			if(e.getType() == EventType.NodeDeleted){
				status = "ACTIVE";
				System.out.println("切换为active");
			}
			
		}
		
	}
}
