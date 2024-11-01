import java.io.File;
public class Dir {

    public File CreadeDir (File Dir) {
        if (Dir.mkdir()) {
            System.out.println("dfgdfgdfg" + Dir + "dsfgdfgdfg");
        } else {
            System.out.println("dfgdfgdfg" + Dir + "dgdfgdfgd");
        }


        return Dir;
    }
}
