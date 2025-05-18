import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ss {
    @Test
    void test() {

        LocalDateTime localDateTime = LocalDateTime.now();
        long timestamp = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        System.out.println("timestamp(ms) = " + timestamp);

    }
}
