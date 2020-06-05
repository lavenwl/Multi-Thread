package basic.productconsumer.synchornized;

import java.util.List;

public class Consumer implements Runnable{

    List<String> list = null;

    @Override
    public void run() {

        synchronized (list) {


        }

    }
}
