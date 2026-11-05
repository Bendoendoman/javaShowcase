package testClasses;

public class printingTwice extends splittingCharacters{

    public printingTwice(){
        super();
    }
    @Override
    String print(String word){
        super.print(word + word);
        return null;
        
    }
    
    
}
