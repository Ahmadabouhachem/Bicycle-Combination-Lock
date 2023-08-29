import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZahlenSchlossTest {
    public static void main(String[] args) {

       startKombinationSollGleichBleiben(new BicycleLock());
      //  startKombinationWirdVierEinser(new ZahlenSchloss());
      //  startKombinationWirdVierZweier(new ZahlenSchloss());
      //  startKombinationWirdVierDreier(new ZahlenSchloss());
      //  startKombinationWirdVierVierer(new ZahlenSchloss());


    }

    @Test
    static void startKombinationSollGleichBleiben(BicycleLock bicycleLock){
        assertEquals("1111", bicycleLock.editPinCode("1111"));
    }
    @Test
    static void startKombinationWirdVierEinser(BicycleLock bicycleLock){
        assertEquals("1111", bicycleLock.editPinCode("1112"));
    }
    @Test
    static void startKombinationWirdVierZweier(BicycleLock bicycleLock){
        assertEquals("2222", bicycleLock.editPinCode("2201"));
    }
    @Test
    static void startKombinationWirdVierDreier(BicycleLock bicycleLock){
        assertEquals("3333", bicycleLock.editPinCode("1313"));
    }
    @Test
    static void startKombinationWirdVierVierer(BicycleLock bicycleLock){
        assertEquals("4444", bicycleLock.editPinCode("1234"));
    }
}