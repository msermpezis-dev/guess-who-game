package org.guesswhogame;

/*
    This interface holds all the available combinations the character attributes can have to create their
    respected characters
 */
public interface IBoardResource {
    CharacterResource[] characters = new CharacterResource[]{
            new CharacterResource("Alice", "Brown", "Black", "Brown",
                    true, true, false),
            new CharacterResource("Bob", "Blond", "White",  "Brown",
                    false,  true, false),
            new CharacterResource("Charlie", "Black", "Green",  "Blue",
                    false,  true, true),
            new CharacterResource("Donald", "Red",   "White",  "Blue",
                    false,  false,  false),
            new CharacterResource("Erica", "Blond", "Yellow", "Green",
                    false,  true, true),
            new CharacterResource("Fritz", "Black", "Black",  "Blue",
                    true, false,  true),
            new CharacterResource("George", "Brown", "Yellow", "Brown",
                    false,  true, false),
            new CharacterResource("Heidi", "Red",   "Black",  "Blue",
                    true, true, true),
            new CharacterResource("Ian", "Black", "White",  "Brown",
                    true, false,  false),
            new CharacterResource("John", "Brown", "Black",  "Brown",
                    false,  false,  false),
            new CharacterResource("Karl", "Red",   "Yellow", "Green",
                    false,  true, false),
            new CharacterResource("Lena", "Red",   "White",  "Brown",
                    false,  true, true),
            new CharacterResource("Maria", "Blond", "Yellow", "Green",
                    false,  true, false),
            new CharacterResource("Nick", "Black", "Green",  "Brown",
                    false,  false,  false),
            new CharacterResource("Olive", "Red",   "White",  "Blue",
                    true, true, false),
            new CharacterResource("Petros", "Black", "White",  "Brown",
                    false,  true, false),
            new CharacterResource("Quentin", "Blond", "Yellow", "Blue",
                    false,  true, false),
            new CharacterResource("Rafaela", "Blond", "Green",  "Green",
                    false,  true, false),
            new CharacterResource("Sabine", "Black", "Green",  "Blue",
                    false,  false,  true),
            new CharacterResource("Takis", "Brown", "Black",  "Brown",
                    false,  true, true),
            new CharacterResource("Udo", "Red", "Black",  "Green",
                    false,  true, false),
            new CharacterResource("Valentine", "Black", "Yellow", "Blue",
                    false,  true, false),
            new CharacterResource("Walter", "Brown", "White",  "Blue",
                    true, false,  true),
            new CharacterResource("Xavier", "Red", "Green",  "Brown",
                    false,  true, false)
    };

}
