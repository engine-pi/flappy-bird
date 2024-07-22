/**
 * Beschreiben Sie hier die Klasse FLAPPY_BIRD.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class FLAPPY_BIRD extends SPIEL
{
    private VOGEL vogel;

    private ROHRE[] rohre;

    private TEXT gameover_text;

    private SOUND gameover_sound;

    int punktestand;

    /**
     * Konstruktor für Objekte der Klasse FLAPPY_BIRD
     */
    public FLAPPY_BIRD()
    {
        super(794, 527, false, false, false);
        setzeHintergrundgrafik("images/background_wide.png");
        vogel = new VOGEL();
        rohre = new ROHRE[3];
        for (int i = 0; i < 3; i++)
        {
            // Zufällige Höhe der Rohre
            int y_zufall = zufallszahlVonBis(-50, 125);
            rohre[i] = new ROHRE(265 * (i + 1), y_zufall);
        }
        punktestand = 0;
        setzeNurLinkePunkteanzeigeSichtbar();
        setzePunkteanzeigeLinks(punktestand);
        tickerNeuStarten(100);
    }

    /**
     * Wird regelmaessig automatisch aufgerufen. So kommt Bewegung ins Spiel!
     * Tick-Intervall kann angepasst werden. Ticker muss erst gestartet werden.
     */
    @Override
    public void tick()
    {
        if (istSpielVorbei())
        {
            tickerStoppen();
            gameover();
        }
        else
        {
            vogel.fallen();
            for (int i = 0; i < 3; i++)
            {
                int y_zufall = zufallszahlVonBis(-50, 150);
                rohre[i].bewegen(794, y_zufall);
                aktualisierePunktestand();
            }
        }
    }

    /**
     * Methode, die den Punktestand aktualisiert
     *
     * @param neuerPunktestand Neuer Punktestand
     */
    public void aktualisierePunktestand()
    {
        // Pro Tick wird der Punktestand um 10 erhöht
        punktestand = punktestand + 1;
        this.setzePunkteanzeigeLinks(punktestand);
    }

    /**
     * Methode, die überprüft, ob eine Taste gedrückt wurde
     *
     * @param taste gedrückte Taste
     */
    @Override
    public void tasteReagieren(int taste)
    {
        switch (taste)
        {
        case TASTE.OBEN: // Pfeil nach oben
            vogel.fliegen();
            break;
        }
    }

    /**
     * Methode, die überprüft, ob das Spiel vorbei ist
     */
    public boolean istSpielVorbei()
    {
        // Das Spiel ist vorbei wenn entweder dein Rohr berührt wird...
        for (int i = 0; i < 3; i++)
        {
            if (rohre[i].berührt(vogel))
            {
                return true;
            }
        }
        // ... oder der Vogel außerhalb des Fensters ist
        if (vogel.getY() > 527)
        {
            return true;
        }
        return false;
    }

    /**
     * Methode, die Text "Game over"!" anzeigt
     */
    public void gameover()
    {
        gameover_text = new TEXT(350, 263, "Game over!");
        gameover_text.setzeGroesse(50);
        gameover_text.setzeFarbe("Rot");
        gameover_sound = new SOUND("sounds/gameover.mp3");
        gameover_sound.play();
    }
}
