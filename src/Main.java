import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        LineIterator iter1 = new LineIterator();
        String fileName = "present_instr_v5.asm";
        FileReader fReader = getFileReader(fileName);
        Scanner scanner = new Scanner(fReader);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine(); //TODO clean the comments out (check if there is tab or multiple spaces and convert to only one space)
            //System.out.println(line); //prints whole line
            //System.out.println(line.split(" ", 2)[0]); //prints the address of the instr or data
            //System.out.println(line.split(" ", 2)[1]); //prints the instr or data
            iter1.add(line);
        }
        scanner.close();

        LineIterator iter2 = new LineIterator();
        fileName = "present_data_v5.asm";
        fReader = getFileReader(fileName);
        scanner = new Scanner(fReader);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine(); //TODO clean the comments out (check if there is tab or multiple spaces and convert to only one space)
            iter2.add(line);
        }
        scanner.close();

        //TODO simulation part
        /*scanner = new Scanner(System.in);
        System.out.println("Enter sim type: ");
        int c = scanner.nextInt();
        scanner.close();*/

        /*VSCPU vscpu = new VSCPU(iter1, iter2);
        VSCPU.simulate(0); //simulate all = 0, simulate line = 1*/
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
}
