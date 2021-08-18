import java.io.FileWriter;

public class Write {

    private FileWriter file_ = null;
    private boolean opened_ = false;

    Write()
    {
        //open();
    }

    Write(String filename)
    {
        open(filename);
    }

    boolean open()
    {
        return open("test_write");
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
            writeLine(fruit + "\n");    
        }

        res = close();
        if(res == false)
        {
            System.out.println("Error opening");
            return;
        }
    }
}
