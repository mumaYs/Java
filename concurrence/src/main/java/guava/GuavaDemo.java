package guava;


import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

/**
 * @author ys 2019/12/17 4:11 下午
 */
public class GuavaDemo {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("threadName").build();

        /**
         * SettableFuture:异步转同步的工具
         */
        SettableFuture<String> settableFuture = SettableFuture.create();

        ListenableFuture<String> future = MoreExecutors
                .listeningDecorator(
                        new ThreadPoolExecutor(1, 1, 0L,
                                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), threadFactory)
                )
                .submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return null;
                    }
                });

        try {
            System.out.println(settableFuture.get(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
