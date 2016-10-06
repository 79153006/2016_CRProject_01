/**
 * Created by Ryohei Ichii
 * Informaion Systems Design Laboratory
 * Hokkaido University Information Initiative Center 2016
 */
public class dpmAS {
    private double dz[];
    private double vz[];
    private double lz[];

    dpmAS(){
        dz = new double[DefaultSettings.freq*(DefaultSettings.duration-DefaultSettings.samplingdur)];
        vz = new double[DefaultSettings.freq*(DefaultSettings.duration-DefaultSettings.samplingdur)];
        lz = new double[DefaultSettings.freq*(DefaultSettings.duration-2*DefaultSettings.samplingdur)];
    }

    public void vibcorrect(double[] corZ){
        int zj;
        for(int i = DefaultSettings.samplingdur/2*DefaultSettings.freq;i<(DefaultSettings.duration-DefaultSettings.samplingdur/2)*DefaultSettings.freq;i++){
            zj=0;
            vz[i-DefaultSettings.samplingdur/2*DefaultSettings.freq] = corZ[i];
            for(int j =i-DefaultSettings.samplingdur/2*DefaultSettings.freq;j<i+DefaultSettings.samplingdur/2*DefaultSettings.freq;j++){
                zj+=corZ[j];
            }
            zj/=DefaultSettings.samplingdur*DefaultSettings.freq;
            vz[i-DefaultSettings.samplingdur/2*DefaultSettings.freq]-=zj;
            dz[i-DefaultSettings.samplingdur/2*DefaultSettings.freq] = vz[i-DefaultSettings.samplingdur/2*DefaultSettings.freq];
            vz[i-DefaultSettings.samplingdur/2*DefaultSettings.freq]/=DefaultSettings.freq;
            if(i!=DefaultSettings.samplingdur/2*DefaultSettings.freq){
                vz[i-DefaultSettings.samplingdur/2*DefaultSettings.freq]+=vz[i-DefaultSettings.samplingdur/2*DefaultSettings.freq-1];
            }
        }
        int vj;
        for(int i = DefaultSettings.samplingdur*DefaultSettings.freq;i<(DefaultSettings.duration-DefaultSettings.samplingdur)*DefaultSettings.freq;i++){
            vj=0;
            lz[i-DefaultSettings.samplingdur*DefaultSettings.freq] = vz[i-DefaultSettings.samplingdur*DefaultSettings.freq/2];
            for(int j =i-DefaultSettings.samplingdur*DefaultSettings.freq+1;j<=i;j++){
                vj+=vz[j];
            }
            vj/=DefaultSettings.samplingdur*DefaultSettings.freq;
            lz[i-DefaultSettings.samplingdur*DefaultSettings.freq]-=vj;
            lz[i-DefaultSettings.samplingdur*DefaultSettings.freq]/=DefaultSettings.freq;
            if(i!=DefaultSettings.samplingdur*DefaultSettings.freq){
                lz[i-DefaultSettings.samplingdur*DefaultSettings.freq]+=lz[i-DefaultSettings.samplingdur*DefaultSettings.freq-1];
            }
        }


    }

    public double[] getdz(){
        return dz;
    }
    public double[] getvz(){
        return vz;
    }
    public double[] getlz(){
        return lz;
    }




}
