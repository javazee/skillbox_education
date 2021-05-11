import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Поток " + Thread.currentThread().getName() + " запущен");
        String srcFolder = "D:/Winfolders/Desktop/src";
        String dstFolder = "D:/Winfolders/Desktop/dst";

        int cores = Runtime.getRuntime().availableProcessors();
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        assert files != null;
        for (File[] fileArray: splitArrayIntoEqualParts (files, cores)){
            new Thread(new FileCopier(fileArray, dstFolder, 640, "jpg")).start();
        }
    }

    static List<File[]> splitArrayIntoEqualParts(File[] files, int cores) {
        int from = 0;
        int arraySize = (int) Math.ceil(files.length/cores);
        int to = arraySize;
        List<File[]> arrayList = new ArrayList<>();
        for (int i = 1; i <= cores; i++) {
            arrayList.add(Arrays.copyOfRange(files, from, to));
            if (cores - i == 0) break;
            from = to;
            arraySize = (int) Math.ceil((files.length - to)/(cores - i));
            to = from + arraySize;
        }
        return arrayList;
    }
}
