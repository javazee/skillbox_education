import java.io.File;

public class FileUtils {
    private static long size = 0;

    public static long calculateFolderSize(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File files : file.listFiles()) {
                    if (files.isDirectory()) {
                        calculateFolderSize(files.getAbsolutePath());
                    } else if (files.isFile()) {
                        size = size + files.length();
                    }
                }
                return size;
            } else return file.length();
        } else {
            throw new IllegalArgumentException("Папка или файл по указанному пути не существует");
        }
    }
}
