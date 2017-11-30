import java.util.Scanner;

class ZipCodeException extends RuntimeException {

    public ZipCodeException (String message) {
        super(message);
    }
}

public class ZipCodeWithExceptions {

    private String zipCode;

    public ZipCodeWithExceptions (String zipTry) {
        setZipCode(zipTry);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode (String zip) {
        try {
            if (zip.length() == 5 || zip.length() == 9) {
                this.zipCode = zip;
            } else {
                throw new ZipCodeException("Zip code must consist of 5 or 9 digits");
            }
        } catch (ZipCodeException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        ZipCodeWithExceptions zipCode1;

        if (args.length == 1) {
            zipCode1 = new ZipCodeWithExceptions(args[0]);
        } else {
            System.out.print("Insert a zipcode: ");
            zipCode1 = new ZipCodeWithExceptions(input.nextLine());
        }

    }
}
