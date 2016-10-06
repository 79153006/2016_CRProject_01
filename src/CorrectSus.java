/**
 * Created by Ryohei Ichii
 * Informaion Systems Design Laboratory
 * Hokkaido University Information Initiative Center 2016
 */
public class CorrectSus {
    private double u[];
    private double du[];
    private double pf;
    private double h;

    CorrectSus() {
        u = new double[DefaultSettings.freq * (DefaultSettings.duration - 2*DefaultSettings.samplingdur)];
        du = new double[DefaultSettings.freq * (DefaultSettings.duration - 2*DefaultSettings.samplingdur)];
        pf = 2*Math.PI*DefaultSettings.rf;
        h = DefaultSettings.dratio;
    }

    public void suscorrect(String[] timeStamp, double[] dz, double[] vz, double[] lz) {
        u[0]=0;
        du[0] = (dz[DefaultSettings.freq*DefaultSettings.samplingdur/2-1]
                +2*h*pf*vz[DefaultSettings.freq*DefaultSettings.samplingdur/2-1]
                +pf*pf*(lz[0]-u[0]))/(2*h*pf);
        for(int i = 1;i<DefaultSettings.freq*(DefaultSettings.duration-2*DefaultSettings.samplingdur);i++){
            u[i]= 2*DefaultSettings.freq/(pf*pf+1)*u[i-1]
                    +(dz[i+DefaultSettings.freq*DefaultSettings.samplingdur/2-1]
                    +2*h*pf*vz[i+DefaultSettings.freq*DefaultSettings.samplingdur/2-1]
                    +pf*pf*lz[i]+du[i-1]*2*h*pf)/(pf*pf+1);
            du[i] = (dz[i+DefaultSettings.freq*DefaultSettings.samplingdur/2-1]
                    +2*h*pf*vz[i+DefaultSettings.freq*DefaultSettings.samplingdur/2-1]
                    +pf*pf*(lz[i]-u[i]))/(2*h*pf);
        }
    }

    public double[] getu(){
        return u;
    }
}
