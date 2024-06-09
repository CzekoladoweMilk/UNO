import java.util.ArrayList;

public class PotasujTalie extends Main{
    PotasujTalie(){
        String[] typ = {"0","skip","reverse","+2","+4","color switch"};
        int random;
        Integer i = 1;

        while (sortpile.size() <= 71) {
            if (i > 9) {
                i = 1;
            }
            sortpile.add(new Card("Red", i.toString()));
            sortpile.add(new Card("Green", i.toString()));
            sortpile.add(new Card("Blue", i.toString()));
            sortpile.add(new Card("Yellow", i.toString()));
            i++;
        }

        i = 0;
        int k = 0;
        while (sortpile.size() <= 103){
            System.out.println(i);
            if(typ[i].equals("+4") || typ[i].equals("color switch")){
                sortpile.add(new Card("wild",typ[i]));
                sortpile.add(new Card("wild",typ[i]));
                sortpile.add(new Card("wild",typ[i]));
                sortpile.add(new Card("wild",typ[i]));
            }else{
                sortpile.add(new Card("Red",typ[i]));
                sortpile.add(new Card("Green",typ[i]));
                sortpile.add(new Card("Blue",typ[i]));
                sortpile.add(new Card("Yellow",typ[i]));
            }
            k++;
            if(i==0){
                k++;
            }
            if(k%2==0){
                i++;
            }
        }

        i=5;
        for(int l=0; l<=4;l++){
            sortpile.add(new Card("wild",typ[i]));
        }

        int j = 0;
        while(j<108){
            random = rand.nextInt(108);
            if(sortpile.get(random)==null){

            }
            else{
                pile.push(sortpile.get(random));
                sortpile.set(random, null);
                j++;
            }
        }
        System.out.println("Talia została przetasowana");
    }
}
