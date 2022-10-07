import java.time.LocalDateTime;
import java.util.Arrays;

public class ValueCalculator {

    float[] arr;
    int lenArr;
    int halfLenArr;

    public ValueCalculator(int inlenArr) {
        this.lenArr = Math.max(inlenArr, 1000000);
        this.halfLenArr = this.lenArr / 2;
        this.arr = new float[lenArr];
    }

    public void doCalc(){
        long starttime = System.currentTimeMillis();
        System.out.println(LocalDateTime.now() + ": " + starttime);
        float[] arr1;
        float[] arr2;

        for (int i=0;i<lenArr;i++){
            arr[i] = 1;
        }

        System.out.println("Довжина першого масиву " + arr.length);
        arr1 = Arrays.copyOfRange(arr, 0, halfLenArr );
        System.out.println("Довжина першого масиву " + arr1.length);
        arr2 = Arrays.copyOfRange(arr, halfLenArr, lenArr);
        System.out.println("Довжина першого масиву " + arr2.length);

        ThreadRunnable threadRunnable1 = new ThreadRunnable(arr1);
        ThreadRunnable threadRunnable2 = new ThreadRunnable(arr2);

        Thread thread1 = new Thread(threadRunnable1);
        Thread thread2 = new Thread(threadRunnable2);

        thread1.start();
        thread2.start();

//        printArr(arr);
//        printArr(arr1);
//        printArr(arr2);

        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);

        long endtime = System.currentTimeMillis();

//        printArr(arr);

        System.out.println(LocalDateTime.now() + ": " + endtime);

        System.out.println(LocalDateTime.now() + ": " + "Час виконання " + (endtime - starttime) + " мілісекунд");
    }

    public void printArr (float[] arr){
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("}");
    }
}
