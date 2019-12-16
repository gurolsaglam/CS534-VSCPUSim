import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LineIterator iter1 = new LineIterator();
        Scanner scanner = getScanner("test_instr.asm");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String usableLine = deleteCommentsAndFixSpaces(line);
            //System.out.println(line.split(" ", 2)[0]); //prints the address of the instr or data
            //System.out.println(line.split(" ", 2)[1]); //prints the instr or data
            iter1.add(usableLine);
        }
        scanner.close();

        LineIterator iter2 = new LineIterator();
        Scanner scanner2 = getScanner("test_data.asm");
        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            String usableLine = deleteCommentsAndFixSpaces(line);
            iter2.add(usableLine);
        }
        scanner2.close();

        //TODO simulation part
        /*scanner = new Scanner(System.in);
        System.out.println("Enter sim type: ");
        int c = scanner.nextInt();
        scanner.close();*/

        VSCPU vscpu = new VSCPU(iter1, iter2);
        vscpu.simulate(0); //simulate all = 0, simulate line = 1
    }

    private static FileReader getFileReader(String fileName) {
        FileReader fReader = null;
        try {
            URL path = Main.class.getResource(fileName);
            File f = new File(path.getFile());
            fReader = new FileReader(f);
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found, maybe the file is not in the same directory?");
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println("The file was not found, maybe the file is not in the same directory?");
            System.exit(1);
        }
        return fReader;
    }

    private static String deleteCommentsAndFixSpaces(String str) {
        str = str.split("//")[0];
        str = str.trim().replaceAll("\t", " ");
        str = str.trim().replaceAll(" +", " ");
        return str;
    }
    private static Scanner getScanner(String str){
        String fileName = str;
        FileReader fReader = getFileReader(fileName);
        Scanner scanner = new Scanner(fReader);
        return scanner;
    }
}