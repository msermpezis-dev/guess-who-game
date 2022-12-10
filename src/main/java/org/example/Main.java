package org.example;

public class Main {
    public static void main(String[] args) {

        CharacterResource[] characters = ICharacters.characters;
        BoardResource board = new BoardResource();
        boolean hasFirstPlayerChosenCorrectly = false;
        boolean hasSecondPlayerChosenCorrectly = false;
        CharacterResource firstPlayerChosenCharacter = null;
        CharacterResource secondPlayerChosenCharacter = null;


        board.showPlayerBoard(1);
        board.makePlayersChooseCharacter();

    }

}