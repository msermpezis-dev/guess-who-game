package org.example;

public class BoardResource implements ICharacters {

    private CharacterResource[] firstPlayerCharacters = ICharacters.characters;
    private CharacterResource[] secondPlayerCharacters = ICharacters.characters;
    private int turn = 1;

}
