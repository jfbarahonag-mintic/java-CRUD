import java.io.FileWriter;

public class Write {

    private FileWriter file_ = null;
    private boolean opened_ = false;
    String filename_ = null;

    Write()
    {
        filename_ = "test_write";
    }

    Write(String filename)
    {
        filename_ = filename;
    }

    boolean open()
    {
        return open(filename_);
    }

    boolean open(String filename)
    {
        try {
            file_ = new FileWriter(filename);
            opened_ = true;
            
        } catch (Exception e) {
            opened_ = false;
        }

        return opened_;
    }

    boolean close()
    {
        if (opened_)
        {
            try {
                file_.close();
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
            file_.write(line);
            succeed = true;
        } catch (Exception e) {
            succeed = false;
        }

        return succeed;
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

        String[] fruits = {"Apple", "Pear", "Banana", "Orange"};
        
        for (String fruit : fruits) {
            res = writeLine(fruit + "\n"); 
            if(res == false)
            {
                System.out.println("Error writing");
                return;
            }      
        }

        res = close();
        if(res == false)
        {
            System.out.println("Error opening");
            return;
        }
    }
}
