public class App {

    public static void test_CRUD() {
        // instance the object
        String filename = "crud.txt";
        FileCustom file = new FileCustom(filename);
        
        //open a file
        boolean res;
        res = file.open();
        if (res == false) {
            System.out.println("Error opening");
            return;
        }

        //get and update the counter line
        Integer counter = 0;
        while (file.hasNextLine()) {
            counter = Integer.parseInt(file.readLine());
        }
        ++counter;

        // update the file
        res = file.writeLine(Integer.toString(counter));
        if (res == false) {
            System.out.println("Error writing");
            return;
        }

        //close a file
        res = file.close();
        if (res == false) {
            System.out.println("Error closing");
            return;
        }

        System.out.println("Updated... file ["+filename+"] closed");
    }
    public static void main(String[] args) throws Exception {

        test_CRUD();

    }
}
