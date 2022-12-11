package org.example;

import java.util.Locale;
import java.util.Scanner;

public class BoardResource implements ICharacters {
    private CharacterResource[] playerOneBoard = ICharacters.characters;
    private CharacterResource[] playerTwoBoard = ICharacters.characters;
    private CharacterResource characterResource = new CharacterResource();
    private int turnCounter = 1;
    CharacterResource firstPlayerChosenCharacter = null;
    CharacterResource secondPlayerChosenCharacter = null;
    boolean hasFirstPlayerChosenCorrectly = false;
    boolean hasSecondPlayerChosenCorrectly = false;
    boolean restartGameChoice = false;


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

        int playerNumber = 1;
        while (firstPlayerChosenCharacter == null || secondPlayerChosenCharacter == null){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Player " + playerNumber + " please a character from the list below");
            printCharactersWithTheirAttributes(ICharacters.characters);
            System.out.println("Please enter your chosen character's name: ");

            String playerChosenCharacter = askPlayerForStringInputAndConvertFormat();
            boolean isChosenCharacterNameValid = characterResource.checkName(playerChosenCharacter);

            if (isChosenCharacterNameValid && playerNumber == 1){
                firstPlayerChosenCharacter = characterResource.getCharacterByName(playerChosenCharacter);
                playerNumber++;
            } else if (isChosenCharacterNameValid && playerNumber == 2){
                secondPlayerChosenCharacter = characterResource.getCharacterByName(playerChosenCharacter);
            }
            else {
                System.out.println("A character with the name " + playerChosenCharacter + "doesn't exist");
            }
        }
    }

    public String askPlayerForStringInputAndConvertFormat(){
        Scanner scanner = new Scanner(System.in);
        // Takes the string inputted by the player, removes whitespaces,
        // then uppercase the first letter and lowercase everything else
        String playerInput = scanner.nextLine().replaceAll("\\s", "");
        playerInput = playerInput.substring(0,1).toUpperCase() + playerInput.substring(1).toLowerCase();
        return playerInput;
    }

    public int askPlayerForNumberInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void askPlayerForACharacterAttribute(int playerNumber){
        int characterAttributeNameID = askCharacterAttributeName();
        String characterAttributeValue;askCharacterAttributeValue(characterAttributeNameID);
        //TODO
    }

    public int askCharacterAttributeName(){
        int playerNumberInput = 0;
        while (playerNumberInput <= 0 && playerNumberInput > 7 ){
            System.out.println("Please pick an attribute name based on its number from the list below:");
            System.out.println("1. Name \t2. Hair Color \t3. T-shirt Color \t4. Eye Color" +
                    "\t5. Glasses \t6. Smile \t 7. Hat");
            playerNumberInput = askPlayerForNumberInput();
        }
        return playerNumberInput;
    }

    public String askCharacterAttributeValue(int characterAttributeNameID){
        String playerInput = null;
        switch (characterAttributeNameID) {
            case 1:
                while (!characterResource.checkName(playerInput)){
                    System.out.println("Please select a Name from your above board: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case 2:
                while (!characterResource.checkHairColor(playerInput)){
                    System.out.println("Please select a Hair Color from your above board: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case 3:
                while (!characterResource.checkShirtColor(playerInput)){
                    System.out.println("Please select a T-Shirt Color from your above board: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case 4:
                while (!characterResource.checkEyeColor(playerInput)){
                    System.out.println("Please select an Eye Color from your above board: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case 5:
                while (!("Yes".equals(playerInput) || "No".equals(playerInput))){
                    System.out.println("Please select Yes or No depending if the character has Glasses: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case 6:
                while (!("Yes".equals(playerInput) || "No".equals(playerInput))){
                    System.out.println("Please select Yes or No depending if the character is Smiling: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case 7:
                while (!("Yes".equals(playerInput) || "No".equals(playerInput))){
                    System.out.println("Please select Yes or No depending if the character has a Hat: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            default:
                System.out.println("Input " + characterAttributeNameID + " is invalid");
                return null;
        }
    }
    public void startGame(){
        makePlayersChooseCharacter();
        while (!hasFirstPlayerChosenCorrectly || !hasSecondPlayerChosenCorrectly ){
            startNewTurnForPlayer(1);
            startNewTurnForPlayer(2);
        }
    }

    public void startNewTurnForPlayer(int playerNumber){
        System.out.println("Turn " + turnCounter);
        askPlayerForACharacterAttribute(playerNumber);
    }
}
