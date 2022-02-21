import bitboard.Bitboard;
import bitboard.BitboardManager;

public class main {
    public static void main(String[] args) throws Exception {
        BitboardManager bm = new BitboardManager();
        bm.buildBitboard("a", 4,5);
//        bm.setPiece("a", 1,3);
//        System.out.println();
//        bm.showBitboard("a");
//        bm.movePiece("test", 1, 3, 0, 0);
//        System.out.println();
//        bm.showBitboard("test");
        bm.setNeighbors("a", 1, 1);
        bm.showBitboard("a");
        System.out.println("-------");
        bm.deleteNeighbors("a", 1,1);
        bm.showBitboard("a");

    }
}
