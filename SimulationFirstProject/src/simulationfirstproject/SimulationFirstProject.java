package simulationfirstproject;

import java.util.ArrayList;
import static simulationfirstproject.Constants.clk;
import static simulationfirstproject.Constants.convertToString;
import static simulationfirstproject.Constants.getIat;
import static simulationfirstproject.Constants.iats;
import static simulationfirstproject.Constants.isFree;
import static simulationfirstproject.Constants.q;
import static simulationfirstproject.Constants.sts;

public class SimulationFirstProject {

    static ArrayList<AbleModel> ables = new ArrayList();
    static ArrayList<BakerModel> bakers = new ArrayList();
    static ArrayList<Integer> spentTimes = new ArrayList();

    static boolean isAble = true;

    public static void main(String[] args) {
        ArrayList<TableData> rows = new ArrayList();

        int i = 0;
        while (clk < 60) {
            if (q == 0) {
                clk += getIat(iats[i]);
            }
            /*
            /// periority for able
            if (i == 0) {// first time we run able (efficient).
                runAble(i);
            } else if (isAbleFree()) {// when able free => run able.
                runAble(i);
            } else { // able not free at all.
                if (bakers.isEmpty()) {// if baker list empty and able is busy => run baker.
                    runBaker(i);
                } else {
                    if (isBakerFree()) {// check if baker busy.
                        runBaker(i);
                    } else { // both baker and alber are busy.
                        q++;
                        continue;
                    }
                }
            }
             */

            /// periority for baker
            if (i == 0) {
                runBaker(i);
                spentTimes.add(q + bakers.get(bakers.size() - 1).getSt());
            } else if (isBakerFree()) {
                runBaker(i);
                spentTimes.add(q + bakers.get(bakers.size() - 1).getSt());
            } else {
                if (ables.isEmpty()) {
                    runAble(i);
                    spentTimes.add(q + ables.get(ables.size() - 1).getSt());
                } else {
                    if (isAbleFree()) {
                        runAble(i);
                        spentTimes.add(q + ables.get(ables.size() - 1).getSt());
                    } else {
                        q++;
                        continue;
                    }
                }
            }

            rows.add(addRow(i));
            i++;
            q = 0;
        }
        System.out.printf("%5s %8s %7s %9s %8s %9s %2s %2s %2s %2s %2s %2s %2s %2s %2s", "CallID", "RN-IAT", "IAT", "Clock", "RN-ST", "Able-STB", "Able-ST", "Able-STE", "Baker-STB", "Baker-ST", "Baker-STE", "Queuing Time", "Time-Spent", "Able-IdleT", "Baker-IdleT");
        System.out.println();
        for (TableData row : rows) {
            setData(row);
        }

    }

    static void runAble(int i) {
        if (ables.isEmpty()) {
            ables.add(new AbleModel(sts[i]));
            ables.get(ables.size() - 1).setIdleTime(ables.get(ables.size() - 1).getStB());
        } else {
            ables.add(new AbleModel(sts[i]));
            ables.get(ables.size() - 1).setIdleTime(ables.get(ables.size() - 1).getStB() - ables.get(ables.size() - 2).getStE());
        }
        spentTimes.add(q + ables.get(ables.size() - 1).getSt());
        isAble = true;
    }

    static void runBaker(int i) {
        if (bakers.isEmpty()) {
            bakers.add(new BakerModel(sts[i]));
            bakers.get(bakers.size() - 1).setIdleTime(bakers.get(bakers.size() - 1).getStB());
        } else {
            bakers.add(new BakerModel(sts[i]));
            bakers.get(bakers.size() - 1).setIdleTime(bakers.get(bakers.size() - 1).getStB() - bakers.get(bakers.size() - 2).getStE());
        }
        spentTimes.add(q + bakers.get(bakers.size() - 1).getSt());
        isAble = false;
    }

    static boolean isAbleFree() {
        return isFree(ables.get(ables.size() - 1).getStE());
    }

    static boolean isBakerFree() {
        return isFree(bakers.get(bakers.size() - 1).getStE());
    }

    static TableData addRow(int i) {
        return new TableData(
                convertToString(i + 1),
                convertToString(iats[i]),
                convertToString(getIat(iats[i])),
                convertToString(clk),
                convertToString(sts[i]),
                isAble ? convertToString(ables.get(ables.size() - 1).getStB()) : "-",
                isAble ? convertToString(ables.get(ables.size() - 1).getSt()) : "-",
                isAble ? convertToString(ables.get(ables.size() - 1).getStE()) : "-",
                !isAble ? convertToString(bakers.get(bakers.size() - 1).getStB()) : "-",
                !isAble ? convertToString(bakers.get(bakers.size() - 1).getSt()) : "-",
                !isAble ? convertToString(bakers.get(bakers.size() - 1).getStE()) : "-",
                convertToString(q),
                convertToString(spentTimes.get(spentTimes.size() - 1)),
                isAble ? convertToString(ables.get(ables.size() - 1).getIdleTime()) : "-",
                !isAble ? convertToString(bakers.get(bakers.size() - 1).getIdleTime()) : "-");

    }

    static void setData(TableData row) {
        System.out.printf("%4s", row.getCallId());
        System.out.printf("%9s", row.getRnIat());
        System.out.printf("%9s", row.getIat());
        System.out.printf("%9s", row.getClk());
        System.out.printf("%9s", row.getRnSt());
        System.out.printf("%9s", row.getAbleStB());
        System.out.printf("%9s", row.getAbleSt());
        System.out.printf("%9s", row.getAbleStE());
        System.out.printf("%9s", row.getBakerStB());
        System.out.printf("%9s", row.getBakerSt());
        System.out.printf("%9s", row.getBakerStE());
        System.out.printf("%11s", row.getQ());
        System.out.printf("%12s", row.getTimeSpent());
        System.out.printf("%12s", row.getAbleIdleTime());
        System.out.printf("%12s", row.getBakerIdleTime());
        System.out.println();
    }
}
