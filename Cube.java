import java.util.ArrayList;

// Feedback:
//  This looks great! Very logical and easy to read code, I like the way youv'e separated functionality into functions. It would make it much easier to add to as a new dev
//  on the project. It is missing the user input functionality but I would say that with the implementation you've picked that would be quite easy to add and won't
//  effect how I grade it.
// 
//  Great Job!
// 
// 


public class Cube {

  static ArrayList <String> stack = new ArrayList<>();
	public static void main(final String[] args){
    
  String[][] cube = {
      {
        "o","o","o",
        "o","o","o",
        "o","o","o"
      },
      {
        "r","r","r",
        "r","r","r",
        "r","r","r"
      },
      {
        "b","b","b",
        "b","b","b",
        "b","b","b"
      },
      {
        "g","g","g",
        "g","g","g",
        "g","g","g"
      },
      {
        "w","w","w",
        "w","w","w",
        "w","w","w"
      },
      {
        "y","y","y",
        "y","y","y",
        "y","y","y"
      }
    };
    cube = moveU(cube);
    cube = moveD(cube);
    cube = moveR(cube);
    cube = moveL(cube);
    cube = moveF(cube);
    cube = moveB(cube);

    printCube(cube);
    for(int i=stack.size(); i>0;i--){
      System.out.print(stack.get(i-1));
    }
  }
  public static void printCube(String[][] array){
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j+=3) {
          System.out.println(array[i][j]+ " | "+array[i][j+1]+ " | "+array[i][j+2]);
          System.out.println();
        }
        System.out.println();
      }
  }
  public static String[][] moveU(String[][] array){
    stack.add("U'");
      String[][] copy = new String[6][9];

      for (int i = 0; i < copy.length; i++) {
          for (int j = 0; j < copy[i].length; j++) {
            copy[i][j] = array[i][j];
          }
      }
      //Rotate top of cube clockwise
      //Middle spot stays the same
      array[0][0] = copy[0][6];
      array[0][1] = copy[0][3];
      array[0][2] = copy[0][0];
      array[0][3] = copy[0][7];
      array[0][5] = copy[0][1];
      array[0][6] = copy[0][8];
      array[0][7] = copy[0][5];
      array[0][8] = copy[0][2];

      //Change right side of cube, gets values from back side of cube
      array[2][0] = copy[5][8];
      array[2][1] = copy[5][7];
      array[2][2] = copy[5][6];

      //Change left side of cube, gets values from front of cube
      array[3][0] = copy[4][0];
      array[3][1] = copy[4][1];
      array[3][2] = copy[4][2];

      //Change front side of cube, gets values from right
      array[4][0] = copy[2][0];
      array[4][1] = copy[2][1];
      array[4][2] = copy[2][2];

      //Change back side of cube, gets values from the left
      array[5][8] = copy[3][0];
      array[5][7] = copy[3][1];
      array[5][6] = copy[3][2];

      return array;

  }
  
  public static String[][] moveD(String[][] array){
    String[][] copy = new String[6][9];
    stack.add("D'");

    for (int i = 0; i < copy.length; i++) {
        for (int j = 0; j < copy[i].length; j++) {
          copy[i][j] = array[i][j];
        }
    }
      array[1][0] = copy[1][6];
      array[1][1] = copy[1][3];
      array[1][2] = copy[1][0];
      array[1][3] = copy[1][7];
      array[1][5] = copy[1][1];
      array[1][6] = copy[1][8];
      array[1][7] = copy[1][5];
      array[1][8] = copy[1][2];

      array[2][6] = copy[4][6];
      array[2][7] = copy[4][7];
      array[2][8] = copy[4][8];

      array[3][6] = copy[5][2];
      array[3][7] = copy[5][1];
      array[3][8] = copy[5][0];

      array[4][0] = copy[3][6];
      array[4][1] = copy[3][7];
      array[4][2] = copy[3][8];

      array[5][0] = copy[2][8];
      array[5][1] = copy[2][7];
      array[5][2] = copy[2][6];

      return array;

}

  public static String[][] moveR(String[][] array){
    stack.add("R'");
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = array[i][j];
      }
  }
    array[0][2] = copy[4][2];
    array[0][5] = copy[4][5];
    array[0][8] = copy[4][8];

    array[1][2] = copy[5][2];
    array[1][5] = copy[5][5];
    array[1][8] = copy[5][8];

    array[2][0] = copy[2][6];
    array[2][1] = copy[2][3];
    array[2][2] = copy[2][0];
    array[2][3] = copy[2][7];
    array[2][5] = copy[2][1];
    array[2][7] = copy[2][8];
    array[2][8] = copy[2][2];

    array[4][2] = copy[1][2];
    array[4][5] = copy[1][5];
    array[4][8] = copy[1][8];

    array[5][2] = copy[0][2];
    array[5][5] = copy[0][5];
    array[5][8] = copy[0][8];

    return array;

}

  public static String[][] moveL(String[][] array){
    stack.add("L'");
    String[][] copy = new String[6][9];

  for (int i = 0; i < copy.length; i++) {
    for (int j = 0; j < copy[i].length; j++) {
      copy[i][j] = array[i][j];
    }
}
  array[0][0] = copy[5][0];
  array[0][3] = copy[5][3];
  array[0][6] = copy[5][6];

  array[1][0] = copy[4][0];
  array[1][3] = copy[4][3];
  array[1][6] = copy[4][6];

  array[3][0] = copy[3][6];
  array[3][1] = copy[3][3];
  array[3][2] = copy[3][0];
  array[3][3] = copy[3][7];
  array[3][5] = copy[3][1];
  array[3][6] = copy[3][8];
  array[3][7] = copy[3][5];
  array[3][8] = copy[3][2];

  array[4][0] = copy[0][0];
  array[4][3] = copy[0][3];
  array[4][6] = copy[0][6];

  array[5][0] = copy[1][0];
  array[5][3] = copy[1][3];
  array[5][6] = copy[1][6];

  return array;
}

  public static String[][] moveF(String[][] array){
    stack.add("F'");
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
      copy[i][j] = array[i][j];
    }
}
    array[0][6] = copy[3][8];
    array[0][7] = copy[3][5];
    array[0][8] = copy[3][2];

    array[1][0] = copy[2][6];
    array[1][2] = copy[2][3];
    array[1][3] = copy[2][0];

    array[2][0] = copy[0][8];
    array[2][2] = copy[0][7];
    array[2][3] = copy[0][6];

    array[3][2] = copy[1][0];
    array[3][5] = copy[1][1];
    array[3][6] = copy[1][2];

    array[4][0] = copy[4][6];
    array[4][1] = copy[4][3];
    array[4][2] = copy[4][0];
    array[4][3] = copy[4][7];
    array[4][5] = copy[4][1];
    array[4][6] = copy[4][8];
    array[4][7] = copy[4][5];
    array[4][8] = copy[4][2];

    return array;

}

  public static String[][] moveB(String[][] array){
    stack.add("B'");
    String[][] copy = new String[6][9];

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
    copy[i][j] = array[i][j];
    }
  }

    array[0][0] = copy[2][2];
    array[0][1] = copy[2][5];
    array[0][2] = copy[2][8];

    array[1][6] = copy[3][0];
    array[1][7] = copy[3][3];
    array[1][8] = copy[3][6];

    array[2][3] = copy[1][8];
    array[2][5] = copy[1][7];
    array[2][8] = copy[1][6];

    array[3][0] = copy[0][2];
    array[3][3] = copy[0][1];
    array[3][6] = copy[0][0];

    array[5][0] = copy[5][6];
    array[5][1] = copy[5][3];
    array[5][2] = copy[5][0];
    array[5][3] = copy[5][7];
    array[5][5] = copy[5][1];
    array[5][6] = copy[5][8];
    array[5][7] = copy[5][5];
    array[5][8] = copy[5][2];

    return array;
}

  public static String[][] moveUPrime(String[][] array){
    String[][] cube;

    cube = moveU(array);
    cube = moveU(array);
    cube = moveU(array);
    return cube;
  }
 
  public static String[][] moveDPrime(String[][] array){
    String[][] cube;

    cube = moveD(array);
    cube = moveD(array);
    cube = moveD(array);
    return cube;
  }

  public static String[][] moveRPrime(String[][] array){
    String[][] cube;

    cube = moveR(array);
    cube = moveR(array);
    cube = moveR(array);
    return cube;
  }

  public static String[][] moveLPrime(String[][] array){
    String[][] cube;

    cube = moveL(array);
    cube = moveL(array);
    cube = moveL(array);
    return cube;
  }

  public static String[][] moveFPrime(String[][] array){
    String[][] cube;

    cube = moveF(array);
    cube = moveF(array);
    cube = moveF(array);
    return cube;
  }

  public static String[][] moveBPrime(String[][] array){
    String[][] cube;

    cube = moveB(array);
    cube = moveB(array);
    cube = moveB(array);
    return cube;
  }
}

