import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlConverting
{
    public static void htmlConverter(File folder) throws IOException {
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("A megadott útvonal nem egy mappa.");
            return;
        }

        File[] files = folder.listFiles();
        if (files == null) {
            System.err.println("A "+ folder +" mappában nincsenek fájlok.");
            return;
        }
        List<String> imagePaths = new ArrayList<>();
        List<String> imgSource = new ArrayList<>();
        for (File file : files) {
            if(isImageFile(file))
                imgSource.add(file.getName());
        }
        for (File file : files) {
            if (file.isDirectory()) {
                // Rekurzív hívás az almappákhoz
                htmlConverter(file);
            } else if (isImageFile(file)) {
                // Csak  a képfájlok feldolgozása
                GetHtml.getHtmlForImage(file.getAbsolutePath(), folder.getAbsolutePath(),imagePaths,imgSource);
                imagePaths.add(file.getName());
            }
        }
        IndexPage.generateIndexHtml(folder.getAbsolutePath(), imagePaths);
    }
    private static boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".gif");
    }
}
