import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class FileCopier implements Runnable{
    private final File[] files;
    private final String dstFolder;
    private final int newWidth;
    private final String format;

    public FileCopier(File[] files, String dstFolder, int newWidth, String format){
        this.files = files;
        this.dstFolder = dstFolder;
        this.newWidth = newWidth;
        this.format = format;
    }

    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " запущен");
        try
        {
            for(File file : files) {
                BufferedImage image = ImageIO.read(file);
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth));
                image = Scalr.resize(image,
                        Scalr.Method.QUALITY,
                        Scalr.Mode.FIT_EXACT,
                        newWidth,
                        newHeight);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(image, format, newFile);
                image.flush();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
