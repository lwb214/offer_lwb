package otherPractice.ManyThread;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

//创建多个线程对一个数组进行排序
//使用CountDownLatch来保证线程同步
public class MultiThreadSort {
    public static void main(String[] args) throws InterruptedException {

        //构建随机数组
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0,100);
        }
        System.out.println(Arrays.toString(arr));

        // 创建多个排序线程
        int threadCount = 4; // 假设使用4个线程
        CountDownLatch latch = new CountDownLatch(threadCount);
        //得到每个线程所要处理的块的大小
        int blockSize = (int) Math.ceil((double) arr.length / threadCount);
        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * blockSize;
            //防止下标越界
            int endIndex = Math.min((i + 1) * blockSize, arr.length);

            Thread thread = new Thread(() -> {
                Arrays.sort(arr, startIndex, endIndex);
                //让计数器减1
                latch.countDown();
            });

            thread.start();
        }

        // 等待所有线程执行完成
        latch.await();

        // 合并排序结果
        merge(arr, threadCount,blockSize);

        // 输出排序结果
        System.out.println(Arrays.toString(arr));
    }

    // 合并排序结果
    private static void merge(int[] arr, int threadCount,int blockSize) {
        int[] temp = new int[arr.length];
        //临时数组temp索引
        int index = 0;
        //存放每个子数组当前的索引位置
        int[] sonIndexes = new int[threadCount];

        while (index < arr.length) {
            //最小的索引
            int minIndex = -1;
            //当前所有块中的最小值【
            int minValue = Integer.MAX_VALUE;

            // 找到当前各个块中的最小值
            for (int i = 0; i < threadCount; i++) {
                int start = i * blockSize + sonIndexes[i];
                int end = Math.min((i + 1) * blockSize, arr.length);

                if (start < end && arr[start] < minValue) {
                    minValue = arr[start];
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                //将最小值赋值给临时数组
                temp[index] = minValue;
                //临时数组索引右移一位
                index++;
                //每个子数组的索引右移一位
                sonIndexes[minIndex]++;
            }
        }

        // 将合并结果复制回原数组
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }
}
