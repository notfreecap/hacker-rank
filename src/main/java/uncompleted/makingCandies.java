package uncompleted;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class makingCandies {
    public static void main(String[] args) {
        //System.out.println(minimumPasses(3, 1, 2, 12));
        //System.out.println("FINAL COUNT: " + minimumPasses(1, 1, 6, 45));
        //minimumPassesRemaster(1, 1, 6, 45);
        System.out.println(otherCode(1, 1, 6, 45));
    }

    // Complete the minimumPasses function below.
    static long otherCode(long m, long w, long p, long n) {
        long candies = 0;
        long invest = 0;
        long spend = Long.MAX_VALUE;

        while (candies < n) {
            // preventing overflow in m*w
            long passes = (long) (((p - candies) / (double) m) / w);

            if (passes <= 0) {
                // machines we can buy in total
                long mw = candies / p + m + w;
                long half = mw >>> 1;
                if (m > w) {
                    m = Math.max(m, half);
                    w = mw - m;
                } else {
                    w = Math.max(w, half);
                    m = mw - w;
                }
                candies %= p;
                passes++;
            }

            // handling overflowing
            // if overflowing is encountered -> candies count are definitely more than long
            // thus it is more than n since n is long
            // so we've reached the goal and we can break the loop
            long mw;
            long pmw;
            try {
                mw = Math.multiplyExact(m, w);
                pmw = Math.multiplyExact(passes, mw);
            } catch (ArithmeticException ex) {
                // we need to add current pass
                invest += 1;
                // increment will be 1 because of overflow
                spend = Math.min(spend, invest + 1);
                break;
            }

            candies += pmw;
            invest += passes;
            long increment = (long) Math.ceil((n - candies) / (double) mw);
            spend = Math.min(spend, invest + increment);
        }

        return Math.min(spend, invest);
    }

    public static long minimumPassesRemaster(long m, long w, long p, long n) {

        List<Long> mod2 = new ArrayList<>();
        List<Map<Long, Long>> mod = new ArrayList<>();
        Long min = 0L;
        for (int i = 1; i < n; i++) {
            if (n%i == 0){
                mod2.add((long) i);
            }
        }

        Long fm = 0L;
        Long fw = 0L;
        for (int i = 0; i < mod2.size(); i++) {
            for (int j = 0; j < mod2.size(); j++) {
                if (mod2.get(i) * mod2.get(j) == 45){
                    if (min == 0){
                        min = mod2.get(i) + mod2.get(j);
                        fm = mod2.get(i);
                        fw = mod2.get(j);
                    }else if (min > mod2.get(i) + mod2.get(j)){
                        min = mod2.get(i) + mod2.get(j);
                        fm = mod2.get(i);
                        fw = mod2.get(j);
                    }
                }
            }
        }

        Long lastGenerated = 0L;
        int count = 0;

        while (lastGenerated < n){
            if ((lastGenerated) >= n) break;

            lastGenerated += m * w;

            while (lastGenerated >= p){
                if ((lastGenerated + (m * w)) >= n) break;
                if (m < fm){
                    System.out.println("get machine");
                    m++;
                    System.out.println(lastGenerated);
                    lastGenerated -= p;
                    System.out.println(lastGenerated);
                }else if (w < fw){
                    System.out.println("get worker");
                    w++;
                    lastGenerated -= p;
                }
            }
            count++;
        }

        return count;
    }

    public static long minimumPasses(long m, long w, long p, long n) {
        // Write your code here
        int count = 0;
        Long lastGenerated = 0L;
        Boolean isM = false;

        while (lastGenerated < n){

            if (lastGenerated == n /*|| count > 10*/)
                break;

            lastGenerated += m * w;
            System.out.println("last generated: "+ lastGenerated);
            // hire? new machine?
            if (lastGenerated >= p && lastGenerated < n){
                while (lastGenerated >= p){
                    if ((lastGenerated + (m * w)) >= n) break;
                    //see the future?
                    if (n%m != 0) {
                        for (int i = 1; i <= (n / p); i++) {
                            isM = false;
                            if (m == 1){
                                isM = true;
                                break;
                            }else if ((n%(m+i)) == 0){
                                System.out.println("MODULO???: "+(n%(m+i)));
                                System.out.println("MODULO???: "+(n));
                                System.out.println("MODULO???: "+(m+i));
                                isM = true;
                                break;
                            }
                        }
                    } else {
                        System.out.println("MODULO??? 2: "+(n));
                        System.out.println("MODULO??? 2: "+(m));
                        isM = true;
                    }

                    if (isM) {
                        System.out.println("get machine");
                        m++;
                    } else {
                        System.out.println("get worker");
                        w++;
                    }
                    lastGenerated -= p;
                }
            }
            count++;
            if (count == 16){
                System.out.println("#################");
                System.out.println("total m: " + m);
                System.out.println("total w: " + w);
                System.out.println("total count: " + count);
            }
        }
        /*System.out.println("total m: " + m);
        System.out.println("total w: " + w);
        System.out.println("total n: " + n);*/
        return count;
    }
}
