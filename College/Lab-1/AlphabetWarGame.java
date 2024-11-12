public class AlphabetWarGame {
    
    private int[] leftSideStrength;
    private int[] rightSideStrength;

    
    public AlphabetWarGame() {
        
        this.leftSideStrength = new int[26];
        this.rightSideStrength = new int[26];

        
        this.leftSideStrength['w' - 'a'] = 4; 
        this.leftSideStrength['p' - 'a'] = 3; 
        this.leftSideStrength['b' - 'a'] = 2; 
        this.leftSideStrength['s' - 'a'] = 1; 

        
        this.rightSideStrength['m' - 'a'] = 4;
        this.rightSideStrength['q' - 'a'] = 3; 
        this.rightSideStrength['d' - 'a'] = 2; 
        this.rightSideStrength['z' - 'a'] = 1; 
    }

    
    public String alphabetWar(String word) {
        int leftSideTotal = 0;
        int rightSideTotal = 0;

        
        for (char c : word.toCharArray()) {
            
            if (c == 'w' || c == 'p' || c == 'b' || c == 's') {
                leftSideTotal += leftSideStrength[c - 'a']; 
            }
            
            else if (c == 'm' || c == 'q' || c == 'd' || c == 'z') {
                rightSideTotal += rightSideStrength[c - 'a']; 
            }
        }

        
        if (leftSideTotal > rightSideTotal) {
            return "Left side wins!";
        } else if (rightSideTotal > leftSideTotal) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String[] args) {
        AlphabetWarGame game = new AlphabetWarGame();

       
        System.out.println(game.alphabetWar("z"));          
        System.out.println(game.alphabetWar("zdqmwpbs"));   
        System.out.println(game.alphabetWar("wwwwwwz"));    
    }
}
