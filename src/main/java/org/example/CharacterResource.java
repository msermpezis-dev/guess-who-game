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

    public CharacterResource(CharacterResource characterResource){
        this.characterName = characterResource.getCharacterName();
        this.hairColor = characterResource.getHairColor();
        this.shirtColor = characterResource.getShirtColor();
        this.eyeColor = characterResource.getEyeColor();
        this.hasGlasses = characterResource.hasGlasses;
        this.isSmiling = characterResource.isSmiling;
        this.wearsHat = characterResource.wearsHat;
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
        return (hasGlasses) ? "yes" : "no";
    }

    public String isCharacterSmiling(){
        return (isSmiling) ? "yes" : "no";
    }

    public String isCharacterWearingAHat(){
        return (wearsHat) ? "yes" : "no";
    }

    public CharacterResource getCharacterByName(String characterName){
        for ( CharacterResource character : ICharacters.characters){
            if (character.characterName.toLowerCase().equals(characterName)){

                return character;
            }
        }
        // returns null if character doesn't exist
        return null;
    }

    public boolean checkName(String characterName){
        for (String validCharacterName : validCharacterNames) {
            if (validCharacterName.toLowerCase().equals(characterName)){
                return true;
            }
        }
        return false;
    }

    public String isEliminated(){
        return (isEliminated) ? "YES" : "NO";
    }

    public void setEliminated(boolean isEliminated){
        this.isEliminated = isEliminated;
    }

    public boolean checkHairColor(String hairColor){
        for (String validHairColor : validHairColors) {
            System.out.println(validHairColor.toLowerCase() + " " + hairColor);
            if (validHairColor.toLowerCase().equals(hairColor)){
                return true;
            }
        }
        return false;
    }

    public boolean checkShirtColor(String shirtColor){
        for (String validShirtColor : validShirtColors) {
            if (validShirtColor.toLowerCase().equals(shirtColor)){
                return true;
            }
        }
        return false;
    }

    public boolean checkEyeColor(String eyeColor){
        for (String validCEyeColor : validCEyeColors) {
            System.out.println(validCEyeColor.toLowerCase() + " " + eyeColor);
            if (validCEyeColor.toLowerCase().equals(eyeColor)){
                return true;
            }
        }
        return false;
    }

    public boolean checkCharacterAttribute(String attributeName, String attributeValue){
        checkCharacterAttributeName(attributeName);
        checkCharacterAttributeValue(attributeValue);
        return true;
    }

    public boolean checkCharacterAttributeName(String attributeName){
        return true;
    }
    public boolean checkCharacterAttributeValue(String attributeValue){
        return true;
    }




}
