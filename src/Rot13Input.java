import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * "Rot13" substitution cipher, and then prints out the encoded lines.
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 * This program reads lines of text from the user, encodes them using the
 * trivial .
 *
 **/
public class Rot13Input {
  /**
   * Reads lines of text from the user.
   * @param args Ignored
   * @throws IOException ID for error
   */
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    for (;;) {                                    //Loop forever
      System.out.print("> ");
      String line = in.readLine();
      if ((line == null) || line.equals("quit")) {
        break;
      }
      StringBuffer buf = new StringBuffer(line);
      for (int i = 0; i < buf.length(); i++) {
        buf.setCharAt(i, rot13(buf.charAt(i)));
      }
      System.out.println(buf);
    }
  }

  /**
   * This method performs the Rot13 substitution cipher.
   * It "rotates" each letter 13 places through the alphabet.
   * @param c Character to be encoded.
   * @return The modified character.
   */
  private static char rot13(char c) {
    if ((c >= 'A') && (c <= 'Z')) {
      c += 13;                       // Rotate forward 13
      if (c > 'Z') {
        c -= 26;                    // And subtract 26 if necessary
      }
    }
    if ((c >= 'a') && (c <= 'z')) {  // Do the same for lowercase letters
      c += 13;
      if (c > 'z') {
        c -= 26;
      }
    }
    return c;
  }
}
