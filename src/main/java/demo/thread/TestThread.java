package demo.thread;

import java.util.List;

public class TestThread extends Thread {

    private List<String> strs;

    public TestThread(List<String> strs) {
        this.strs = strs;
    }

    @Override
    public void run() {
        if(strs != null && strs.size() != 0){
            for(String s:strs){
                System.out.println(super.getName()+":"+s);
            }
        }
    }
}
