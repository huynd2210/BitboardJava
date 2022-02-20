import bitboard.Bitboard;
import bitboard.BitboardManager;

public class main {
    public static void main(String[] args) throws Exception {
        BitboardManager bm = new BitboardManager();
        bm.buildBitboard("test", 4,5);
        bm.setPiece("test", 1,3);
        System.out.println();
        bm.showBitboard("test");
        bm.movePiece("test", 1, 3, 0, 0);
        System.out.println();
        bm.showBitboard("test");

    }
}
