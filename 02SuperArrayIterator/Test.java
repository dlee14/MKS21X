public class Test {
  public static void main(String[]args) {
      
    SuperArray superarray = new SuperArray();
    int i = 0;
    
    while (i < 26) {
      superarray.add("" + (char)('A' + i % 26));
      i++;
    }

    for (int n = 0; n < superarray.size(); n++) {
      System.out.print(superarray.get(n) + " ");
    }
    
    for (String s : superarray) {
      System.out.print(s + " ");
    }

    System.out.println("\n");
  }
}