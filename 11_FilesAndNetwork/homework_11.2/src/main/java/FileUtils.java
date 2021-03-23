import java.io.*;
import java.util.Objects;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        File file = new File(sourceDirectory);
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File files : Objects.requireNonNull(file.listFiles())) {
                    File newFile = new File(destinationDirectory, files.getName());
                    if (files.isDirectory()) {
                        newFile.mkdir();
                        copyFolder(files.getAbsolutePath(), newFile.getAbsolutePath());
                    } else if (files.isFile()) {
                        newFile.createNewFile();
                        try (FileInputStream sourceFile = new FileInputStream(files.getAbsolutePath());
                             FileOutputStream destinationFile = new FileOutputStream(newFile.getAbsolutePath())){
                            byte[] buffer = new byte[sourceFile.available()];
                            sourceFile.read(buffer);
                            destinationFile.write(buffer);
                        }
                    }
                }
        } else {
                File newFile = new File(destinationDirectory, file.getName());
                newFile.createNewFile();
                try (FileInputStream sourceFile = new FileInputStream(file.getAbsolutePath());
                     FileOutputStream destinationFile = new FileOutputStream(newFile.getAbsolutePath())){
                    byte[] buffer = new byte[sourceFile.available()];
                    sourceFile.read(buffer);
                    destinationFile.write(buffer);
                }
            }
        } else {
            throw new IllegalArgumentException("Папка или файл по указанному пути не существует");
        }
    }
}
