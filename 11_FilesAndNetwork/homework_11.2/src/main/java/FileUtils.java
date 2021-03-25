import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        File file = new File(sourceDirectory);
        if (file.exists()) {
            if (file.isDirectory()) {
                File newFile;
                //Ситуация, если папка копируется в директорию, в которой сама же и находится
                if (file.getParent().equals(destinationDirectory)) {
                    newFile = new File(destinationDirectory, file.getName() + " - копия");
                    newFile.mkdir();
                    copyFolder(file.getAbsolutePath(), newFile.getAbsolutePath());
                }
                for (File files : Objects.requireNonNull(file.listFiles())) {
                    newFile = new File(destinationDirectory, files.getName());
                    if (files.isDirectory()) {
                        newFile.mkdir();
                        copyFolder(files.getAbsolutePath(), newFile.getAbsolutePath());
                    } else if (files.isFile()) {
                        newFile.createNewFile();
                        try (FileInputStream sourceFile = new FileInputStream(files.getAbsolutePath());
                             FileOutputStream destinationFile = new FileOutputStream(newFile.getAbsolutePath())) {
                            byte[] buffer = new byte[sourceFile.available()];
                            sourceFile.read(buffer);
                            destinationFile.write(buffer);
                        }
                    }
                }
            } else {
                File newFile;
                //Ситуация, если файл копируется в директорию, в которой сам и находится
                if (file.getParent().equals(destinationDirectory)) {
                    Pattern name = Pattern.compile(".+(?=\\.)");
                    Pattern fileType = Pattern.compile("(?<=\\.).+");
                    Matcher matchName = name.matcher(file.getName());
                    Matcher fileTypeName = fileType.matcher(file.getName());
                    matchName.find();
                    fileTypeName.find();
                    newFile = new File(destinationDirectory, (matchName.group() + " - копия." + fileTypeName.group()));
                } else {
                    newFile = new File(destinationDirectory, file.getName());
                }
                newFile.createNewFile();
                try {
                    FileInputStream sourceFile = new FileInputStream(file.getAbsolutePath());
                    FileOutputStream destinationFile = new FileOutputStream(newFile.getAbsolutePath());
                    byte[] buffer = new byte[sourceFile.available()];
                    sourceFile.read(buffer);
                    destinationFile.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new IllegalArgumentException("Папка или файл по указанному пути не существует");
        }
    }
}
