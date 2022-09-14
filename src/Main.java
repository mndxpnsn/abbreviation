public class Main {
    public static void main(String[] args) {

        // Input Strings
        String a = "hHhAhhcahhacaccacccahhchhcHcahaahhchhhchaachcaCchhchcaccccchhhcaahhhhcaacchccCaahhaahach";
        String b = "HAHHCH";
        
        // Compute if string a can be converted to string b
        Results solObj = new Results();

        String canConvert = solObj.abbreviation(a, b);

        // Print results
        System.out.println("res: " + canConvert);
    }
}