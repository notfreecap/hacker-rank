package completed;

public class staircase {
    public static void main(String[] args) {

        staircase(6);

    }


    public static void staircase(int n) {
        // Write your code here

        int spaces;
        for(int i = 1; i <= n; i++){
            String line = "";
            spaces = n - i;
            String empty = spaces == 0 ? "" : String.format("%-"+ spaces +"s", "");
            for(int z = spaces; z < n; z++){
                line += "#";
            }
            System.out.println(empty + line);
        }
        /*
     #
    ##
   ###
  ####
 #####
######
     #
    ##
   ###
  ####
 #####
######
        * */
    }
}
