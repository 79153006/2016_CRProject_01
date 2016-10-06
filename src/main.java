/**
 * Created by Ryohei Ichii
 * Informaion Systems Design Laboratory
 * Hokkaido University Information Initiative Center 2016
 */
public class main {
    public static void main(String[] args){
        RawValue rv = new RawValue();
        rv.readFile();
        CorrectAxis ca = new CorrectAxis();
        ca.tiltcorrect(rv.getXAxis(),rv.getYAxis(),rv.getZAxis());
        dpmAS da = new dpmAS();
        da.vibcorrect(ca.getZAxis());
        CorrectSus cs = new CorrectSus();
        cs.suscorrect(rv.gettimeStamp(),da.getdz(),da.getvz(),da.getlz());
        Logging lg = new Logging();
        lg.writeFile(rv.gettimeStamp(),cs.getu());
    }
}
