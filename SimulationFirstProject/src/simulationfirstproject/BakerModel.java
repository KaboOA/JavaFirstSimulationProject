package simulationfirstproject;

public class BakerModel {

    private int stB;
    private int st;
    private int stE;
    private int idleTime;

    public BakerModel(int num) {
        this.stB = Constants.q + Constants.clk;
        this.st = setSt(num);
        this.stE = st + stB;
    }

    int setSt(int st) {
        if (st <= 34) {
            return 3;
        } else if (st <= 59) {
            return 4;
        } else if (st <= 79) {
            return 5;
        } else {
            return 6;
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
