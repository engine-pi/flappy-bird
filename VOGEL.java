
/**
 * Beschreiben Sie hier die Klasse VOGEL.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class VOGEL extends WECHSELBILD
{
    int dy, g;
    
    private SOUND flügelschlag;
    
    /**
     * Konstruktor für Objekte der Klasse VOGEL
     */
    public VOGEL()
    {
        super(397, 347, "images/bird1.png", "images/bird2.png");
        
        dy = 0;
        g = 2;
    }

    /**
     * Methode zum automatischen Fallen des Vogels (aufgrund der Schwerkraft)
     */
    public void fallen()
    {
        verschiebenUm(0, dy);
        dy = dy + g;
        
        if(dy > 0) {
            wechseln(0);
        }
    }

    /**
     * Methode zum Fliegen des Vogels 
     */
    public void fliegen() 
    {
        dy = -10;
        wechseln(1);
        flügelschlag = new SOUND("sounds/wing.mp3");
        flügelschlag.play();
    }
}
