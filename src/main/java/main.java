import bitboard.Bitboard;
import bitboard.BitboardManager;

public class main {
    public static void main(String[] args) throws Exception {
        BitboardManager bm = new BitboardManager();
        bm.buildBitboard("test", 4,5);
        bm.showBitboard("test");
        System.out.println("_________________");
        bm.setPiece("test", 1,3);
        bm.showBitboard("test");
        System.out.println();
        bm.deletePiece("test", 1,3);
        bm.showBitboard("test");

    }
}
