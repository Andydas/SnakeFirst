/**
 * Cislico tvorene 7 segmentami. 
 * Podla zadanych suradnic a hodnoty vykresli cislicu pomocou jednotlivych segmentov.
 */
public class SegmentoveCislo {
    private Obdlznik pozadie;
    private Obdlznik s1;
    private Obdlznik s2;
    private Obdlznik s3;
    private Obdlznik s4;
    private Obdlznik s5;
    private Obdlznik s6;
    private Obdlznik s7;
    private int hodnota;

    /**
     * Vytvori cislo spolu s jeho ciernym pozadim so sirkou 16, vyskou 28
     * sirka cisla je 14, vyska cisla 26, okraj cislice je 1
     */
    public SegmentoveCislo(int x, int y, int hodnota) {
        this.hodnota = hodnota; 
        this.pozadie = new Obdlznik(x, y, 16, 28, "black");
        this.pozadie.zobraz();
        this.s1 = new Obdlznik(x + 3, y + 1, 10, 2, "white");
        this.s1.zobraz();
        this.s2 = new Obdlznik(x + 1, y + 3, 2, 10, "white");
        this.s2.zobraz();
        this.s3 = new Obdlznik(x + 13, y + 3, 2, 10, "white");
        this.s3.zobraz();
        this.s4 = new Obdlznik(x + 3, y + 13, 10, 2, "white");
        this.s4.zobraz();
        this.s5 = new Obdlznik(x + 1, y + 15, 2, 10, "white");
        this.s5.zobraz();
        this.s6 = new Obdlznik(x + 13, y + 15, 2, 10, "white");
        this.s6.zobraz();
        this.s7 = new Obdlznik(x + 3, y + 25, 10, 2, "white");
        this.s7.zobraz();
        this.zobraz(hodnota);
    }
    
    /**
     * Zobrazi cislo podla hodnoty 0 az 9
     */
    public void zobraz(int hodnota) {
        switch (hodnota) {
            case 0:
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("white");
                this.s3.zmenFarbu("white");
                this.s4.zmenFarbu("black");
                this.s5.zmenFarbu("white");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("white");
                break;
            case 1:
                this.s1.zmenFarbu("black");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("white");
                this.s4.zmenFarbu("black");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("black");
                break;
            case 2:
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("white");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("white");
                this.s6.zmenFarbu("black");
                this.s7.zmenFarbu("white");
                break;
            case 3:
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("white");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("white");
                break;
            case 4:
                this.s1.zmenFarbu("black");
                this.s2.zmenFarbu("white");
                this.s3.zmenFarbu("white");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("black");
                break;
            case 5:
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("white");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("white");
                break;
            case 6:
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("white");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("white");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("white");
                break;
            case 7:
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("white");
                this.s4.zmenFarbu("black");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("black");
                break;
            case 8:
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("white");
                this.s3.zmenFarbu("white");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("white");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("white");
                break;
            case 9:
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("white");
                this.s3.zmenFarbu("white");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("white");
                break;
            default:
                this.s1.zmenFarbu("black");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("black");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("black");
                this.s7.zmenFarbu("black");
                break;
        }
    }
}
