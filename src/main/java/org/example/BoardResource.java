package org.example;

import java.util.Locale;
import java.util.Scanner;

public class BoardResource implements ICharacters {
    private CharacterResource[] playerOneBoardCharacters = new CharacterResource[ICharacters.characters.length];
    private CharacterResource[] playerTwoBoardCharacters = new CharacterResource[ICharacters.characters.length];
    private final CharacterResource characterResource = new CharacterResource();
    CharacterResource PlayerOneChosenCharacter;
    CharacterResource PlayerTwoChosenCharacter;
    private int turnCounter = 1;
    private int currentPlayerID = 1;
    boolean hasPlayerOneChosenCorrectly = false;
    boolean hasPlayerTwoChosenCorrectly = false;
    boolean hasAnyPlayerHasChosenCorrectly = false;
    boolean restartGameChoice = false;

    public BoardResource(){
        for (int i = 0; i <= ICharacters.characters.length - 1; i++){
            playerOneBoardCharacters[i] = new CharacterResource(ICharacters.characters[i]);
            playerTwoBoardCharacters[i] = new CharacterResource(ICharacters.characters[i]);
        }
    }
    public void startGame(){
        // TODO refine prints
        // TODO maybe refine nested ifs
        makePlayersChooseCharacter();
        while (!hasPlayerOneChosenCorrectly || !hasPlayerTwoChosenCorrectly  && !hasAnyPlayerHasChosenCorrectly){
            startNewTurn();
            endCurrentPlayerTurn();
        }
        congratulateWinner();
    }

    public void startNewTurn(){
        System.out.println("Turn " + turnCounter);
        showPlayerBoard();
        String[] characterAttribute = askForACharacterAttribute();
        checkCurrentPlayerAndEliminateCharacters(characterAttribute);
    }

    private void checkCurrentPlayerAndEliminateCharacters(String[] characterAttribute) {
        if (currentPlayerID == 1) {
            eliminateCharactersWithoutInputAttributes(characterAttribute, playerOneBoardCharacters, PlayerTwoChosenCharacter);
        }
        else if (currentPlayerID == 2) {
            eliminateCharactersWithoutInputAttributes(characterAttribute, playerTwoBoardCharacters, PlayerOneChosenCharacter);
        }
    }

