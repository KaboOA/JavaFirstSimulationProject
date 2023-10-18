package simulationfirstproject;

public class AbleModel {

    private int stB;
    private int st;
    private int stE;
    private int idleTime;

    public AbleModel(int num) {
        this.stB = Constants.q + Constants.clk;
        this.st = setSt(num);
        this.stE = st + stB;
    }

    int setSt(int st) {

        if (st <= 29) {
            return 2;
        } else if (st <= 57) {
            return 3;
        } else if (st <= 82) {
            return 4;
        } else {
            return 5;
        }
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public int getStE() {
        return stE;
    }

    public int getSt() {
        return st;
    }

    public int getStB() {
        return stB;
    }

    public int getIdleTime() {
        return idleTime;
    }

}
