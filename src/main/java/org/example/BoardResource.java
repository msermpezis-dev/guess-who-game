package org.example;

import java.util.Locale;
import java.util.Scanner;

public class BoardResource implements ICharacters {
    private CharacterResource[] playerOneBoard = ICharacters.characters;
    private CharacterResource[] playerTwoBoard = ICharacters.characters;
    private CharacterResource characterResource = new CharacterResource();
    private int turn = 1;
    CharacterResource firstPlayerChosenCharacter = null;
    CharacterResource secondPlayerChosenCharacter = null;


    public void showPlayerBoard(int playerNumber){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Player " + playerNumber +"'s board characters:");
        System.out.println("Eliminated\t|"  + " Character Attributes");
        if (playerNumber == 1) {
            printCharactersWithTheirAttributes(playerOneBoard);
        }
        else{
            printCharactersWithTheirAttributes(playerTwoBoard);
        }
    }

    public void printCharactersWithTheirAttributes(CharacterResource[] playerCharacters ){
        for ( CharacterResource character : playerCharacters ){
            String characterName = character.getCharacterName();
            String hairColor = character.getHairColor();
            String shirtColor = character.getShirtColor();
            String eyeColor = character.getEyeColor();
            String hasGlasses = character.doesCharacterHaveGlasses();
            String isSmiling = character.isCharacterSmiling();
            String wearsHat = character.isCharacterWearingAHat();
            String isEliminated = character.isEliminated();
            String characterDescription = "\t\t\t| " + characterName + ": " + hairColor + " Hair, " + shirtColor
                    + " Shirt, " + eyeColor + " Eyes, " + "hasGlasses : " + hasGlasses + ", " + "isSmiling : "
                    + isSmiling + ", " + "wearsHat : " + wearsHat;
            System.out.println(isEliminated + characterDescription);

        }

    }

    public void makePlayersChooseCharacter(){
        Scanner scanner = new Scanner(System.in);
        int playerNumber = 1;
        while (firstPlayerChosenCharacter == null || secondPlayerChosenCharacter == null){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Player " + playerNumber + " please a character from the list below");
            printCharactersWithTheirAttributes(ICharacters.characters);
            System.out.println("Please enter your chosen character's name: ");
            // Takes the string inputed by the player and removes whitespaces
            String playerChosenCharacter = scanner.nextLine().replaceAll("\\s", "");
            //  Uppercase the first letter and lowercase everything else
            playerChosenCharacter = playerChosenCharacter.substring(0,1).toUpperCase()
                    + playerChosenCharacter.substring(1).toLowerCase();
            boolean isChosenCharacterNameValid = characterResource.checkName(playerChosenCharacter);

            if (isChosenCharacterNameValid && playerNumber == 1){
                firstPlayerChosenCharacter = characterResource.getCharacterResourceByName(playerChosenCharacter);
                playerNumber++;
            } else if (isChosenCharacterNameValid && playerNumber == 2){
                secondPlayerChosenCharacter = characterResource.getCharacterResourceByName(playerChosenCharacter);
            }
            else {
                System.out.println("A character with the name " + playerChosenCharacter + "doesn't exist");
            }
        }
    }
}
