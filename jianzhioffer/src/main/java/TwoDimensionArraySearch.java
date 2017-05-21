/**
 * Created by Jikai Zhang on 2017/5/20.
 */
public class TwoDimensionArraySearch {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;
        //int rowStart = 0, rowEnd = rows - 1;
        //int columnStart = 0, columnEnd = columns - 1;
        int currentRow = 0, currentColumn = columns - 1;

        while (currentRow < rows && currentColumn >= 0) {
            if (array[currentRow][currentColumn] == target) {
                return true;
            }
            if (array[currentRow][currentColumn] < target) {
                currentRow++;
            } else if (array[currentRow][currentColumn] > target) {
                currentColumn--;
            }
        }
        return false;
    }
}
