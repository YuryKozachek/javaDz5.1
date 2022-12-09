import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {
    @Test
    public void registeredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1_000;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void registeredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1_000;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

}
