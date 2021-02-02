package demo.zookeeper;

import org.apache.zookeeper.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author zhangpeng
 * @description
 * @date 2020-08-20 9:21 下午
 **/
public class Demo {

    private String zookeeperUrl = "192.168.243.130:2181";
    private Integer timeOut = 15000;

    private ZooKeeper zk;

    @BeforeAll
    public void test001() throws IOException {
        zk= new ZooKeeper(zookeeperUrl, timeOut, event -> {
            Watcher.Event.EventType et = event.getType();
            System.out.println(et);
        });

    }

    @Test
    public void test002() throws IOException, KeeperException, InterruptedException {

        String path = zk.create("/api","javatest".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(path);
    }

    @Test
    public void Test003() throws KeeperException, InterruptedException {

        String path = zk.create("/api","javaTest".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);

//        zk.addWatch(path, AddWatchMode.PERSISTENT);
    }
}
