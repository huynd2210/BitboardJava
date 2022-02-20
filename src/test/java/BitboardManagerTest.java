import bitboard.BitboardManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BitboardManagerTest {
    private BitboardManager bitboardManager;
    public BitboardManagerTest(){

    }

    @BeforeEach
    public void setup(){
        this.bitboardManager = new BitboardManager();
    }

    @Test
    public void whenBitboardSizeLessEqualThan8ThenUseByte() throws Exception {
        Object dataType = this.bitboardManager.getDataType(2, 3);
        Assertions.assertTrue(dataType instanceof Byte);
    }

    @Test
    public void whenBitboardSizeLessEqualThan16ThenUseShort() throws Exception {
        Object dataType = this.bitboardManager.getDataType(4, 3);
        Assertions.assertTrue(dataType instanceof Short);
    }

    @Test
    public void whenBitboardSizeLessEqualThan32ThenUseInt() throws Exception {
        Object dataType = this.bitboardManager.getDataType(5, 5);
        Assertions.assertTrue(dataType instanceof Integer);
    }

    @Test
    public void whenBitboardSizeLessEqualThan64ThenUseLong() throws Exception {
        Object dataType = this.bitboardManager.getDataType(8, 8);
        Assertions.assertTrue(dataType instanceof Long);
    }



}
