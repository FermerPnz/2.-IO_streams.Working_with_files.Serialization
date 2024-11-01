import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

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


        folderList.forEach(x -> {
            if (x.mkdir()) {
                System.out.println(STR."Папка \{x} создана");
                sb.append("Папка ").append(x).append(" cоздана     ").append(ZonedDateTime.now()).append("\n");
            } else
                System.out.println(STR."Папка \{x} уже создана");
            sb.append("Папка ").append(x).append(" уже создана     ").append(ZonedDateTime.now()).append("\n");
        });

        fileList.forEach(x -> {
            try {
                if (x.createNewFile()) {
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

    }
}



