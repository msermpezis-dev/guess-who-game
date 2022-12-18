package org.guesswhogame;

import java.util.Scanner;

/*
    The boardResource is responsible for managing all the components and running the game
 */
public class BoardResource implements IBoardResource {
    private CharacterResource[] playerOneBoardCharacters = new CharacterResource[IBoardResource.characters.length];
    private CharacterResource[] playerTwoBoardCharacters = new CharacterResource[IBoardResource.characters.length];
    private final CharacterResource characterResource = new CharacterResource();
    private PlayerResource playerOne = new PlayerResource();
    private PlayerResource playerTwo = new PlayerResource();
    private int turnCounter = 1;
    private boolean isAnyPlayerCorrect = false;

    // The constructor copies the characters from ICharacters to player one and two's boards
    public BoardResource(){
        for (int i = 0; i <= IBoardResource.characters.length - 1; i++){
            playerOneBoardCharacters[i] = new CharacterResource(IBoardResource.characters[i]);
            playerTwoBoardCharacters[i] = new CharacterResource(IBoardResource.characters[i]);
        }
    }


    // startGame method is responsible for the functionality of the game from start to end
    public void startGame(){
        askPlayersToChooseACharacter();
        while (!isAnyPlayerCorrect){
            startNewTurn();
            endCurrentPlayerTurn();
        }
        congratulateWinner();
    }

    private void startNewTurn(){
        showPlayerBoard();
        // characterAttribute is an array of 2 values, that is basically a key/value combination
        // [0] is the name of the attribute and [1] the value of the attribute
        String[] characterAttribute = askForACharacterAttribute();
        checkCurrentPlayerAndEliminateCharacters(characterAttribute);
    }

    // at the end of every turn, the variable for keeping track of whose turn is, changes accordingly to the last player
    private void endCurrentPlayerTurn(){
        if (playerOne.getIsItThisPlayersTurn()) {
            playerOne.setIsItThisPlayersTurn(false);
            playerTwo.setIsItThisPlayersTurn(true);
        } else if (playerTwo.getIsItThisPlayersTurn()) {
            playerTwo.setIsItThisPlayersTurn(false);
            playerOne.setIsItThisPlayersTurn(true);
        }
        turnCounter++;
    }

    private void congratulateWinner(){
        if (playerOne.getIsPlayerCorrect()){
            System.out.println("================================================================================");
            System.out.println("CONGRATULATIONS PLAYER ONE! YOU HAVE CORRECTLY GUESSED YOUR OPPONENT'S CHARACTER");
            System.out.println("================================================================================");
        } else if (playerTwo.getIsPlayerCorrect()) {
            System.out.println("================================================================================");
            System.out.println("CONGRATULATIONS PLAYER TWO! YOU HAVE CORRECTLY GUESSED YOUR OPPONENT'S CHARACTER");
            System.out.println("================================================================================");
        }
    }

    private void checkCurrentPlayerAndEliminateCharacters(String[] characterAttribute) {
        if (playerOne.getIsItThisPlayersTurn()) {
            eliminateCharacters(characterAttribute, playerOneBoardCharacters, playerTwo.getChosenCharacter());
        }
        else if (playerTwo.getIsItThisPlayersTurn()) {
            eliminateCharacters(characterAttribute, playerTwoBoardCharacters, playerOne.getChosenCharacter());
        }
    }

    // sets the isEliminated variable as true depending on the guess the player has made
    private void eliminateCharacters(String[] characterAttribute, CharacterResource[] playerBoardCharacters,
                                     CharacterResource ChosenCharacter){

        // first tries to eliminate characters assuming the guess was correct
        boolean isGuessCorrect = eliminateForCorrectGuess(characterAttribute, playerBoardCharacters, ChosenCharacter);
        // if the above assumption was wrong eliminates characters assuming the guess was wrong
        if (!isGuessCorrect){
            eliminateForWrongGuess(characterAttribute, playerBoardCharacters, ChosenCharacter);
            System.out.println("Your guess was WRONG!");
        } else {
            System.out.println("Your guess was CORRECT!");
        }
    }

