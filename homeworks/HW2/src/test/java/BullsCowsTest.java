import org.junit.Test;
import org.junit.Ignore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class BullsCowsTest {
    @Test
    public void BullsAndCows() {
        Main.wordChars = new StringBuilder("aasty");
        Main.typedWordChars = new StringBuilder("aatsy");

        assertThat(Main.countBulls(), is(equalTo(3)));
        assertThat(Main.countCows(), is(equalTo(2)));
    }

    @Test
    public void BullsCows1() {
        Main.wordChars = new StringBuilder("aasty");
        Main.typedWordChars = new StringBuilder("puio");

        assertThat(Main.countBulls(), is(equalTo(0)));
        assertThat(Main.countCows(), is(equalTo(0)));
    }

    @Test
    public void BullsCows2() {
        Main.wordChars = new StringBuilder("aasty");
        Main.typedWordChars = new StringBuilder("aasty");

        assertThat(Main.countBulls(), is(equalTo(5)));
        assertThat(Main.countCows(), is(equalTo(0)));
    }
}
