import java.util.Scanner;

public class ZipCode {

    private String zipCode;

    public ZipCode (String zipTry) {
        setZipCode(zipTry);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode (String zip) {
        if (zip.length() == 5 || zip.length() == 9) {
            this.zipCode = zip;
        } else {
            System.out.println("Cannot create the object");
        }
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        ZipCode zipCode1;

        if (args.length == 1) {
            zipCode1 = new ZipCode(args[0]);
        } else {
            System.out.print("Insert a zipcode: ");
            zipCode1 = new ZipCode(input.nextLine());
        }

        System.out.println(zipCode1.getZipCode());
    }
}
