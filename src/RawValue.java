import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Ryohei Ichii
 * Informaion Systems Design Laboratory
 * Hokkaido University Information Initiative Center 2016
 */
public class RawValue {
    private String timeStamp[];
    private double rawX[];
    private double rawY[];
    private double rawZ[];
    int i;
    RawValue(){
        timeStamp  = new String[DefaultSettings.freq * DefaultSettings.duration];
        rawX  = new double[DefaultSettings.freq * DefaultSettings.duration];
        rawY  = new double[DefaultSettings.freq * DefaultSettings.duration];
        rawZ  = new double[DefaultSettings.freq * DefaultSettings.duration];
        i =0;
    }

    public void readFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Users\\Public\\Documents\\test1.csv"));
            try {
                while (true) {
                    String line = br.readLine();
                    if (line == null || i >= rawX.length) {
                        break;
                    }
                    String kugiri[] = line.split(",");
                    timeStamp[i] = kugiri[0];
                    rawX[i]=Double.valueOf(kugiri[1]);
                    rawY[i]=Double.valueOf(kugiri[2]);
                    rawZ[i]=Double.valueOf(kugiri[3]);
                    i++;
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] gettimeStamp(){
        return timeStamp;
    }

    public double[] getXAxis(){
        return rawX;
    }

    public double[] getYAxis(){
        return rawY;
    }

    public double[] getZAxis(){
        return rawZ;
    }
}
