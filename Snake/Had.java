import java.util.ArrayList;

/**
 * Had, jeho pohyb po poli a kontrola kolizie + vytvorenie jablka. 
 */
public class Had {
    private int riadok;
    private int stlpec;
    private int dlzka;
    private boolean pauza;
    private char smerPohybu;
    private ArrayList<SegmentPola> had;
    private HraciePole hraciePole;
    private Jablko jablko;
    private String farba;

    /**
     * Vytvori prveho hada ako ArrayList s pozadovanou dlzkou a farbou a jablko na zadanom hracom poli.
     */
    public Had(int dlzka, HraciePole hraciePole, String farba) {
        this.dlzka = dlzka;
        this.hraciePole = hraciePole;
        this.farba = farba;
        this.had = new ArrayList<SegmentPola>();
        this.vytvorHada();
        this.jablko = new Jablko();
    }
    
    /**
     * Vytvori noveho hada.
     */
    public void vytvorHada() {
        this.riadok = (this.hraciePole.getVyska() / 2);
        this.stlpec = (this.hraciePole.getSirka() / 2);
        for (int i = 0; i < this.dlzka; ++i) {
            this.pridajCastHada(this.riadok, this.stlpec + i, this.farba);
            this.had.get(i).zobraz();
        }
        this.pauza = true;
        this.smerPohybu = 'l';
    }
    
    /**
     * Vymaze aktualneho hada.
     */
    public void vymazHada() {
        for (int i = 0; i < this.had.size(); ++i) {
            this.had.get(i).skry();
        }
        this.had.clear();
    }

    /**
     * Prida cast hada na suradnice podla riadku, stlpca a zvolenej farby.
     */
    public void pridajCastHada(int riadok, int stlpec, String farba) {
        this.had.add(new SegmentPola(riadok, stlpec, farba));
    }

    /**
     * Skryje vykresleny stvorec na zadanych suradniciach.
     */
    public void skry(int riadok, int stlpec) {
        this.hraciePole.prefarbiStvorec(riadok, stlpec, "black");
    }

    /**
     * Zobrazi vykresleny stvorec na zadanych suradniciach.
     */
    public void zobraz(int riadok, int stlpec) {
        this.hraciePole.prefarbiStvorec(riadok, stlpec, this.farba);
    }
    
    /**
     * Urci smer pohybu hada (vlavo 'l', vpravo 'r', hore 'h', dole 'd').
     */
    public void urciSmer(char smer) {
        this.smerPohybu = smer;
    }

    /**
     * Vykona pohyb hada do urciteho smeru podla urceneho smeru pohybu.
     */
    public void pohyb() {
        if (!this.pauza) {
            switch (this.smerPohybu) {
                case 'd':
                    this.posunD();
                    break;
                
                case 'l':
                    this.posunL();
                    break;
                
                case 'r':
                    this.posunR();
                    break;   
                
                case 'h':
                    this.posunH();
                    break;  
            }
        } else {
            return;
        }
    }

    /**
     * Kontroluje, ci had zjedol jablko, TRUE = zjedol, FALSE = nezjedol.
     * Kontroluje sa stvorec pred hlavou hada.
     */
    public boolean zjedolJablko() {
        switch (this.smerPohybu) {
            case 'd':
                if (this.jablko.getRiadok() == this.riadok + 1 && this.jablko.getStlpec() == this.stlpec) {
                    return true;
                }
                break;
            case 'l':
                if (this.jablko.getRiadok() == this.riadok && this.jablko.getStlpec() == this.stlpec - 1) {
                    return true;
                }
                break;
            case 'r':
                if (this.jablko.getRiadok() == this.riadok && this.jablko.getStlpec() == this.stlpec + 1) {
                    return true;
                }
                break;   
            case 'h':
                if (this.jablko.getRiadok() == this.riadok - 1 && this.jablko.getStlpec() == this.stlpec) {
                    return true;
                }
                break;  
        }
        return false;
    }

    /**
     * Posunie hada o jeden stvorec smerom DOLE.
     * Prida stvorec na prve miesto o riadok nizsie a odstrani posledny stvorec
     */
    public void posunD() {
        if (this.pauza) {
            return;
        } else if (this.zjedolJablko()) {
            this.jablko.skryJablko();
            ++this.riadok;
            this.had.add(0, new SegmentPola(this.riadok, this.stlpec, this.farba));
            for (int i = 0; i < this.had.size(); ++i) {
                this.had.get(i).zobraz();
            }
            this.jablko.vytvorJablko();
        } else {
            ++this.riadok;
            this.had.add(0, new SegmentPola(this.riadok, this.stlpec, this.farba));
            this.had.get(this.had.size() - 1).skry();
            this.had.remove(this.had.size() - 1);  
            for (int i = 0; i < this.had.size(); ++i) {
                this.had.get(i).zobraz();
            }
        }
    }

