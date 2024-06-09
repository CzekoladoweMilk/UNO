
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static ArrayList<Card> sortpile = new ArrayList<Card>();
    static Stack<Card> pile = new Stack<Card>();
    static Random rand = new Random();

    public static void main(String[] args) {
        Scanner gracze = new Scanner(System.in);
        Scanner ruch_gracza = new Scanner(System.in);
        Scanner wild = new Scanner(System.in);
        Integer color_switch;
        int ruch;
        int random;
        boolean reverse = false;
        System.out.println("Podaj ilosc graczy od 2 do 4: ");
        Integer ilosc_graczy = null;

        boolean czyDobrze = false;
        while (!czyDobrze){
            ilosc_graczy = Integer.valueOf(gracze.nextLine());
            if(ilosc_graczy<2 || ilosc_graczy>4){
                System.out.println("Bledna ilosc graczy, sprobuj ponownie: ");
            }
            else{
                System.out.println("Poprawna ilosc graczy");
                czyDobrze = true;
            }
        }

        czyDobrze = false;

        new PotasujTalie();

        ArrayList<rekaGracza> players = new ArrayList<>();
        ArrayList<Card> kartyGracza = new ArrayList<Card>();
        int numer_gracza = 0;

        /* Mechanizm rozdawania kart został zmieniony, jednak dalej działa na podobnej jak wcześniej zasadzie
           Nie udało mi się wpaść na szybkie rozwiązanie problemu, zgodne z obecnym kodem */

        int karty_do_rozdania = ilosc_graczy*7;
        while(karty_do_rozdania>=0){
            kartyGracza.add(new Card(pile.peek().getNazwa(),pile.peek().getWartosc()));
            karty_do_rozdania--;

            pile.pop();
            if(kartyGracza.size()==7){
                players.add(new rekaGracza(kartyGracza));
                kartyGracza = new ArrayList<Card>();
                numer_gracza++;
            }
        }


        Card obecna_karta = pile.pop();

        boolean uno = false;

        ArrayList<Card> stos_odrzuconych = new ArrayList<>();
        int gracz = 0;
        String wybrana_karta_wartosc;
        String wybrana_karta_nazwa;

        while(!uno){
            System.out.println("Rozpoczyna się tura gracza " + (gracz + 1));
            System.out.println("Obecna karta na stole to: " + obecna_karta.getNazwa() + " " + obecna_karta.getWartosc());
            System.out.println("Oto twoje karty: ");
            System.out.println("0. Dobierz");
            for(int i=0;i<players.get(gracz).getKarty().size();i++){
                System.out.println(i+1 + ". " + players.get(gracz).getKarty().get(i).getNazwa() + " " + players.get(gracz).getKarty().get(i).getWartosc());
            }

            System.out.println("Wykonaj ruch, wybierz numer wskazujacy twoja karte: ");
            ruch = Integer.valueOf(ruch_gracza.nextLine());

            if(ruch == 0){
                players.get(gracz).getKarty().add(pile.pop());
                System.out.println("Dobrano karte");
                if(!reverse){
                    gracz++;
                }else{
                    gracz--;
                }
            } else {
                wybrana_karta_wartosc = players.get(gracz).getKarty().get(ruch-1).getWartosc();
                wybrana_karta_nazwa = players.get(gracz).getKarty().get(ruch-1).getNazwa();

                if(wybrana_karta_wartosc.equals(obecna_karta.getWartosc()) || wybrana_karta_nazwa.equals(obecna_karta.getNazwa()) || wybrana_karta_nazwa.equals("wild") || obecna_karta.getNazwa().equals("wild")){
                    System.out.println("Karta poprawna, zagrano: " + wybrana_karta_nazwa + " " + wybrana_karta_wartosc);
                    stos_odrzuconych.add(new Card(wybrana_karta_nazwa, wybrana_karta_wartosc));
                    players.get(gracz).karty.remove(ruch-1);

                    if (wybrana_karta_wartosc.equals("+2")) {
                        if(!reverse){
                            gracz++;
                        }else{
                            gracz--;
                        }
                        System.out.println("Oryginalna wartość:" + gracz);
                        if(gracz > ilosc_graczy-1){
                            gracz = gracz-ilosc_graczy;
                        } else if ( gracz < 0) {
                            gracz = ilosc_graczy-1;
                        }
                        System.out.println("Wartość po zmianie:" + gracz);
                        players.get(gracz).getKarty().add(pile.pop());
                        players.get(gracz).getKarty().add(pile.pop());

                    }

                    if (wybrana_karta_wartosc.equals("reverse")) {
                        if(reverse){
                            reverse = false;
                        }
                        else{
                            reverse = true;
                        }
                    }

                    if (wybrana_karta_wartosc.equals("skip")) {
                        if(!reverse){
                            gracz++;
                        }else{
                            gracz--;
                        }
                        if(gracz > ilosc_graczy-1){
                            gracz = gracz-ilosc_graczy;
                        } else if ( gracz < 0) {
                            gracz = ilosc_graczy-1;
                        }

                    }

                    if (wybrana_karta_wartosc.equals("+4")){
                        if(!reverse){
                            gracz++;
                        }else{
                            gracz--;
                        }

                        if(gracz > ilosc_graczy-1){
                            gracz = gracz-ilosc_graczy;
                        } else if ( gracz < 0) {
                            gracz = ilosc_graczy-1;
                        }

                        players.get(gracz).getKarty().add(pile.pop());
                        players.get(gracz).getKarty().add(pile.pop());
                        players.get(gracz).getKarty().add(pile.pop());
                        players.get(gracz).getKarty().add(pile.pop());

                    }

                    if (wybrana_karta_wartosc.equals("color switch")){
                        System.out.println("Jakiego koloru ma być ta karta?");
                        System.out.println("1. Red");
                        System.out.println("2. Green");
                        System.out.println("3. Blue");
                        System.out.println("4. Yellow");

                        while(!czyDobrze){
                            color_switch = Integer.valueOf(wild.nextLine());
                            if(color_switch <=4 && color_switch > 0 ){
                                czyDobrze = true;
                                switch (color_switch){
                                    case 1: wybrana_karta_nazwa = "Red";  wybrana_karta_wartosc = "wild"; break;
                                    case 2: wybrana_karta_nazwa = "Green";  wybrana_karta_wartosc = "wild"; break;
                                    case 3: wybrana_karta_nazwa = "Blue";  wybrana_karta_wartosc = "wild";  break;
                                    case 4: wybrana_karta_nazwa = "Yellow";  wybrana_karta_wartosc = "wild";    break;
                                }
                            } else {
                                czyDobrze = true;
                            }
                        }
                        czyDobrze = false;
                    }

                    if(!reverse){
                        gracz++;
                    } else {
                        gracz--;
                    }

                    obecna_karta = new Card(wybrana_karta_nazwa, wybrana_karta_wartosc);

                } else{
                    System.out.println("Niepoprawna karta, wybierz inną lub dobierz ze stosu");
                }
            }

            System.out.println("\n\n");

            if(pile.size() < 10){
                for(int i=0; i<5; i++){
                    random = (int) ((Math.random() * (stos_odrzuconych.size() - 0)) + 0);
                    pile.add(stos_odrzuconych.get(random));
                    // Jeżeli w stosie jest mniej niż 10 kart, dodaj na szczyt 5 losowych kart ze stosu odrzuconych.
                }
            }

            if(gracz > ilosc_graczy-1){
                gracz = 0;
            } else if ( gracz < 0) {
                gracz = ilosc_graczy-1;
            }

            for(int i = ilosc_graczy-1; i >= 0; i--){
                if(players.get(i).getKarty().size()==0){
                    System.out.println("WYGRYWA GRACZ: " + i+1);
                    exit(0);
                    // Zakończenie gry
                }
            }
        }
    }
}
