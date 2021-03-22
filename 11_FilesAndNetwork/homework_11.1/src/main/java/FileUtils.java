import java.io.File;
import java.util.Objects;

public class FileUtils {
    public static long calculateFolderSize(String path) {
        File file = new File(path);
        long size = 0;
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File files : Objects.requireNonNull(file.listFiles())) {
                    if (files.isDirectory()) {
                            size += calculateFolderSize(files.getAbsolutePath());
                    } else if (files.isFile()) {
                        size += + files.length();
                    }
                }
                return size;
            } else return file.length();
        } else {
            throw new IllegalArgumentException("Папка или файл по указанному пути не существует");
        }
    }
}
