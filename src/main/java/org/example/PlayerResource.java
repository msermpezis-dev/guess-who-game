package org.example;

/**
 * @author msermpezis-dev
 * @project guess-who-game
 * @created 1:04 μ.μ. - 17/12/2022
 */
public class PlayerResource {

     private CharacterResource playerChosenCharacter;

    private boolean isPlayerCorrect;

    private boolean isItThisPlayersTurn;

    public PlayerResource(){
        this.isPlayerCorrect = false;
        this.isItThisPlayersTurn = false;
    }

    public void setChosenCharacterByName(String characterName){
        this.playerChosenCharacter = new CharacterResource(
                new CharacterResource().getCharacterByName(characterName));
    }

    public CharacterResource getChosenCharacter(){
        return playerChosenCharacter;
    }

    public boolean getIsItThisPlayersTurn(){
        return isItThisPlayersTurn;
    }

    public void setIsItThisPlayersTurn(boolean isItThisPlayersTurn){
        this.isItThisPlayersTurn = isItThisPlayersTurn;

    }

    public boolean getIsPlayerCorrect(){
        return isPlayerCorrect;
    }

    public void setIsPlayerCorrect(boolean isPlayerCorrect){
        this.isPlayerCorrect = isPlayerCorrect;

    }
}
