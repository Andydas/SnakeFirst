import java.util.Random;
/**
 * Jablko, ktore sluzi ako potrava pre hada.
 * Po tom ako had zje jablko, vykresli sa nove.
 * Suradnice jablka su generovane nahodne a tak, aby boli vzdy mimo hada a mimo okraj.
 */
public class Jablko {
    private int riadok;
    private int stlpec;
    private SegmentPola jablko;
    private Random random;
    private HraciePole hraciePole;
    
    private static Jablko getJablko;
    /**
     * Jedinacik jablka.
     */
    public static Jablko getJablko() {
        if (Jablko.getJablko == null) {
            Jablko.getJablko = new Jablko();
        }
        return Jablko.getJablko;
    }
    
    /**
     * Vytvori prve jablko na nahodnych suradniciach.
     */
    public Jablko() {
        this.hraciePole = this.hraciePole.getHraciePole();
        this.random = new Random();
        this.riadok = this.random.nextInt(this.hraciePole.getHraciePole().getVyska()) + 0;
        this.stlpec = this.random.nextInt(this.hraciePole.getHraciePole().getSirka()) + 0;
        while (!this.povolenySpawn()) {
            this.riadok = this.random.nextInt(this.hraciePole.getHraciePole().getVyska()) + 0;
            this.stlpec = this.random.nextInt(this.hraciePole.getHraciePole().getSirka()) + 0;
        } 
        this.jablko = new SegmentPola(this.riadok, this.stlpec, "red");
        this.hraciePole.prefarbiStvorec(this.riadok, this.stlpec, "red");  
    }
    
    /**
     * Vytvori nove jablko na nahodnych suradniciach.
     */
    public void vytvorJablko() {
        this.riadok = this.random.nextInt(this.hraciePole.getHraciePole().getVyska()) + 0;
        this.stlpec = this.random.nextInt(this.hraciePole.getHraciePole().getSirka()) + 0; 
        while (!this.povolenySpawn()) {
            this.riadok = this.random.nextInt(this.hraciePole.getHraciePole().getVyska()) + 0;
            this.stlpec = this.random.nextInt(this.hraciePole.getHraciePole().getSirka()) + 0; 
        }
        this.jablko.nastav(this.riadok, this.stlpec);
        this.hraciePole.prefarbiStvorec(this.riadok, this.stlpec, "red");
    }
    
    /**
     * Kontroluje ci genrovane suradnice jablka su mimo hada a mimo steny hracieho pola
     */
    public boolean povolenySpawn() {
        if (this.hraciePole.obsadenyStvorec(this.riadok, this.stlpec) == 'n') {
            return true;
        }
        return false;
    }
    
    /**
     * Skryje aktualne jablko
     */
    public void skryJablko() {
        this.hraciePole.getHraciePole().prefarbiStvorec(this.riadok, this.stlpec, "black");
    }
    
    /**
     * Vrati riadok na ktorom sa jablko nachadza v poli.
     */
    public int getRiadok() {
        return this.riadok;
    }
    
    /**
     * Vrati stlpec na ktorom sa jablko nachadza v poli.
     */
    public int getStlpec() {
        return this.stlpec;
    }
}
