
import java.util.ArrayList;

public class rekaGracza extends Main{
    Integer numer;
    ArrayList<Card> karty = new ArrayList<Card>();

    public Integer getNumer() {
        return numer;
    }

    public ArrayList<Card> getKarty() {
        return karty;
    }

    public rekaGracza(int numer, ArrayList<Card> karty) {
        this.numer = numer;
        this.karty = karty;
    }
}
