import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class BicycleLockTest {
    public static void main(String[] args) {

        combinationAllSame(new BicycleLock());

    }

    @Test
    static void combinationAllSame(BicycleLock bicycleLock) {
        assertEquals("1111", bicycleLock.editLockCode("1111"));
    }

    @Test
    static void combinationDiffOne(BicycleLock bicycleLock) {
        assertEquals("1111", bicycleLock.editLockCode("1112"));
    }

    @Test
    static void combinationDiffTwo(BicycleLock bicycleLock) {
        assertEquals("2222", bicycleLock.editLockCode("2201"));
    }

    @Test
    static void combinationDiffTowParallel(BicycleLock bicycleLock) {
        assertEquals("3333", bicycleLock.editLockCode("1313"));
    }

    @Test
    static void combinationAllDiff(BicycleLock bicycleLock) {
        assertEquals("4444", bicycleLock.editLockCode("1234"));
    }
}