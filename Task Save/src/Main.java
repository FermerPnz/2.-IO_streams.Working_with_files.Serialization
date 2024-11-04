import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args){
        GameProgress games_1 = new GameProgress(34, 45, 56, 6788);
        GameProgress games_2 = new GameProgress(23, 45, 67, 897);
        GameProgress games_3 = new GameProgress(456, 456, 678, 7546);
        saveGame("D:\\Games\\savegames\\games_1.txt", games_1);
        saveGame("D:\\Games\\savegames\\games_2.txt", games_2);
        saveGame("D:\\Games\\savegames\\games_3.txt", games_3);
        ArrayList<String> arr = new ArrayList<>();
        arr.add("D:\\Games\\savegames\\games_1.txt");
        arr.add("D:\\Games\\savegames\\games_2.txt");
        arr.add("D:\\Games\\savegames\\games_3.txt");
        zipFiles("D:\\Games\\savegames\\games.zip", arr);
        delFile(arr);


    }

    public static void saveGame(String paches, GameProgress games){
        try (FileOutputStream fos = new FileOutputStream(paches);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(games);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void zipFiles(String fileZip, ArrayList<String> put){
        try( ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(fileZip))) {
            for (String arr : put) {
                try (FileInputStream fis = new FileInputStream(arr)) {
                    ZipEntry entry = new ZipEntry(arr);
                    zos.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    zos.write(fis.read(buffer));
                }
                zos.closeEntry();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void delFile(ArrayList<String> file) {
       try {
           for (String arr : file) {
               File x = new File(arr);
               if (x.delete()) {
                   System.out.println("Файл " + x + " удален");
               } else
                   System.out.println("Файл " + x + " невозможно удалть");
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

    }
}



