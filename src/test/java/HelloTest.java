import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {
  @Test
  void testSolution() {
    assertThat(
        Hello.solve(new int [] { 1, 2, 3 }, new int [] { 4, 5, 6 }, 1)
    ).containsExactly(1);

    assertThat(
        Hello.solve(new int [] { 1 }, new int [] { 4, 5, 6 }, 1)
    ).containsExactly(1);

    assertThat(
        Hello.solve(new int [] { 1, 2, 3 }, new int [] { 4, 5, 6 }, 6)
    ).containsExactly(1,2,3,4,5,6);

    assertThat(
        Hello.solve(new int [] { 1, 2, 3 }, new int [] { 4, 5, 6 }, 10)
    ).containsExactly(1,2,3,4,5,6);

    assertThat(
        Hello.solve(new int [] { 1, 2, 3 }, new int [] { -1, 4, 6 }, 6)
    ).containsExactly(-1,1,2,3,4,6);
  }
}
