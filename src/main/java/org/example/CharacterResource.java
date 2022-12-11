package org.example;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

public class CharacterResource implements ICharacterAttributes, ICharacters {
    private String characterName;
    private String hairColor;
    private String shirtColor;
    private String eyeColor;
    private boolean hasGlasses;
    private boolean isSmiling;
    private boolean wearsHat;

    private boolean isEliminated = false;

    public CharacterResource(String characterName, String hairColor, String shirtColor,
                             String eyeColor, boolean hasGlasses, boolean isSmiling,
                             boolean wearsHat){
        this.characterName = characterName;
        this.hairColor = hairColor;
        this.shirtColor = shirtColor;
        this.eyeColor = eyeColor;
        this.hasGlasses = hasGlasses;
        this.isSmiling = isSmiling;
        this.wearsHat = wearsHat;
    }

    public CharacterResource(){
    }

    public String getCharacterName(){
        return characterName;
    }

    public String getHairColor(){
        return hairColor;
    }

    public String getShirtColor(){
        return shirtColor;
    }

    public String getEyeColor(){
        return eyeColor;
    }

    public String doesCharacterHaveGlasses(){
        return (hasGlasses) ? "YES" : "NO";
    }

    public String isCharacterSmiling(){
        return (isSmiling) ? "YES" : "NO";
    }

    public String isCharacterWearingAHat(){
        return (wearsHat) ? "YES" : "NO";
    }

    public CharacterResource getCharacterByName(String characterName){
        for ( CharacterResource character : ICharacters.characters){
            if (characterName.equals(character.characterName)){
                return character;
            }
        }
        // returns null if character doesn't exist
        return null;
    }

    public boolean checkName(String characterName){
        for (String validCharacterName : validCharacterNames) {
            if (validCharacterName.equals(characterName)){
                return true;
            }
        }
        return false;
    }

    public String isEliminated(){
        return (isEliminated) ? "YES" : "NO";
    }

    public boolean checkHairColor(String hairColor){
        for (String validHairColor : validHairColors) {
            if (hairColor.equals(validHairColor)){
                return true;
            }
        }
        return false;
    }

    public boolean checkShirtColor(String shirtColor){
        for (String validShirtColor : validShirtColors) {
            if (shirtColor.equals(validShirtColor)){
                return true;
            }
        }
        return false;
    }

    public boolean checkEyeColor(String eyeColor){
        for (String validCEyeColor : validCEyeColors) {
            if (eyeColor.equals(validCEyeColor)){
                return true;
            }
        }
        return false;
    }

    public boolean checkCharacterAttribute(String attributeName, String attributeValue){
        checkCharacterAttributeName();
        checkCharacterAttributeValue();
    }

    public boolean checkCharacterAttributeName(String attributeName){
        if ()
    }
    public boolean checkCharacterAttributeValue(String attributeValue){
    }




}
