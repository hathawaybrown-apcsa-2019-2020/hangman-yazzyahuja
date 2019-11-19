
/**
 * Plays Hangman!! Wow!!!!
 *
 * @author (Yasmin Ahuja)
 * @version (2019-11)
 */
public class HangmanGame
{
    // instance variables 
    private String secretWord;
    private String gameStatus;
    private String guessedLetters;

    /**
     * Constructor for objects of class HangmanGame
     */
    public HangmanGame(String word)
    {
        // initialise instance variables
        this.secretWord = word.toLowerCase();
        this.gameStatus = "";
        for(int n = 0; n < word.length(); n++)
        {
            if(Character.isLetter(secretWord.charAt(n)))
            {
                gameStatus += "-";
            }
            else
            {
                gameStatus += secretWord.charAt(n);
            }
        }
        this.guessedLetters = "";
    }

    /**
     * Returns all the letters that have been guessed
     *
     * @return    all the guessed letter
     */
    public String getTried()
    {
        return guessedLetters;
    }
    
    /**
     * Returns the status of the string
     *
     * @return    the status of the string
     */
    public String getGuessed()
    {
        return gameStatus;
    }
    
    /**
     * Looks for a character in guessed string and secret word
     *
     * @return    the status of the string
     */
    public int tryLetter(char a)
    {
        a = Character.toLowerCase(a);
        int b = guessedLetters.indexOf(a);
        int c = secretWord.indexOf(a);
        if(b == 1) // if character has already been guessed
        {
            return 0;
        }
        else if(c == -1) // if character is not in the string
        {
            guessedLetters += a;
            return -1;
        }
        else // if character is in the string
        {
            guessedLetters += a;
            for(int i = 0; i < secretWord.length(); i++)
            {
                if(a == secretWord.charAt(i))
                {
                    gameStatus = gameStatus.substring(0,i) + a + gameStatus.substring(i + 1);
                }
            }
        }
        return 1;
    }
}
