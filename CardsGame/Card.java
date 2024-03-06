import java.util.regex.*;

public class Card extends AbstractCard implements Comparable<AbstractCard>{

    public String card = "";
    char[] cardList={'2','3','4','5','6','7','8','9','J','Q','K','A','j','q','k','a'};
    char[] suitList={'D','C','H','S','d','c','h','s'};
    public Card(RANK rank, SUIT suit){
        // purpose: creates a card with given rank and suit
        // Note: If the rank is a joker then any suit can be passed
        // but the
            super(rank,suit);
            //this.rank = rank;
            //this.suit = suit;
            if (rank == RANK.NONE || suit == SUIT.NONE || rank == RANK.JOKER){
                card = "joker";
            }else{
            switch (rank){
                case TWO: card+="2";
                break;case THREE: card+="3";
                break;case FOUR: card+="4";
                break;case FIVE: card+="5";
                break;case SIX: card+="6";
                break;case SEVEN: card+="7";
                break;case EIGHT: card+="8";
                break;case NINE: card+="9";
                break;case TEN: card+="10";
                break;case JACK: card+="J";
                break;case QUEEN: card+="Q";
                break;case KING: card+="K";
                break;case ACE: card+="A";
                break;
                default: card="joker";
            }
    
            switch (suit) {
                case SPADES: card +="S";break;
                case CLUBS: card +="C";break;
                case HEARTS: card +="H";break;
                case DIAMONDS: card +="D";break;
                default:break;
            }
        }
    
    }
        public Card(String card){
            super(RANK.JOKER,SUIT.NONE);
            ranker(card);
            suiter(card);
            this.card = card;
    
            if (card.length() > 3 || card.length() < 2){
                this.card = "joker";
            }else{
                if(card.length() == 2 ){
    
                    if (cardChecker(card.charAt(0))){
                    if (suitChecker(card.charAt(1))){
                        this.card=this.card.toUpperCase();
                        
                    }else {
                        this.card = "joker";
                    }}else{
                        this.card = "joker";
                    }
                }else if (card.length() == 3){
                    if(card.substring(0, 2).equals("10")){
                    if (suitChecker(card.charAt(2))){
                        this.card=this.card.toUpperCase();
                    }
                    }else{
    
                        this.card = "joker";
                    }
                }else{this.card = "joker";}
            }
            }
        
    
        public boolean cardChecker(char letter){
            for (int i = 0; i < cardList.length ; i++){
                if (letter == cardList[i]){
                    return true;
                }
            }
            return false;
        }
        public boolean suitChecker(char letter){
    
            for (int i = 0; i < suitList.length ; i++){
                if (letter == suitList[i]){
                    return true;
                }
            }
            return false;
        }

    @Override
    public String toString(){

        return card;
    }

    @Override
    public int compareTo (AbstractCard other){
        int comparableCard = 0;
        int comparableSuit = 0;
        //System.out.println(other.getRank());
        switch (other.getRank()){
            case TWO: comparableCard=2;
            break;case THREE: comparableCard=3;
            break;case FOUR: comparableCard=4;
            break;case FIVE: comparableCard=5;
            break;case SIX: comparableCard=6;
            break;case SEVEN: comparableCard=7;
            break;case EIGHT: comparableCard=8;
            break;case NINE: comparableCard=9;
            break;case TEN: comparableCard=10;
            break;case JACK: comparableCard=11;
            break;case QUEEN: comparableCard=12;
            break;case KING: comparableCard=13;
            break;case ACE: comparableCard=14;
            break;case JOKER: comparableCard=15;
            break;case NONE: comparableCard=16;break;
            default: break;
        }
        switch (other.getSuit()) {
            case SPADES: comparableSuit =4;break;
            case CLUBS: comparableSuit =2;break;
            case HEARTS: comparableSuit =3;break;
            case DIAMONDS: comparableSuit =1;break;
            case NONE: comparableSuit=5;break;
            default:break;
        }
        if (card.length() ==2 ){
            if ((suitNumber(card.substring(1, 2)) - comparableSuit) == 0){
                return rankNumber(card.substring(0,1)) - comparableCard;

        }
        }else if (card.length() > 2){
            if (other.getRank() == RANK.JOKER){
                return -1;
            }else{
                if ((suitNumber(card.substring(2, 3)) - comparableSuit) == 0){
                    return rankNumber(card.substring(0,2)) - comparableCard;
                }else{
                    return suitNumber(card.substring(2, 3)) - comparableSuit;
            }}
        }
        return suitNumber(card.substring(1, 2)) - comparableSuit;
    
    
}
    

        public int suitNumber (String suit){
            switch (suit) {
                case "S": return 4;
                case "C": return 2;
                case "H": return 3;
                case "D": return 1;
                default:break;
            } 
            return 10;
        }public int rankNumber (String suit){
            switch(suit){
                case "2": return 2;
                case "3": return 3;
                case "4": return 4;
                case "5": return 5;
                case "6": return 6;
                case "7": return 7;
                case "8": return 8;
                case "9": return 9;
                case "10": return 10;
                case "J": return 11;
                case "Q": return 12;
                case "K": return 13;
                case "A": return 14;
                case "joker": return 15;
                default:break;
        }
        return 0;
    }



    public void ranker(String card){
            
        if (card.length() == 2){
        switch(card.toUpperCase().charAt(0)){
            case '2': super.rank = RANK.TWO;break;
            case '3': super.rank =  RANK.THREE;break;
            case '4': super.rank =  RANK.FOUR;break;
            case '5': super.rank =  RANK.FIVE;break;
            case '6': super.rank =  RANK.SIX;break;
            case '7': super.rank =  RANK.SEVEN;break;
            case '8': super.rank =  RANK.EIGHT;break;
            case '9': super.rank =  RANK.NINE;break;
            case 'J': super.rank =  RANK.JACK;break;
            case 'Q': super.rank =  RANK.QUEEN;break;
            case 'K': super.rank =  RANK.KING;break;
            case 'A': super.rank =  RANK.ACE;break;
            default:break;
        }
        if (card.equals("joker")){
            super.rank = RANK.JOKER;
        }
        
    }else if (card.length() == 3){
        super.rank = RANK.TEN;
    }
}
    public void suiter(String card){
        if (card.length() == 2){ 
            switch (card.toUpperCase().charAt(1)) {
                case 'S': super.suit = SUIT.SPADES;break;
                case 'C': super.suit =  SUIT.CLUBS;break;
                case 'H': super.suit =  SUIT.HEARTS;break;
                case 'D': super.suit =  SUIT.DIAMONDS;break;
                default: super.suit =  SUIT.NONE;break;
            }
        

    }else{
        switch (card.toUpperCase().charAt(2)) {
            case 'S': super.suit = SUIT.SPADES;break;
            case 'C': super.suit =  SUIT.CLUBS;break;
            case 'H': super.suit =  SUIT.HEARTS;break;
            case 'D': super.suit =  SUIT.DIAMONDS;break;
            default: super.suit =  SUIT.NONE;break;
        }
    }
}
}
