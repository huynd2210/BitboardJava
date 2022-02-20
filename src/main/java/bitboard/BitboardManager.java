package bitboard;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BitboardManager {
    private Map<String, Bitboard> bitboards;

    public BitboardManager() {
        this.bitboards = new HashMap<>();
    }

    public void setPiece(String id, int i, int j) throws Exception {
        bitboardExistsGuard(id);
        Bitboard bitboard = bitboards.get(id);
        int piecePosition = (i * bitboard.getSizeJ()) + j;
        bitboard.setData(bitboard.getData() | (1L << piecePosition));
    }

    public void showBitboard(String id) throws Exception {
        bitboardExistsGuard(id);
        Bitboard bitboard = this.bitboards.get(id);
        StringBuilder board = new StringBuilder(Long.toBinaryString(bitboard.getData()));

        if (board.length() < (bitboard.getSizeI() * bitboard.getSizeJ())) {
            padBitboard(board, (bitboard.getSizeI() * bitboard.getSizeJ()));
        }

        for (int i = board.length() - 1; i >= 0; i--) {
            if ((i + 1) % bitboard.getSizeJ() == 0) {
                System.out.println();
            } else {
                System.out.print("[" + board.charAt(i) + "]");
            }
        }

//        for (int i = 0; i < bitboard.getSizeI() * bitboard.getSizeJ(); i++) {
//            if ((i + 1) % bitboard.getSizeJ() == 0){
//                System.out.println();
//            }else{
//                System.out.print("[" + board.charAt(i) + "]");
//            }
//        }

    }

    public void buildBitboard(String bitboardId, int sizeI, int sizeJ) throws Exception {
        this.bitboards.put(bitboardId, new Bitboard(getDataType(sizeI, sizeJ), sizeI, sizeJ));
    }

    public Long getDataType(int sizeI, int sizeJ) throws Exception {
        int bitsLength = sizeI * sizeJ;
//        if (bitsLength <= 8){
//            return (byte) 0;
//        }else if (bitsLength <= 16){
//            return (short) 0;
//        }else if (bitsLength <= 32){
//            return 0;
//        }else if (bitsLength <= 64){
//            return (long) 0;
//        }else{
//            throw new Exception("Too large");
//        }
        return (long) 0;
    }

    public void putData(String id, long data) {
        this.bitboards.get(id).setData(data);
    }

    private void bitboardExistsGuard(String id) throws Exception {
        if (!bitboards.containsKey(id)) {
            throw new Exception("Bitboard with id: " + id + " not found");
        }
    }

    private void padBitboard(StringBuilder bitboardBinary, int maxSize) {
        for (int i = 0; i < (maxSize - bitboardBinary.length()); i++) {
            bitboardBinary.insert(0, '0');
        }
    }
}
