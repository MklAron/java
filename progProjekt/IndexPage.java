import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexPage {
    private static String theFolder;

    public static void generateIndexHtml(String folderPath, List<String> imagePaths) throws IOException {
        String indexHtmlFileName = folderPath + File.separator + "index.html";
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(indexHtmlFileName))) {
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>Image Gallery</title>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            //Start Page

            String holVan =folderPath.substring(folderPath.lastIndexOf("images"));
            int cnt=0;
            for (int i = 0;i<holVan.length();i++)
            {
                if((""+holVan.charAt(i)).equals("\\")){
                    cnt++;
                }
            }
            writer.write("<h1><a href='" + "../".repeat(cnt) + "index.html'>Start Page</a></h1>\n");
            writer.write("<hr>\n");

            //Directories
            writer.write("<h1>Directories:</h1>\n");
            writer.write("<ul>\n");

            //Elöző mappa
            if (!folderPath.equals(theFolder))
            {
                writer.write("<a href=../index.html><<</a>\n");
            }
            File[] subFolders = new File(folderPath).listFiles(File::isDirectory);
            if (subFolders != null) {
                for (File subFolder : subFolders) {
                    writer.write("<li><a href='" + subFolder.getName() + "/index.html'>" + subFolder.getName() + "</a></li>\n");
                }
            }
            writer.write("</ul>\n");
            writer.write("<hr>\n");

            // Images
            writer.write("<h1>Images:</h1>\n");
            writer.write("<ul>\n");
            for (String imagePath : imagePaths) {
                writer.write("<li><a href='" + imagePath.substring(0, imagePath.lastIndexOf('.')) + ".html'>" + imagePath + "</a></li>\n");
            }
            writer.write("</ul>\n");
            writer.write("</body>\n");
            writer.write("</html>");
        }
    }

    public IndexPage(String theFolder) {
        this.theFolder = theFolder;
    }
}
