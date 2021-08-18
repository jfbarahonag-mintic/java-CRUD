import java.io.File;
import java.util.Scanner;


public class Read implements CustomFile {

    private File file_ = null;
    private Scanner sc_ = null;
    private boolean opened_ = false;
    private String filepath_ = null;

    Read() 
    {
        filepath_ = "README.md";
    }

    Read(String path)
    {
        filepath_ = path;
    }

    public boolean open()
    {
        return open(filepath_);
    }

    private boolean open(String path)
    {
        try {
            file_ = new File(path);
            sc_= new Scanner(file_);
            opened_ = true;
        } catch (Exception e) {
            opened_ = false;
        }
        
        return opened_;
    }
    
    public boolean close()
    {
        if (opened_)
        {
            try {
                sc_.close();
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

    public boolean hasNextLine()
    {
        if(opened_)
        {
            return sc_.hasNextLine();
        }

        return false;
    }
    
    public String nextLine()
    {
        if(opened_)
        {
            return sc_.nextLine();
        }

        return null;
    }

    public void test()
    {
        boolean res;
        res = open();
        if(res == false)
        {
            System.out.println("Error opening");
            return;
        }
        while(hasNextLine())
        {
            String line = nextLine();
            System.out.println(line);
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
        return nextLine();
    }

    @Override
    public boolean writeLine(String line) {
        // TODO Auto-generated method stub
        return false;
    }
}
