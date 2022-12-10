package org.example;

public class BoardResource implements ICharacters {

    private CharacterResource[] firstPlayerCharacters = ICharacters.characters;
    private CharacterResource[] secondPlayerCharacters = ICharacters.characters;
    private int turn = 1;


    public void showBoard(){
        System.out.println("Player 1 remaining characters:");
        for ( CharacterResource character : firstPlayerCharacters){
            if (character.)
            System.out.println(character.getCharacterName());
        }
        System.out.println("Player 2 remaining characters:");
        for ( CharacterResource character : secondPlayerCharacters){
            System.out.println(character.getCharacterName());
        }
    }
}
