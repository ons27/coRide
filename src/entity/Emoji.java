/**
 * 
 */
package entity;

public class Emoji {
    private String character;
    private String unicodeName;

    public Emoji(String character, String unicodeName) {
        this.character = character;
        this.unicodeName = unicodeName;
    }

    public String getCharacter() {
        return character;
    }

    public String getUnicodeName() {
        return unicodeName;
    }
}
