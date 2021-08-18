public interface FileBasic {
    public boolean open();
    public boolean close();
    public boolean writeLine(String line);
    public String readLine();
}
