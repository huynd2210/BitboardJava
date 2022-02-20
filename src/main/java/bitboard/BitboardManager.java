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

    public void deletePiece(String id, int i, int j) throws Exception {
        bitboardExistsGuard(id);
        Bitboard bitboard = bitboards.get(id);
        int piecePosition = (i * bitboard.getSizeJ()) + j;
        bitboard.setData(bitboard.getData() & ~(1L << piecePosition));
    }

    public boolean isPieceSet(String id, int i, int j) throws Exception {
        bitboardExistsGuard(id);
        Bitboard bitboard = bitboards.get(id);
        int piecePosition = (i * bitboard.getSizeJ()) + j;
        return ((bitboard.getData() >> (piecePosition)) & 1) == 1;
    }

    public void movePiece(String id, int fromI, int fromJ, int toI, int toJ) throws Exception {
        if (isPieceSet(id, fromI, fromJ)){
            deletePiece(id, fromI, fromJ);
            setPiece(id, toI, toJ);
        }
    }

    public void showBitboard(String id) throws Exception {
        bitboardExistsGuard(id);
        Bitboard bitboard = this.bitboards.get(id);
        StringBuilder board = new StringBuilder(Long.toBinaryString(bitboard.getData()));

        if (board.length() < (bitboard.getSizeI() * bitboard.getSizeJ())) {
            padBitboard(board, (bitboard.getSizeI() * bitboard.getSizeJ()));
        }

        for (int i = board.length() - 1; i >= 0; i--) {
            int endLineIndex = (i + 1);
            if (endLineIndex % bitboard.getSizeJ() == 1 && endLineIndex != board.length()) {
                System.out.println("[" + board.charAt(i) + "]");
            } else {
                System.out.print("[" + board.charAt(i) + "]");
            }
        }
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
        int iterateLength = maxSize - bitboardBinary.length();
        for (int i = 0; i < iterateLength; i++) {
            bitboardBinary.insert(0, '0');
        }
    }
}
