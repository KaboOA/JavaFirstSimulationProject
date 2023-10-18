package simulationfirstproject;

public class TableData {

    private String callId;
    private String rnIat;
    private String iat;
    private String clk;
    private String rnSt;
    private String ableStB;
    private String ableSt;
    private String ableStE;
    private String bakerStB;
    private String bakerSt;
    private String bakerStE;
    private String q;
    private String timeSpent;
    private String ableIdleTime;
    private String bakerIdleTime;

    public TableData(String callId, String rnIat, String iat, String clk, String rnSt, String ableStB, String ableSt, String ableStE, String bakerStB, String bakerSt, String bakerStE, String q, String timeSpent, String ableIdleTime, String bakerIdleTime) {
        this.callId = callId;
        this.rnIat = rnIat;
        this.iat = iat;
        this.clk = clk;
        this.rnSt = rnSt;
        this.ableStB = ableStB;
        this.ableSt = ableSt;
        this.ableStE = ableStE;
        this.bakerStB = bakerStB;
        this.bakerSt = bakerSt;
        this.bakerStE = bakerStE;
        this.q = q;
        this.timeSpent = timeSpent;
        this.ableIdleTime = ableIdleTime;
        this.bakerIdleTime = bakerIdleTime;
    }

    public String getCallId() {
        return callId;
    }

    public String getRnIat() {
        return rnIat;
    }

    public String getIat() {
        return iat;
    }

    public String getClk() {
        return clk;
    }

    public String getRnSt() {
        return rnSt;
    }

    public String getAbleStB() {
        return ableStB;
    }

    public String getAbleSt() {
        return ableSt;
    }

    public String getAbleStE() {
        return ableStE;
    }

    public String getBakerStB() {
        return bakerStB;
    }

    public String getBakerSt() {
        return bakerSt;
    }

    public String getBakerStE() {
        return bakerStE;
    }

    public String getQ() {
        return q;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public String getAbleIdleTime() {
        return ableIdleTime;
    }

    public String getBakerIdleTime() {
        return bakerIdleTime;
    }

}
