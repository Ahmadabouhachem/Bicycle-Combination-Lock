import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZahlenSchlossTest {
    public static void main(String[] args) {

      //  startKombinationSollGleichBleiben(new ZahlenSchloss());
      //  startKombinationWirdVierEinser(new ZahlenSchloss());
      //  startKombinationWirdVierZweier(new ZahlenSchloss());
      //  startKombinationWirdVierDreier(new ZahlenSchloss());
      //  startKombinationWirdVierVierer(new ZahlenSchloss());


    }

    @Test
    static void startKombinationSollGleichBleiben(ZahlenSchloss zahlenSchloss){
        assertEquals("1111",zahlenSchloss.pinIsCorrect("1111"));
    }
    @Test
    static void startKombinationWirdVierEinser(ZahlenSchloss zahlenSchloss){
        assertEquals("1111",zahlenSchloss.pinIsCorrect("1112"));
    }
    @Test
    static void startKombinationWirdVierZweier(ZahlenSchloss zahlenSchloss){
        assertEquals("2222",zahlenSchloss.pinIsCorrect("2201"));
    }
    @Test
    static void startKombinationWirdVierDreier(ZahlenSchloss zahlenSchloss){
        assertEquals("3333",zahlenSchloss.pinIsCorrect("1313"));
    }
    @Test
    static void startKombinationWirdVierVierer(ZahlenSchloss zahlenSchloss){
        assertEquals("4444",zahlenSchloss.pinIsCorrect("1234"));
    }
}