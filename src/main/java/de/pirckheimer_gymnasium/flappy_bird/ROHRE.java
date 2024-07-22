/**
 * Beschreiben Sie hier die Klasse ROHRE.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ROHRE
{
    private OBERES_ROHR oberes_rohr;

    private UNTERES_ROHR unteres_rohr;

    /**
     * Konstruktor für Objekte der Klasse ROHRE
     */
    public ROHRE(int x, int y)
    {
        oberes_rohr = new OBERES_ROHR(x, y);
        unteres_rohr = new UNTERES_ROHR(x, y + 450);
    }

    /**
     * Methode, die die beiden Rohre bewegt
     */
    public void bewegen(int x, int y)
    {
        if (oberes_rohr.getX() > 0)
        {
            oberes_rohr.verschiebenUm(-20, 0);
            unteres_rohr.verschiebenUm(-20, 0);
        }
        else
        {
            // Rohre erscheinen erneut von rechts und Höhe variieren
            oberes_rohr.setzeMittelpunkt(x, y);
            unteres_rohr.setzeMittelpunkt(x, y + 450);
        }
    }

    /**
     * Methode, die neuen Mittelpunkt setzt
     *
     * @param x x-Koordinaten des neuen Mittelpunkts
     */
    public void setzeMittelpunkt(int x, int y)
    {
        oberes_rohr.setzeMittelpunkt(x, y);
        unteres_rohr.setzeMittelpunkt(x, y + 450);
    }

    /**
     * Methode, die überprüft, ob ein Rohr den Vogel berührt
     *
     * @param Vogel
     * @return True, falls ein Rohr den Vogel berührt
     */
    public boolean berührt(VOGEL vogel)
    {
        if (oberes_rohr.beruehrt(vogel) || unteres_rohr.beruehrt(vogel))
        {
            return true;
        }
        else
            return false;
    }
}
