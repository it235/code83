package example;

import java.util.*;

public class Example {
  public void computeScore(String type, Double score, Double sum) {
    if (type.equals("type1")) {
      sum += score * 0.1;
    } else if (type.equals("type2")) {
      sum += score * 0.2;
    } else if (type.equals("type3")) {
      sum += score * 0.3;
    } else if (type.equals("type4")) {
      sum += score * 0.4;
    } else if (type.equals("type5")) {
      sum += score * 0.5;
    } else if (type.equals("type6")) {
      sum += score * 0.6;
    } else if (type.equals("type7")) {
      sum += score * 0.7;
    }  
  }
}
