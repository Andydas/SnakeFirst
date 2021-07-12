import javax.swing.JOptionPane;
/**
 * Ovláda všetky časti hry a triedy ktoré ju tvoria
 */
public class Hra {
    private Had had;
    private Score zobrazScore;
    private int score;
    private Manazer manazer;
    private boolean povolenyInput;
    private boolean koniecHry;
    private HraciePole hraciePole;

    /**
     * Vytvori novu hru snake.
     * Pociatocne skore nastavene na 0, zakazana zmena smeru.
     */
    public Hra() {
        this.score = 0;
        this.zobrazScore = new Score(this.score);
        this.had = new Had(3, HraciePole.getHraciePole(), "green");
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.povolenyInput = false;
        this.koniecHry = false;
        
    }

    /**
     * Posiela spravu hadovi aby zmenil smer pohybu smerom DOLE a zakaze dalsiu zmenu smeru.
     * Metoda je osetrena aby sa had neotocil sam do seba. 
     */
    public void posunD() {
        if (this.had.getSmer() == 'h') {
            return;
        } else if (this.povolenyInput) {
            this.had.urciSmer('d');
            this.povolenyInput = false;
        }
    }

    /**
     * Posiela spravu hadovi aby zmenil smer pohybu smerom HORE a zakaze dalsiu zmenu smeru.
     * Metoda je osetrena aby sa had neotocil sam do seba. 
     */
    public void posunH() {
        if (this.had.getSmer() == 'd') {
            return;
        } else if (this.povolenyInput) {
            this.had.urciSmer('h');
            this.povolenyInput = false;
        }
    }

    /**
     * Posiela spravu hadovi aby zmenil smer pohybu smerom DOLAVA a zakaze dalsiu zmenu smeru.
     * Metoda je osetrena aby sa had neotocil sam do seba. 
     */
    public void posunL() {
        if (this.had.getSmer() == 'r') {
            return;
        } else if (this.povolenyInput) {
            this.had.urciSmer('l');
            this.povolenyInput = false;
        }
    }

    /**
     * Posiela spravu hadovi aby zmenil smer pohybu smerom DOPRAVA a zakaze dalsiu zmenu smeru.
     * Metoda je osetrena aby sa had neotocil sam do seba. 
     */
    public void posunR() {
        if (this.had.getSmer() == 'l') {
            return;
        } else if (this.povolenyInput) {
            this.had.urciSmer('r');
            this.povolenyInput = false;
        }
    }

    /**
     * Posiela spravu hadovi aby obratil hodnotu pauzy.
     * Metoda je osetrena aby had nemohol menit smer ked je hra zastavena. 
     */
    public void nastavPauzu() {
        this.had.nastavPauzu();
        this.povolenyInput = false;
    }
        
    /**
     * Vrati ciselnu hodnotu score v int.
     */
    public int getScore() {
        return this.score;
    }
    
    /**
     * Vrati boolean hodnotu pauzy, TRUE = hra je pozastavena, FALSE = hra nie je pozastavena.
     */
    public boolean getPauza() {
        return this.had.getPauza();
    }
    
    /**
     * Ukonci hru hada, vypise dosiahnute score a restartuje hru.
     */
    public void ukonciHru() {
        JOptionPane.showMessageDialog(null, "Koniec hry, dosiahnute score: " + this.score, "Koniec Hry", JOptionPane.INFORMATION_MESSAGE); 
        this.koniecHry = true;
        this.restartujHru();
        return;
    }
    
    /**
     * Posiela spravu hadovi aby vykonal pohyb.
     * Prva podmienka osetruje aby sa nic nevykonalo pokial je hra pozastavena alebo ukoncena
     * Druha podmienka osetruje aby sa hra ukoncila ak had do niecoho narazil
     * Tretia podmienka vykonava pohyb hada a zaroven pripocita 10 score ak had zjedol jablko
     */
    public void pohyb () {
        if (this.koniecHry || this.had.getPauza()) {
            return;
        }
        if (this.had.kontrolaPrehry()) {
            this.ukonciHru();
            return;
        } 
        if (!this.had.kontrolaPrehry()) {
            if (this.had.zjedolJablko()) {
                this.score = this.score + 10;
                this.zobrazScore.noveScore(this.score);
            }
            this.had.pohyb();
            this.povolenyInput = true;
            return;
        }
    }
    
    /**
     * Restartuje hru.
     * Vymaze sa stary had, vykresi sa novy
     * Vymaze sa stare jablko, vykresli sa nove
     * Score sa vynuluje a vynuluje sa aj na diplayi
     */
    public void restartujHru() {
        this.had.vymazHada();
        this.had.vytvorHada();
        this.had.skryJablko();
        this.had.vytvorJablko();
        this.score = 0;
        this.zobrazScore.noveScore(this.score);
        this.koniecHry = false; 
        this.povolenyInput = false;
    }
}