    private boolean eliminateForCorrectGuess(String[] characterAttribute, CharacterResource[] playerBoardCharacters,
                                     CharacterResource ChosenCharacter) {
        // if the guess was correct, meaning that the player has chosen an attribute that the enemy player's
        // chosen character has, then eliminates the characters that don't have that attribute
        // returns true/false to indicate that eliminateForWrongGuess method can be skipped or not
        if ("characterName".equals(characterAttribute[0]) &&
                ChosenCharacter.getCharacterName().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "characterName".equals(characterAttribute[0]) &&
                        !character.getCharacterName().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                    return true;
                }
            }
        } else if ("hairColor".equals(characterAttribute[0]) &&
                ChosenCharacter.getHairColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "hairColor".equals(characterAttribute[0]) &&
                        !character.getHairColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                    return true;
                }
            }
        } else if ("shirtColor".equals(characterAttribute[0]) &&
                ChosenCharacter.getShirtColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "shirtColor".equals(characterAttribute[0]) &&
                        !character.getShirtColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                    return true;
                }
            }
        } else if ("eyeColor".equals(characterAttribute[0]) &&
                ChosenCharacter.getEyeColor().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "eyeColor".equals(characterAttribute[0]) &&
                        !character.getEyeColor().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                    return true;
                }
            }
        } else if ("hasGlasses".equals(characterAttribute[0]) &&
                ChosenCharacter.doesCharacterHaveGlasses().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "hasGlasses".equals(characterAttribute[0]) &&
                        !character.doesCharacterHaveGlasses().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                    return true;
                }
            }
        } else if ("isSmiling".equals(characterAttribute[0]) &&
                ChosenCharacter.isCharacterSmiling().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "isSmiling".equals(characterAttribute[0]) &&
                        !character.isCharacterSmiling().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                    return true;
                }
            }
        } else if ("wearsHat".equals(characterAttribute[0]) &&
                ChosenCharacter.isCharacterWearingAHat().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "wearsHat".equals(characterAttribute[0]) &&
                        !character.isCharacterWearingAHat().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                    return true;
                }
            }
        }
        return false;
    }

    private void eliminateForWrongGuess(String[] characterAttribute, CharacterResource[] playerBoardCharacters,
                                     CharacterResource ChosenCharacter) {
        // if the guess has negative result, meaning that the player has chosen an attribute that the enemy player's
        // chosen character has, then eliminates the characters that have that attribute
        if ("characterName".equals(characterAttribute[0]) &&
                !ChosenCharacter.getCharacterName().toLowerCase().equals(characterAttribute[1])
        ) {
            for (CharacterResource character : playerBoardCharacters) {
                if( "characterName".equals(characterAttribute[0]) &&
                        character.getCharacterName().toLowerCase().equals(characterAttribute[1])){
                    character.setEliminated(true);
                }
            }
        } else if ("hairColor".equals(characterAttribute[0]) &&
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

    // checks if the player has guessed correctly its opponent's chosen character
    private void checkCurrentGuess(String characterNameGuess){
        String playerOneCharacterName = playerOne.getChosenCharacter().getCharacterName().toLowerCase();
        String playerTwoCharacterName = playerTwo.getChosenCharacter().getCharacterName().toLowerCase();

        if (playerOne.getIsItThisPlayersTurn() && playerTwoCharacterName.equals(characterNameGuess)){
            playerOne.setIsPlayerCorrect(true);
            isAnyPlayerCorrect = true;
        } else if (playerTwo.getIsItThisPlayersTurn() && playerOneCharacterName.equals(characterNameGuess)) {
            playerTwo.setIsPlayerCorrect(true);
            isAnyPlayerCorrect = true;
        }
    }

    private void showPlayerBoard(){
        System.out.println("\n\nTurn " + turnCounter);
        if (playerOne.getIsItThisPlayersTurn()) {
            System.out.println("Player One's remaining board characters:");
            System.out.println("Eliminated\t|"  + " Character Attributes");
            printRemainingCharacters(playerOneBoardCharacters);
        }
        else if (playerTwo.getIsItThisPlayersTurn()){
            System.out.println("Player Two's board characters:");
            System.out.println("Eliminated\t|"  + " Character Attributes");
            printRemainingCharacters(playerTwoBoardCharacters);
        }
    }

    private void printCharactersWithTheirAttributes(){
        System.out.printf("%-10s| %-11s| %-12s| %-10s| %-11s| %-10s| %-10s %n", "Name", "Hair Color",
                "Shirt Color", "Eye Color", "hasGlasses", "isSmiling", "wearsHat");
        System.out.println("------------------------------------------------------------------------------------");
        for ( CharacterResource character : IBoardResource.characters ){
            String characterName = character.getCharacterName();
            String hairColor = character.getHairColor();
            String shirtColor = character.getShirtColor();
            String eyeColor = character.getEyeColor();
            String hasGlasses = character.doesCharacterHaveGlasses();
            String isSmiling = character.isCharacterSmiling();
            String wearsHat =  character.isCharacterWearingAHat();
            String characterDescription = "%-10s| %-11s| %-12s| %-10s| %-11s| %-10s| %-10s %n";
            System.out.printf(characterDescription, characterName, hairColor, shirtColor, eyeColor, hasGlasses,
                    isSmiling, wearsHat);
        }
    }

    private void printRemainingCharacters(CharacterResource[] playerCharacters ){
        System.out.printf("%-10s| %-11s| %-12s| %-10s| %-11s| %-10s| %-10s %n", "Name", "Hair Color",
                "Shirt Color", "Eye Color", "hasGlasses", "isSmiling", "wearsHat");
        System.out.println("------------------------------------------------------------------------------------");
        for ( CharacterResource character : playerCharacters ){
            String characterName = character.getCharacterName();
            String hairColor = character.getHairColor();
            String shirtColor = character.getShirtColor();
            String eyeColor = character.getEyeColor();
            String hasGlasses = character.doesCharacterHaveGlasses();
            String isSmiling = character.isCharacterSmiling();
            String wearsHat =  character.isCharacterWearingAHat();
            String characterDescription = "%-10s| %-11s| %-12s| %-10s| %-11s| %-10s| %-10s %n";
            if (!character.getIsEliminated()){
                System.out.printf(characterDescription, characterName, hairColor, shirtColor, eyeColor, hasGlasses,
                        isSmiling, wearsHat);
            }
        }
    }

    // creates a loop the ends only when the 2 players have selected a character as their chosen character
    private void askPlayersToChooseACharacter(){
        System.out.println("Board with all available characters.");
        printCharactersWithTheirAttributes();
        while (playerOne.getChosenCharacter() == null || playerTwo.getChosenCharacter() == null){

            if (!playerOne.getIsItThisPlayersTurn()){
                System.out.println("\nPlayer One please a character name from the list above: ");
            } else if (!playerTwo.getIsItThisPlayersTurn()) {
                System.out.println("\nPlayer Two please a character name from the list above: ");
            }

            String playerChosenCharacterName = askPlayerForStringInputAndConvertFormat();
            boolean isChosenCharacterNameValid = characterResource.checkName(playerChosenCharacterName);

            if (isChosenCharacterNameValid && !playerOne.getIsItThisPlayersTurn()){
                playerOne.setIsItThisPlayersTurn(true);
                playerOne.setChosenCharacterByName(playerChosenCharacterName);
                System.out.println("\n\n\n\n");
                System.out.println("Board with all available characters.");
                printCharactersWithTheirAttributes();
            } else if (isChosenCharacterNameValid && !playerTwo.getIsItThisPlayersTurn()){
                playerTwo.setChosenCharacterByName(playerChosenCharacterName);
            }
            else {
                System.out.println("A character with the name '" + playerChosenCharacterName + "' doesn't exist!");
            }
        }
    }

    private String askPlayerForStringInputAndConvertFormat(){
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.nextLine().replaceAll("\\s", "");
        playerInput = playerInput.toLowerCase();
        return playerInput;
    }

    private int askPlayerForChoiceInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("\\s", "");
        while ( !checkIfChoiceIsValid(input) ){
            input = scanner.nextLine().replaceAll("\\s", "");;
        }
        return Integer.parseInt(input);
    }
    private boolean checkIfChoiceIsValid(String selectionNumber){
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
                System.out.println("You have entered an invalid option!");
                return false;
        }
    }

    // ask player for the characterAttributeName and characterAttributeValue for their turn's guess
    private String[] askForACharacterAttribute(){
        String characterAttributeName = askCharacterAttributeName();
        String characterAttributeValue = askCharacterAttributeValue(characterAttributeName);
        return new String[]{characterAttributeName, characterAttributeValue};
    }

    private String askCharacterAttributeName(){
        int playerNumberInput;
        System.out.println("\nPlease pick the NUMBER that corresponds to the attribute name from the list below:");
        System.out.println("1. Name \t2. Hair Color \t3. T-shirt Color \t4. Eye Color" +
                "\t5. Glasses \t6. Smile \t 7. Hat");
        playerNumberInput = askPlayerForChoiceInput();

        return convertChoiceToAttributeName(playerNumberInput);
    }

    private String convertChoiceToAttributeName(int playerNumberInput){
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

    // asks player for an attribute value based on the player's choice
    private String askCharacterAttributeValue(String characterAttributeName){
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
                    System.out.println("Please select a Hair Color from the list below: ");
                    System.out.println("Available Hair Colors: brown, blond, red, black");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "shirtColor":
                while (!characterResource.checkShirtColor(playerInput)){
                    System.out.println("Please select a T-Shirt Color from your above board: ");
                    System.out.println("Available Hair Colors: black, white, yellow, green");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "eyeColor":
                while (!characterResource.checkEyeColor(playerInput)){
                    System.out.println("Please select an Eye Color from your above board: ");
                    System.out.println("Available Hair Colors: brown, blue, green");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "hasGlasses":
                while (!("yes".equals(playerInput) || "no".equals(playerInput))){
                    System.out.println("Please select 'yes' or 'no' depending if the character has Glasses: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "isSmiling":
                while (!("yes".equals(playerInput) || "no".equals(playerInput))){
                    System.out.println("Please select 'yes' or 'no' depending if the character is Smiling: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            case "wearsHat":
                while (!("yes".equals(playerInput) || "no".equals(playerInput))){
                    System.out.println("Please select 'yes' or 'no' depending if the character has a Hat: ");
                    playerInput = askPlayerForStringInputAndConvertFormat();
                }
                return playerInput;
            default:
                System.out.println("Input " + characterAttributeName + " is invalid");
                return null;
        }
    }
}
