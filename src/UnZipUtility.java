import java.io.*;
import java.util.zip.*;

public class UnZipUtility {

    public void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                } else {
                    File dir = new File(filePath);
                    dir.mkdirs();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    public static void main(String[] args) {
        UnZipUtility unzipper = new UnZipUtility();
        String zipFilePath = "C:\\Users\\user\\OneDrive\\Desktop\\ZippedFileTesting\\zippedTesting.zip";
        String destDirectory = "C:\\Users\\user\\OneDrive\\Desktop\\ZippedFileTesting";
        try {
            unzipper.unzip(zipFilePath, destDirectory);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
