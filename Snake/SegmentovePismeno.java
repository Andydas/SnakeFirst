/**
 * Pismeno tvorene 9 segmentami (7segmentov pismeno, 8 a 9 segment tvoria dvojbodku). 
 * Podla zadanych suradnic a hodnoty vykresli pismeno pomocou jednotlivych segmentov.
 */
public class SegmentovePismeno {
    private Obdlznik pozadie;
    private Obdlznik s1;
    private Obdlznik s2;
    private Obdlznik s3;
    private Obdlznik s4;
    private Obdlznik s5;
    private Obdlznik s6;
    private Obdlznik s7;
    private Obdlznik s8;
    private Obdlznik s9;
    private char hodnota;
    
    /**
     * Vytvori pismeno spolu s jeho ciernym pozadim so sirkou 16, vyskou 28
     * sirka pismena je 14, vyska 26
     * okraj je 1
     */
    public SegmentovePismeno(int x, int y, char hodnota) {
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
        
        this.s8 = new Obdlznik(x + 3, y + 9, 3, 3, "white");
        this.s8.zobraz();
        
        this.s9 = new Obdlznik(x + 3, y + 17, 3, 3, "white");
        this.s9.zobraz();
        
        this.zobraz(hodnota);
    }
    
    /**
     * Zobrazi pismeno podla vstupnej hodnoty {s, c, o, r, e, :}
     */
    public void zobraz(char hodnota) {
        switch (hodnota) {
            case 's':
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("white");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("white");
                this.s8.zmenFarbu("black");
                this.s9.zmenFarbu("black");
                break;
            case 'c':
                this.s1.zmenFarbu("black");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("white");
                this.s6.zmenFarbu("black");
                this.s7.zmenFarbu("white");
                this.s8.zmenFarbu("black");
                this.s9.zmenFarbu("black");
                break;
            case 'o':
                this.s1.zmenFarbu("black");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("white");
                this.s6.zmenFarbu("white");
                this.s7.zmenFarbu("white");
                this.s8.zmenFarbu("black");
                this.s9.zmenFarbu("black");
                break;
            case 'r':
                this.s1.zmenFarbu("black");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("white");
                this.s6.zmenFarbu("black");
                this.s7.zmenFarbu("black");
                this.s8.zmenFarbu("black");
                this.s9.zmenFarbu("black");
                break;
            case 'e':
                this.s1.zmenFarbu("white");
                this.s2.zmenFarbu("white");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("white");
                this.s5.zmenFarbu("white");
                this.s6.zmenFarbu("black");
                this.s7.zmenFarbu("white");
                this.s8.zmenFarbu("black");
                this.s9.zmenFarbu("black");
                break;
            case ':':
                this.s1.zmenFarbu("black");
                this.s2.zmenFarbu("black");
                this.s3.zmenFarbu("black");
                this.s4.zmenFarbu("black");
                this.s5.zmenFarbu("black");
                this.s6.zmenFarbu("black");
                this.s7.zmenFarbu("black");
                this.s8.zmenFarbu("white");
                this.s9.zmenFarbu("white");
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
