
/**
 * Sekcia, ktora vykresli slovo "Score:" pomocou segmentovych pismen a za nim ciselnu hodnotu score podla zadaneho vstupu.
 */
public class Score {
    private SegmentovePismeno pismenoS;
    private SegmentovePismeno pismenoC;
    private SegmentovePismeno pismenoO;
    private SegmentovePismeno pismenoR;
    private SegmentovePismeno pismenoE;
    private SegmentovePismeno dotDot;
    private SegmentoveCislo jednotky;
    private SegmentoveCislo desiatky;
    private SegmentoveCislo stovky;
    private SegmentoveCislo tisicky;
    private Obdlznik pozadieScore;
    private int hodnotaScore;
    
    /**
     * Vytvori sa sekcia nad hracim polom, kde sa zobrazi napis "Score:" a aktualne score.
     * Sekcia ma vysku 30 a sirku 390. Biele pismena a cisla na ciernom pozadi.     
     */
    public Score(int hodnotaScore) {
        this.hodnotaScore = hodnotaScore;
        this.pozadieScore = new Obdlznik(0, 0, 390, 30, "black");
        this.pozadieScore.zobraz();
        this.pismenoS = new SegmentovePismeno(0, 0, 's');
        this.pismenoC = new SegmentovePismeno(16, 0, 'c');
        this.pismenoO = new SegmentovePismeno(32, 0, 'o');
        this.pismenoR = new SegmentovePismeno(48, 0, 'r');
        this.pismenoE = new SegmentovePismeno(64, 0, 'e');
        this.dotDot = new SegmentovePismeno(80, 0, ':');
        this.tisicky = new SegmentoveCislo(96, 0, this.hodnotaScore / 1000);
        this.stovky = new SegmentoveCislo(112, 0, (this.hodnotaScore % 1000) / 100);
        this.desiatky = new SegmentoveCislo(128, 0, (this.hodnotaScore % 100) / 10);
        this.jednotky = new SegmentoveCislo(144, 0, (this.hodnotaScore % 10) / 1);
    }
    
    /**
     * Vrati aktualnu hodnotu score.
     */
    public int getScore() {
        return this.hodnotaScore;
    }
    
    /**
     * Prepise aktualne zobrazenu ciselnu hodnotu score podla zadaneho vstupu.
     */
    public void noveScore(int score) {
        this.hodnotaScore = score;
        this.tisicky.zobraz(this.hodnotaScore / 1000);
        this.stovky.zobraz((this.hodnotaScore % 1000) / 100);
        this.desiatky.zobraz((this.hodnotaScore % 100) / 10);
        this.jednotky.zobraz((this.hodnotaScore % 10) / 1);
    }
   
    
   
}
