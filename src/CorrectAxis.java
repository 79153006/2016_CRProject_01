/**
 * Created by Ryohei Ichii
 * Informaion Systems Design Laboratory
 * Hokkaido University Information Initiative Center 2016
 */
public class CorrectAxis {
    private double[] rawX;
    private double[] rawY;
    private double[] rawZ;
    private double[] corZ;
    private String[] timeStamp;
    CorrectAxis(){
        rawX = new double[DefaultSettings.freq*DefaultSettings.duration];
        rawY = new double[DefaultSettings.freq*DefaultSettings.duration];
        rawZ = new double[DefaultSettings.freq*DefaultSettings.duration];
        corZ = new double[DefaultSettings.freq*DefaultSettings.duration];
    }
    public void tiltcorrect(double[] rawX, double[] rawY, double[] rawZ){
        for(int i=0;i<rawZ.length;i++){
            corZ[i] = -rawX[i]*Math.sin(DefaultSettings.tiltxz)-rawY[i]*Math.sin(DefaultSettings.tiltyz)* Math.cos(DefaultSettings.tiltxz)
                    +rawZ[i]*Math.cos(DefaultSettings.tiltxz)*Math.cos(DefaultSettings.tiltyz);
        }
    }

    public double[] getZAxis(){
        return corZ;
    }

    public String[] gettimeStamp(){
        return timeStamp;
    }

}
