package completed;

public class kangaroo {

    public static void main(String[] args) {
        //System.out.println(completed.kangaroo(0, 2, 5, 3));
        //System.out.println(completed.kangaroo(0, 3, 4, 2));
        System.out.println(kangaroo(42, 3, 94, 2));
    }

    /**
     * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!!!!
     *
     * */
    public static String otherCode(int x1, int v1, int x2, int v2) {
        return v1 > v2 && (x2-x1)%(v1-v2) == 0 ? "YES" : "NO";
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        Long a = (long) x1;
        Long b = (long) x2;

        if ((x1 > x2 && v1 > v2) || (x2 > x1 && v2 > v1)){
            return "NO";
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(a);
            System.out.println(b);
            System.out.println("*----------------------*");
            if (a > 0 && b > 0) {
                if (a > b) {
                    if (a % b == 0) return "YES";
                } else {
                    if (b % a == 0) return "YES";
                }
            }
            a+= v1;
            b+= v2;
        }
        return "NO";
    }
}
