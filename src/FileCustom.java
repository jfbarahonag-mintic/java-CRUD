import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileCustom implements FileBasic {
    private String filename_ = null;
    private File file_ = null;
    private Scanner sc_ = null;
    private FileWriter file_w_ = null;
    private boolean opened_ = false;

    FileCustom()
    {
        filename_ = "names.txt";
    }

    FileCustom(String filename)
    {
        filename_ = filename;
    }

    public boolean open() {
        return open(filename_);
    }

    public boolean open(String filename)
    {
        try {
            // this order is very important!!
            file_ = new File(filename);
            file_w_ = new FileWriter(filename, true);
            sc_ =  new Scanner(file_);
            opened_ = true;
        } catch (Exception e) {
            opened_ = false;
        }
        return opened_;
    }

    public boolean close() {
        if(opened_)
        {
            try {
                sc_.close();
                file_w_.close();
                opened_ = false;
            } catch (Exception e) {
                opened_ = true;
            }
            return !opened_;
        }
        else
        {
            return false;
        }
    }

    public boolean writeLine(String line)
    {
        boolean succeed = false;
        try {
            file_w_.write(line + '\n');
            succeed = true;
        } catch (Exception e) {
            succeed = false;
        }

        return succeed;
    }

    public boolean hasNextLine()
    {
        return sc_.hasNextLine();
    }

    public void test() {
        boolean res;
        res = open();
        if(res == false)
        {
            System.out.println("Error opening");
            return;
        }

        String names[] = {"Juan", "Felipe", "Viviana", "Pepito"};

        for (String name : names) {
            res = writeLine(name + '\n');
            if(res == false)
            {
                System.out.println("Error writing");
                return;
            }
        }

        res = close();
        if(res == false)
        {
            System.out.println("Error closing");
            return;
        }

    }

    @Override
    public String readLine() {
        return sc_.nextLine();
    }
}
