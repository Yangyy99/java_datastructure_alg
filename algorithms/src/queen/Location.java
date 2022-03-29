package queen;

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/03/29
 * @Description: 皇后在棋盘位置的坐标
 */
public class Location {

    private int x;

    private int y;

    public Location() {
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "i=" + x +
                ", y=" + y +
                '}';
    }
}
