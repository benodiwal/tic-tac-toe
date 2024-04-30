package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol {
    char character;
    public Symbol(char character) {
        this.character = character;
    }
}
