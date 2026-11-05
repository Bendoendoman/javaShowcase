package testClasses;


public class splittingCharacters{
    private String word;
    private int number;

    public splittingCharacters(){
        
    }
    String split(String word, int charWhereSplit,Character whichWaySplit){
        String temp = " ";
        switch (whichWaySplit){
            case 'L':
                temp = word.substring(0,charWhereSplit);
                return temp;
            case 'R':
                temp = word.substring(charWhereSplit, word.length());
                return temp;
        }

        return temp;

    }
    String print(String word){
        System.out.println(word);
        return null;
    }

}
