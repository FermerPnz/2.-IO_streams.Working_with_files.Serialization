import java.io.*;
import java.sql.Array;
import java.sql.Time;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("e://Games"),
                new File("e://Games//temp"),
                new File("e://Games//src"),
                new File("e://Games//res"),
                new File("e://Games//savegames"),
                new File("e://Games//src//main"),
                new File("e://Games//src//test"),
                new File("e://Games//res//drawables"),
                new File("e://Games//res//vectors"),
                new File("e://Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("e://Games//src//main//Main.java"),
                new File("e://Games//src//main//Utils.java"),
                new File("e://Games//temp//temp.txt")
        );


        folderList.forEach(x->{
            if (x.mkdir()){
                System.out.println(STR."Папка \{x} создана");
              sb.append("Папка ").append(x).append(" cоздана     ").append(ZonedDateTime.now()).append("\n");
            } else
                System.out.println(STR."Папка \{x} уже создана");
                sb.append("Папка ").append(x).append(" уже создана     ").append(ZonedDateTime.now()).append("\n");
        });

        fileList.forEach(x->{
            try {
                if (x.createNewFile()){
                    System.out.println(STR."Файл \{x} создан");
                    sb.append("Файл ").append(x).append(" cоздана    ").append(ZonedDateTime.now()).append("\n");
                } else
                    System.out.println(STR."Файл \{x} уже создан");
                    sb.append("Файл ").append(x).append(" уже создана     ").append(ZonedDateTime.now()).append("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        FileWriter writer = new FileWriter("e://Games//temp//temp.txt", true);
        writer.write(sb.toString());
        writer.close();





//        for (File x : folderList) {
//            if (x.mkdir()) {
//                System.out.println(STR."Папка \{x} создана");
//                sb.append("Папка ").append(x).append(" создан\n");
//            }
//            else
//            System.out.println(STR."Папка \{x} уже создана");
//            sb.append("Папка ").append(x).append(" уже создан\n");
//
//        }
//        for (File x : fileList) {
//            if (x.createNewFile()) {
//                System.out.println(STR." Файл \{x} создан");
//                sb.append("Файл ").append(x).append(" создан\n");
//            }
//            else
//                System.out.println(STR." Файл \{x} уже создана");
//            sb.append(" Файл ").append(x).append(" уже создан\n");
//
//        }
//
//        try (FileWriter log = new FileWriter("e://Games//temp//temp.txt", true)) {
//            log.write(sb.toString());
//            log.flush();
//        } catch (IOException ex) {
//            sb.append(ex.getMessage() + '\n');
//        }
//        try (BufferedReader br = new BufferedReader(new FileReader("e://Games//temp//temp.txt"))) {
//            String s;
//            while ((s = br.readLine()) != null) System.out.println(s);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    public static File CreadeDir(File Dir){
//        if (Dir.mkdir()) {
//            System.out.println(new File(STR."Папка \{Dir} создана"));
//          return new File(STR."Папка \{Dir} создана" + ZonedDateTime.now());
//
//        } else {
//            System.out.println(new File(STR."Папка \{Dir} уже создана \n"));
//           return new File(STR."Папка \{Dir} уже создана " + ZonedDateTime.now() + "\n");
//        }
//    }

//    public static File CreadeFile(File File) throws IOException {
//        if (File.createNewFile()) {
//
//            return new File(STR."Файл \{File} создана");
//        } else {
//            return new File(STR."Файл \{File} уже создана");
//        }
//
//    }

//    public static File LogFile (File logFolder, File logFile ) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        sb.append(logFolder);
//        sb.append(logFile);
//        FileWriter t = new FileWriter("E:\\Games\\temp\\temp.txt ", true);
//        t.write(sb.toString());
//  t.close();
//        return null;
//    }

    }
}



