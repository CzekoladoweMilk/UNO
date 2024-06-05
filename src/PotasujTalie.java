
public class PotasujTalie extends Main{
    PotasujTalie(){
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

        sortpile.add(new Card("Red", "0"));
        sortpile.add(new Card("Green", "0"));
        sortpile.add(new Card("Blue", "0"));
        sortpile.add(new Card("Yellow", "0"));

        sortpile.add(new Card("Red", "skip"));
        sortpile.add(new Card("Red", "skip"));
        sortpile.add(new Card("Green", "skip"));
        sortpile.add(new Card("Green", "skip"));
        sortpile.add(new Card("Yellow", "skip"));
        sortpile.add(new Card("Yellow", "skip"));
        sortpile.add(new Card("Blue", "skip"));
        sortpile.add(new Card("Blue", "skip"));

        sortpile.add(new Card("Red", "reverse"));
        sortpile.add(new Card("Red", "reverse"));
        sortpile.add(new Card("Green", "reverse"));
        sortpile.add(new Card("Green", "reverse"));
        sortpile.add(new Card("Yellow", "reverse"));
        sortpile.add(new Card("Yellow", "reverse"));
        sortpile.add(new Card("Blue", "reverse"));
        sortpile.add(new Card("Blue", "reverse"));

        sortpile.add(new Card("Red", "+2"));
        sortpile.add(new Card("Red", "+2"));
        sortpile.add(new Card("Green", "+2"));
        sortpile.add(new Card("Green", "+2"));
        sortpile.add(new Card("Yellow", "+2"));
        sortpile.add(new Card("Yellow", "+2"));
        sortpile.add(new Card("Blue", "+2"));
        sortpile.add(new Card("Blue", "+2"));

        sortpile.add(new Card("wild", "+4"));
        sortpile.add(new Card("wild", "+4"));
        sortpile.add(new Card("wild", "+4"));
        sortpile.add(new Card("wild", "+4"));

        sortpile.add(new Card("wild", "color switch"));
        sortpile.add(new Card("wild", "color switch"));
        sortpile.add(new Card("wild", "color switch"));
        sortpile.add(new Card("wild", "color switch"));

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
