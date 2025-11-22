package karate;

import com.intuit.karate.junit5.Karate;
public class KarateTestRunner {
    @Karate.Test
    Karate runAll() {
        return Karate.run("NoSQL/cliente").relativeTo(getClass());
    }
}
