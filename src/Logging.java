import java.io.*;

/**
 * Created by Ryohei Ichii
 * Informaion Systems Design Laboratory
 * Hokkaido University Information Initiative Center 2016
 */
public class Logging {
    public void writeFile(String[] timeStamp,double[] data) {
        try {
            File file = new File(DefaultSettings.fileaddress);

            if (checkBeforeWritefile(file)) {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

                for(int i = 0;i<data.length;i++) {
                    pw.println(timeStamp[i] + "," + data[i]);
                }
                pw.close();
            } else {
                System.out.println("error:filewrite");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static boolean checkBeforeWritefile(File file){
        if (file.exists()){
            if (file.isFile() && file.canWrite()){
                return true;
            }
        }

        return false;
    }
}