    /**
     * Posunie hada o jeden stvorec smerom DOLAVA.
     * Prida stvorec na prve miesto o stlpec nizsie a odstrani posledny stvorec
     */
    public void posunL() {
        if (this.pauza) {
            return;
        } else if (this.zjedolJablko()) {
            this.jablko.skryJablko();
            --this.stlpec;
            this.had.add(0, new SegmentPola(this.riadok, this.stlpec, this.farba));
            for (int i = 0; i < this.had.size(); ++i) {
                this.had.get(i).zobraz();
            }
            this.jablko.vytvorJablko();
        } else {
            --this.stlpec;
            this.had.add(0, new SegmentPola(this.riadok, this.stlpec, this.farba));
            this.had.get(this.had.size() - 1).skry();
            this.had.remove(this.had.size() - 1);  
            for (int i = 0; i < this.had.size(); ++i) {
                this.had.get(i).zobraz();
            }
        }
    }

    /**
     * Posunie hada o jeden stvorec smerom DOPRAVA.
     * Prida stvorec na prve miesto o stlpec vyssie a odstrani posledny stvorec
     */
    public void posunR() {
        if (this.pauza) {
            return;
        } else if (this.zjedolJablko()) {
            this.jablko.skryJablko();
            ++this.stlpec;
            this.had.add(0, new SegmentPola(this.riadok, this.stlpec, this.farba));
            for (int i = 0; i < this.had.size(); ++i) {
                this.had.get(i).zobraz();
            }
            this.jablko.vytvorJablko();
        } else {
            ++this.stlpec;
            this.had.add(0, new SegmentPola(this.riadok, this.stlpec, this.farba));
            this.had.get(this.had.size() - 1).skry();
            this.had.remove(this.had.size() - 1);  
            for (int i = 0; i < this.had.size(); ++i) {
                this.had.get(i).zobraz();
            }
        }
    }

    /**
     * Posunie hada o jeden stvorec smerom HORE.
     * Prida stvorec na prve miesto o riadok vyssie a odstrani posledny stvorec
     */
    public void posunH() {
        if (this.pauza) {
            return;
        } else if (this.zjedolJablko()) {
            this.jablko.skryJablko();
            --this.riadok;
            this.had.add(0, new SegmentPola(this.riadok, this.stlpec, this.farba));
            for (int i = 0; i < this.had.size(); ++i) {
                this.had.get(i).zobraz();
            }
            this.jablko.vytvorJablko();
        } else {
            --this.riadok;
            this.had.add(0, new SegmentPola(this.riadok, this.stlpec, this.farba));
            this.had.get(this.had.size() - 1).skry();
            this.had.remove(this.had.size() - 1);  
            for (int i = 0; i < this.had.size(); ++i) {
                this.had.get(i).zobraz();
            }
        }
    }
    
    /**
     * Kontroluje ci had nenarazil do steny alebo do seba.
     * Hodnota true = had nabural, to znamena prehru
     * Hodnota false = pred hadom je volne policko, vsetko je ok
     * Kontroluje sa stvorec pred hlavou hada
     */
    public boolean kontrolaPrehry() {
        switch (this.smerPohybu) {
            case 'd':
                if (this.hraciePole.obsadenyStvorec(this.riadok + 1, this.stlpec) == 'h' || this.hraciePole.obsadenyStvorec(this.riadok + 1, this.stlpec) == 'o') {
                    return true;
                }
                return false;
                
            case 'l':
                if (this.hraciePole.obsadenyStvorec(this.riadok, this.stlpec - 1) == 'h' || this.hraciePole.obsadenyStvorec(this.riadok, this.stlpec - 1) == 'o') {
                    return true;
                } 
                return false;
                
            case 'r':
                if (this.hraciePole.obsadenyStvorec(this.riadok, this.stlpec + 1) == 'h' || this.hraciePole.obsadenyStvorec(this.riadok, this.stlpec + 1) == 'o') {
                    return true;
                } 
                return false;
                 
            case 'h':
                if (this.hraciePole.obsadenyStvorec(this.riadok - 1, this.stlpec) == 'h' || this.hraciePole.obsadenyStvorec(this.riadok - 1, this.stlpec) == 'o') {
                    return true;
                }
                return false;
                
        }
        return false;
    }

    /**
     * Skruje aktualne jablko na hracom poli.
     */
    public void skryJablko() {
        this.jablko.skryJablko();
    }
    
    /**
     * Zobrazi nove jablko s nahodnymi suradnicami na hracom poli.
     */
    public void vytvorJablko() {
        this.jablko.vytvorJablko();
    }
    
    /**
     * Obrati hodnotu pauzy.
     * Ak je hra pauznuta, odpauzuje ju.
     * Ak je hra odpauzovana, pauzne ju.
     */
    public void nastavPauzu() {
        this.pauza = !this.pauza;
    }

    /**
     * Vrati String hodnotu farby.
     */
    public String getFarba() {
        return this.farba;
    }

    /**
     * Vrati char hodnotu smeru (vlavo 'l', vpravo 'r', hore 'h', dole 'd').
     * 
     */
    public char getSmer() {
        return this.smerPohybu;
    }

    /**
     * Vrati int hodnotu ako suradnicu stlpca na ktorom je hlava hada.
     */
    public int getStlpec() {
        return this.stlpec;
    }

    /**
     * Vrati int hodnotu ako suradnicu riadku na ktorom je hlava hada.
     */
    public int getRiadok() {
        return this.riadok;
    }

    /**
     * Vrati boolean hodnotu pauzy, TRUE = hra je zastavena, FALSE = hra nie je zastavena.
     */
    public boolean getPauza() {
        return this.pauza;
    }
}
