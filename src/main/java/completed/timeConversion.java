package completed;

public class timeConversion {
    public static void main(String[] args) {
        timeConversion("07:05:45PM");
        System.out.println(timeConversion("06:40:03AM"));
        System.out.println(timeConversion("12:00:00AM"));
        System.out.println(timeConversion("12:45:54PM"));
        System.out.println(timeConversion("04:59:59AM"));
    }

    public static String timeConversion(String s) {
        // Write your code here

        //<OTHER CODE>
        Integer hour2 = Integer.valueOf(s.substring(0,2));
        Boolean isPM = s.charAt(8) == 'P';
        hour2 = hour2 == 12 ? (isPM ? 12 : 0) : (isPM ? hour2 + 12 : hour2);
        System.out.println((hour2 < 10 ? "0" : "") + hour2 + s.substring(2,8));
        //</OTHER-CODE>


        int hour = Integer.parseInt(s.substring(0, 2));
        System.out.println(s.contains("PM") ?
                (String.valueOf((hour+12))+s.replace("PM", "").substring(2, (s.length()-2))) :
                (s.replace("AM", "")));

        if (s.contains("PM"))
            return hour == 12 ? s.replace("PM", "") :
                    (hour + 12 + s.replace("PM", "").substring(2, (s.length() - 2)));
        return hour < 10 ? s.replace("AM", "")
            :(((hour-12) < 10 ? "0".concat(String.valueOf(hour - 12)).replace("-", "") : (hour-12)))+s.replace("AM", "").substring(2, (s.length()-2));



        /*return s.contains("PM") ?
                (String.valueOf((hour+12))+s.replace("PM", "").substring(2, (s.length()-2))) :
                (((hour-12) < 10 ? "0".concat(String.valueOf(hour - 12)).replace("-", "") : (hour-12)))+s.replace("AM", "").substring(2, (s.length()-2));*/


    }
}
