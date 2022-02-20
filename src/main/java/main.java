import bitboard.Bitboard;
import bitboard.BitboardManager;

public class main {
    public static void main(String[] args) throws Exception {
        BitboardManager bm = new BitboardManager();
        bm.buildBitboard("test", 4,5);
//        bm.putData("test", 16);
//        bm.showBitboard("test");
        bm.setPiece("test", 1,1);
        bm.showBitboard("test");
    }
}
