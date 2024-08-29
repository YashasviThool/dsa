import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class file_reader {
    public static void main(String[] args) {
        // try (BufferedReader bReader = new BufferedReader(new
        // InputStreamReader(System.in));) {
        // String input = bReader.readLine();
        // System.out.println("Print statement added!");
        // System.out.println(input);
        // } catch (IOException e) {
        // // TODO: handle exception
        // }

        try (BufferedReader bReader = new BufferedReader(
                new FileReader("D:\\COLLEGE\\codes\\java\\dsa\\kunal khuswa\\hell.txt"));) {
            String a = bReader.readLine();
            while (a != null) {
                System.out.println(a);
                a = bReader.readLine();

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
