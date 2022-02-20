package bitboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bitboard {
    private Long data;
    private int sizeI;
    private int sizeJ;

    protected Bitboard(Long data, int sizeI, int sizeJ){
        this.data = data;
        this.sizeI = sizeI;
        this.sizeJ = sizeJ;
    }
}
