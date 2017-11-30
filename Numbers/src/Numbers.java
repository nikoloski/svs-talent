public class Numbers {

    public static void main(String[] args) {

        String number = "";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "zero":
                    number += "0";
                    break;
                case "one":
                    number += "1";
                    break;
                case "two":
                    number += "2";
                    break;
                case "three":
                    number += "3";
                    break;
                case "four":
                    number += "4";
                    break;
                case "five":
                    number += "5";
                    break;
                case "six":
                    number += "6";
                    break;
                case "seven":
                    number += "7";
                    break;
                case "eight":
                    number += "8";
                    break;
                case "nine":
                    number += "9";
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

        System.out.println(number);

    }
}
