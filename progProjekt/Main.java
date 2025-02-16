import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    private static String theFolder;
    public static void main(String[] args) {
        if(args.length!=1) {
            System.out.println("Hiba! Nem megfelelő argumentum!");
            System.exit(1);
        }
        String mainFolderPath = args[0]; //mappa elerhetosege
        theFolder = mainFolderPath;
        System.out.println("HTML generátor képekből v0.2");
        System.out.println("Miklo Aron\n");
        IndexPage indexPage = new IndexPage(mainFolderPath);
        try {
            HtmlConverting.htmlConverter(new File(mainFolderPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("~ A HTML oldalak generálása megtörtént!\n");

    }
}