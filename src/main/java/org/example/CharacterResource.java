package org.example;

public class CharacterResource implements ICharacterAttributes, ICharacters {
    private String characterName;
    private String hairColor;
    private String shirtColor;
    private String eyeColor;
    private boolean hasGlasses;
    private boolean isSmiling;
    private boolean wearsHat;

    private boolean checked = false;

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

    public String getCharacterName(){
        return characterName;
    }

    public boolean checkName(String characterName){
        for (String validCharacterName : validCharacterNames) {
            if (characterName.equals(validCharacterName)){
                return true;
            }
        }
        return false;
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

}
