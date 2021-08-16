package sparse;

import java.io.*;

/** @Author: 云萧YYY @DateTime: 2021/08/01 @Description: 稀疏数组 实现 */
public class SparseArrayDemo {

  private static final String DATA_PATH = "D:\\IdeaProjects\\alg_data\\data.txt";

  public static void main(String[] args) {
    // 稀疏数组
    int[][] arry = new int[11][11];
    arry[3][4] = 1;
    arry[6][3] = 2;

    // ====================arrayToSparse==========================
    int[][] sparseArray = arryToSparse(arry, getCount(arry));
    printArray(sparseArray);
    System.out.println();
    // ===================sparseToArray==========================
    int[][] array = sparseToArry(sparseArray);
    printArray(array);
    // ====================write================================
    writeSparse(sparseArray);
    System.out.println();
    // ====================read=================================
    int[][] ints = readSparse(new File(DATA_PATH));
    printArray(ints);
  }
  /**
   * 二维数组转化稀疏数组
   * @param arry
   * @param count
   * @return
   */
  private static int[][] arryToSparse(int[][] arry, int count) {
    int row = arry.length;
    int clo = arry[0].length;
    int[][] sparse = new int[count + 1][3];
    sparse[0][0] = row;
    sparse[0][1] = clo;
    sparse[0][2] = count;
    int index = 1;
    for (int i = 0; i < arry.length; i++) {
      //
      for (int j = 0; j < arry[i].length; j++) {
        //
        if (arry[i][j] != 0) {
          sparse[index][0] = i;
          sparse[index][1] = j;
          sparse[index][2] = arry[i][j];
          index++;
        }
      }
    }

    return sparse;
  }

  /**
   * 获取有效数值个数
   * @param arry
   * @return
   */
  private static int getCount(int[][] arry) {
    int count = 0;
    for (int i = 0; i < arry.length; i++) {
      //
      for (int j = 0; j < arry[i].length; j++) {
        //
        if (arry[i][j] != 0) {
          count++;
        }
      }
    }
    return count;
  }
  /**
   * 规格化打印数组
   *
   * @param arry
   */
  private static void printArray(int[][] arry) {
    for (int i = 0; i < arry.length; i++) {
      //
      for (int j = 0; j < arry[i].length; j++) {
        //
        System.out.print(arry[i][j] + "\t");
      }
      System.out.println();
    }
  }

  /**
   * 稀疏数组转化二维数组
   *
   * @param sparse
   * @return
   */
  private static int[][] sparseToArry(int[][] sparse) {
    // 根据稀疏数组首行信息来创建原数组
    int row = sparse[0][0];
    int clo = sparse[0][1];
    int[][] array = new int[row][clo];
    for (int i = 1; i < sparse.length; i++) {
      // 填值
      array[sparse[i][0]][sparse[i][1]] = sparse[i][2];
    }
    return array;
  }

  /**
   * 读取数组,根据存放规则来的
   *
   * @param file
   * @return
   */
  private static int[][] readSparse(File file) {

    if (file == null) {
      System.out.println("file 为空");
      return null;
    }
    BufferedReader br = null;
    int[][] sparse = new int[3][3];
    int index = 0;
    try {
      br = new BufferedReader(new FileReader(file));
      String line = null;
      // 定义稀疏数组
      while ((line = br.readLine()) != null) {
        String[] values = line.substring(0, line.length() - 1).split(",");
        for (int i = 0; i < values.length; i++) {
          //
          sparse[index][i] = Integer.parseInt(values[i]);
        }
        index++;
      }
      return sparse;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  /**
   * 写入数组,写入时，数组元素按行写入，每个元素之间通过逗号分割
   *
   * @param sparse
   * @return
   */
  private static boolean writeSparse(int[][] sparse) {

    FileWriter fileWriter = null;
    try {
      fileWriter = new FileWriter(new File(DATA_PATH));
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < sparse.length; i++) {
        //
        for (int j = 0; j < sparse[i].length; j++) {
          //
          sb.append(sparse[i][j]);
          sb.append(",");
        }
        sb.append("\r\n");
      }
      fileWriter.write(sb.toString());
      return true;
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fileWriter != null) {
        try {
          fileWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return false;
  }
}
