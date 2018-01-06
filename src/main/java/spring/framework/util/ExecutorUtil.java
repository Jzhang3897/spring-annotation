package spring.framework.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhangjun on 2018/1/6.
 */
public class ExecutorUtil {

    private static ExecutorService executorService = Executors.newFixedThreadPool(16);

    public static <T> Future<T> submit(Callable<T> task) {
        return executorService.submit(task);
    }

    public static void execute(Runnable command) {
        executorService.execute(command);
    }

    public static void shutdown() {
        executorService.shutdown();
    }
}
