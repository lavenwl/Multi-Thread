package basic.productconsumer.synchornized;

import java.util.List;

public class Productor implements Runnable{
    String name;
    List<String> list;

    public Productor(String name, List<String> list) {
        this.name = name;
        this.list = list;
    }

    @Override
    public void run() {
        while(true) {
            list.add("这是第" + 1 + "个产品");
        }
    }
}
