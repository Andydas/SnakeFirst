
/**
 * Hracie pole na ktorom sa pohybuje had a vykresluje sa jablko
 */
public class HraciePole {
    private Stvorec [][] stvorce;
    
    
    private static HraciePole hraciePole;
    /**
     * Jedinacik hracieho pola.
     */
    public static HraciePole getHraciePole() {
        if (HraciePole.hraciePole == null) {
            HraciePole.hraciePole = new HraciePole();
        }
        return HraciePole.hraciePole;
    }
    
    /**
     * Vytvori nove hracie pole s rozmerom 20x20 stvorcov s rozmerom 15x15 pricom kazdy stvorec ma okraj 1.
     * Hracie pole ma modry okraj ktory je chapany ako stena pola.
     */
    public HraciePole() {
        this.stvorce = new Stvorec[20][20];
        for (int i = 0; i < this.stvorce.length; ++i) {
            for (int k = 0; k < this.stvorce[i].length; ++k) {
                this.stvorce[i][k] = new Stvorec(k * 16, 31 + i * 16, "black");
                this.stvorce[i][k].zobraz();
            }
        }
        this.vykresliOkraj();
    }
    
    /**
     * Vykresli modru stenu hraieho pola.
     */
    public void vykresliOkraj() {
        for (int i = 0; i < 20; ++i) {
            this.stvorce[0][i].zmenFarbu("blue");
            this.stvorce[i][19].zmenFarbu("blue");
            this.stvorce[19][i].zmenFarbu("blue");
            this.stvorce[i][0].zmenFarbu("blue");
        }
    }
    
    
    /**
     * Kontroluje cim je obsadeny stvorec pola. 
     * Jablko (cerveny stvorec) = 'j'
     * Had (zeleny stvorec) = 'h'
     * Okraj (stena) pola (modry stvorec) = 'o'
     * Volne policko pola (cierny stvorec) = 'n'
     */
    public char obsadenyStvorec(int riadok, int stlpec) {
        if (this.stvorce[riadok][stlpec].getFarba().equals("red")) {
            return 'j';
        } else if (this.stvorce[riadok][stlpec].getFarba().equals("green")) {
            return 'h';
        } else if (this.stvorce[riadok][stlpec].getFarba().equals("blue")) {
            return 'o';
        } else {
            return 'n';
        }
    }
    
    /**
     * Prefarbuje jednotlive stvorce pola podla zadanych suradnic na danu farbu.
     */
    public void prefarbiStvorec (int riadok, int stlpec, String farba) {
        if (riadok < this.getVyska()) {
            if (stlpec < this.getSirka()) {
                this.stvorce[riadok][stlpec].zmenFarbu(farba);
            } else {
                return;
            }
        } else {
            return;
        }       
    }
    
    /**
     * Vracia sirku pola (pocet stvorcov na sirku).
     */
    public int getSirka() {
        return this.stvorce[0].length;
    }
    
    /**
     * Vracia vysku pola (pocet stvorcov na vysku).
     */
    public int getVyska() {
        return this.stvorce.length;
    }
}
