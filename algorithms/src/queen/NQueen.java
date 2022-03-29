package queen;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/03/29
 * @Description: n 皇后问题 ，backtracking
 */
public class NQueen {

    public static void main(String[] args) {
        List<Location> locations = queenChessBoard(4);
    }

    public static List<Location> queenChessBoard(int n) {

        List<Location> chessBoard = new ArrayList<>();


        backtracking(n, chessBoard, 0);

        return chessBoard;
    }

    public static void backtracking(int n, List<Location> list, int row) {

        if (list.size() == n) {
            System.out.println(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            Location location = new Location(row, i);
            if (isValid(location, list)) {
                list.add(location);
                backtracking(n, list, row + 1);
                list.remove(location);
            }
        }
    }

    private static boolean isValid(Location location, List<Location> list) {

        for (Location loc : list) {
            // 同行或者同列
            if (loc.getX() == location.getX() || loc.getY() == location.getY()) return false;
            //对角线
            if (Math.abs(loc.getX() - location.getX()) == Math.abs(loc.getY() - location.getY())) return false;
        }
        return true;
    }
}
