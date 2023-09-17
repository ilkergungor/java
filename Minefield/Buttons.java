import javax.swing.JButton;

public class Buttons extends JButton {
    private int row, column, count;
    private boolean mine, flag;


    public Buttons(int row, int column) {
        this.row = row;
        this.column = column;
        this.count = 0;
        this.mine = false;
        this.flag = false;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setMine(boolean mine) {
        this.mine = mine;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public int getCount() {
        return count;
    }
    public boolean isMine() {
        return mine;
    }
    public boolean isFlag() {
        return flag;
    }
}