    private void eliminateCharactersWithoutInputAttributes(String[] characterAttribute,
                                                           CharacterResource[] playerBoardCharacters,
                                                           CharacterResource ChosenCharacter){
        // if questions has positive result
        if ("hairColor".equals(characterAttribute[0]) &&
                ChosenCharacter.getHairColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "hairColor".equals(characterAttribute[0]) &&
                        !character.getHairColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("shirtColor".equals(characterAttribute[0]) &&
                ChosenCharacter.getShirtColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "shirtColor".equals(characterAttribute[0]) &&
                        !character.getShirtColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("eyeColor".equals(characterAttribute[0]) &&
                ChosenCharacter.getEyeColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "eyeColor".equals(characterAttribute[0]) &&
                        !character.getEyeColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("hasGlasses".equals(characterAttribute[0]) &&
                ChosenCharacter.doesCharacterHaveGlasses().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "hasGlasses".equals(characterAttribute[0]) &&
                        !character.doesCharacterHaveGlasses().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("isSmiling".equals(characterAttribute[0]) &&
                ChosenCharacter.isCharacterSmiling().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "isSmiling".equals(characterAttribute[0]) &&
                        !character.isCharacterSmiling().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("wearsHat".equals(characterAttribute[0]) &&
                ChosenCharacter.isCharacterWearingAHat().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "wearsHat".equals(characterAttribute[0]) &&
                        !character.isCharacterWearingAHat().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        }

        
        // if questions has negative result
        if ("hairColor".equals(characterAttribute[0]) &&
                !ChosenCharacter.getHairColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "hairColor".equals(characterAttribute[0]) &&
                        character.getHairColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("shirtColor".equals(characterAttribute[0]) &&
                !ChosenCharacter.getShirtColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "shirtColor".equals(characterAttribute[0]) &&
                        character.getShirtColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("eyeColor".equals(characterAttribute[0]) &&
                !ChosenCharacter.getEyeColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "eyeColor".equals(characterAttribute[0]) &&
                        character.getEyeColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("hasGlasses".equals(characterAttribute[0]) &&
                !ChosenCharacter.doesCharacterHaveGlasses().toLowerCase().equals(characterAttribute[1])
        ) {

            for (CharacterResource character : playerBoardCharacters) {
                if( "hasGlasses".equals(characterAttribute[0]) &&
                        character.doesCharacterHaveGlasses().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("isSmiling".equals(characterAttribute[0]) &&
                !ChosenCharacter.isCharacterSmiling().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "isSmiling".equals(characterAttribute[0]) &&
                        character.isCharacterSmiling().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("wearsHat".equals(characterAttribute[0]) &&
                !ChosenCharacter.isCharacterWearingAHat().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "wearsHat".equals(characterAttribute[0]) &&
                        character.isCharacterWearingAHat().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        }
    }

    public void endCurrentPlayerTurn(){
        switch (currentPlayerID){
            case 1:
                currentPlayerID = 2;
                break;
            case 2:
                currentPlayerID = 1;
                break;
            default:
                System.out.println("Unexpected player ID");
        }
        turnCounter++;
    }

    public void congratulateWinner(){
        if (hasPlayerOneChosenCorrectly){
            System.out.println("CONGRATULATIONS PLAYER ONE! YOU HAVE CORRECTLY GUESSED YOUR OPPONENT'S CHARACTER");
        } else if (hasPlayerTwoChosenCorrectly) {
            System.out.println("CONGRATULATIONS PLAYER TWO! YOU HAVE CORRECTLY GUESSED YOUR OPPONENT'S CHARACTER");
        }
    }

    public void checkCurrentGuess(String characterNameGuess){
        String playerOneCharacterName = PlayerOneChosenCharacter.getCharacterName().toLowerCase();
        String playerTwoCharacterName = PlayerTwoChosenCharacter.getCharacterName().toLowerCase();

        if (currentPlayerID == 1 && playerTwoCharacterName.equals(characterNameGuess)){
            hasPlayerOneChosenCorrectly = true;
            hasAnyPlayerHasChosenCorrectly = true;
        } else if (currentPlayerID == 2 && playerOneCharacterName.equals(characterNameGuess)) {
            hasPlayerOneChosenCorrectly = true;
            hasAnyPlayerHasChosenCorrectly = true;
        }
    }

    public void showPlayerBoard(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Player " + currentPlayerID +"'s board characters:");
        System.out.println("Eliminated\t|"  + " Character Attributes");
        if (currentPlayerID == 1) {
            printCharactersWithTheirAttributes(playerOneBoardCharacters);
        }
        else if (currentPlayerID == 2){
            printCharactersWithTheirAttributes(playerTwoBoardCharacters);
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
        while (playerNumber <= 2){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            printCharactersWithTheirAttributes(ICharacters.characters);
            System.out.println("Player " + playerNumber + " please a character name from the list above");

            String playerChosenCharacter = askPlayerForStringInputAndConvertFormat();
            boolean isChosenCharacterNameValid = characterResource.checkName(playerChosenCharacter);

            if (isChosenCharacterNameValid && playerNumber == 1){
                PlayerOneChosenCharacter = characterResource.getCharacterByName(playerChosenCharacter);
                playerNumber++;
            } else if (isChosenCharacterNameValid && playerNumber == 2){
                PlayerTwoChosenCharacter = characterResource.getCharacterByName(playerChosenCharacter);
                playerNumber++;
            }
            else {
                System.out.println("A character with the name " + playerChosenCharacter + "doesn't exist");
            }
        }
    }

    public String askPlayerForStringInputAndConvertFormat(){
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.nextLine().replaceAll("\\s", "");
        playerInput = playerInput.toLowerCase();
        return playerInput;
    }

    public int askPlayerForNumberInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while ( !checkIfStringIsValid(input) ){
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }
    public boolean checkIfStringIsValid(String selectionNumber){
        // valid options are number 1-7
        switch (selectionNumber){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
                return true;
            default:
                System.out.println("You have entered an invalid value");
                return false;
        }
    }

    public String[] askForACharacterAttribute(){
        String characterAttributeName = askCharacterAttributeName();
        String characterAttributeValue = askCharacterAttributeValue(characterAttributeName);
        String[] characterAttributeNameAndValue = {characterAttributeName, characterAttributeValue};
        return characterAttributeNameAndValue;
    }

    public String askCharacterAttributeName(){
        int playerNumberInput;
        System.out.println("Please pick an attribute name based on its number from the list below:");
        System.out.println("1. Name \t2. Hair Color \t3. T-shirt Color \t4. Eye Color" +
                "\t5. Glasses \t6. Smile \t 7. Hat");
        playerNumberInput = askPlayerForNumberInput();

        return convertInputToAttributeName(playerNumberInput);
    }

    public String convertInputToAttributeName(int playerNumberInput){
        switch (playerNumberInput){
            case 1:
                return "characterName";
            case 2:
                return "hairColor";
            case 3:
                return "shirtColor";
            case 4:
                return "eyeColor";
            case 5:
                return "hasGlasses";
            case 6:
                return "isSmiling";
            case 7:
                return "wearsHat";
            default:
                return null;
        }
    }

    public String askCharacterAttributeValue(String characterAttributeName){
        String playerInput = "";
        switch (characterAttributeName) {
            case "characterName":
                while (!characterResource.checkName(playerInput)){
                    System.out.println("Please select a Name from your above board: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                    checkCurrentGuess(playerInput);
                }
                return playerInput;
            case "hairColor":
                while (!characterResource.checkHairColor(playerInput)){
                    System.out.println("Please select a Hair Color from your above board: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "shirtColor":
                while (!characterResource.checkShirtColor(playerInput)){
                    System.out.println("Please select a T-Shirt Color from your above board: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "eyeColor":
                while (!characterResource.checkEyeColor(playerInput)){
                    System.out.println("Please select an Eye Color from your above board: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "hasGlasses":
                while (!("yes".equals(playerInput) || "no".equals(playerInput))){
                    System.out.println("Please select Yes or No depending if the character has Glasses: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "isSmiling":
                while (!("yes".equals(playerInput) || "no".equals(playerInput))){
                    System.out.println("Please select Yes or No depending if the character is Smiling: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "wearsHat":
                while (!("yes".equals(playerInput) || "no".equals(playerInput))){
                    System.out.println("Please select Yes or No depending if the character has a Hat: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            default:
                System.out.println("Input " + characterAttributeName + " is invalid");
                return null;
        }
    }

}
