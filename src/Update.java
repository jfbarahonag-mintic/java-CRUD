import java.io.FileWriter;

public class Update {
    private String filename_ = null;
    private FileWriter file_ = null;
    private boolean opened_ = false;

    Update()
    {
        filename_ = "names.txt";
    }

    Update(String filename)
    {
        filename_ = filename;
    }

    public boolean open() {
        return open(filename_);
    }

    public boolean open(String filename)
    {
        try {
            file_ = new FileWriter(filename, true);
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
}
