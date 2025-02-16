import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GetHtml
{
    public static void getHtmlForImage(String imagePath, String outputFolderPath, List<String> imagePaths, List<String> imgSource) throws IOException {
        String fileName = new File(imagePath).getName();
        String htmlFileName = outputFolderPath + File.separator + fileName.substring(0, fileName.lastIndexOf('.')) + ".html";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFileName))) {
            // HTML fejléc
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>Image Viewer</title>\n");
            // Navigacio
            writer.write("</head>\n");
            writer.write("<body>\n");
            //Start Page
            String holVan = imagePath.substring(imagePath.lastIndexOf("images"));

            int chr=0;
            for (int i = 1;i<holVan.length();i++)
            {
                if((""+holVan.charAt(i)).equals("\\")){
                    chr++;
                }
            }
            writer.write("<h1><a href='" + "../".repeat(chr-1) + "index.html'>Start Page</a></h1>\n");
            //Előző index
            writer.write("<a href=\"index.html\">^^</a>\n");
            writer.write("<br>");
            //Visszafele <==
            if (!imagePaths.isEmpty()) {
                String utolsoElem = imagePaths.get(imagePaths.size() - 1);
                writer.write("<a href=" + utolsoElem.substring(0, utolsoElem.lastIndexOf('.')) + ".html>" + "<=</a>\n");
            }
            writer.write("<p1> " + fileName +" </p1>\n");

            //Elore ==>
            if(imagePaths.size()+1<imgSource.size())
            {
                //System.out.println("## " + imgSource.get(imgSource.indexOf(fileName)));
                int pontIndex = imgSource.get(imgSource.indexOf(fileName)+1).indexOf('.');
                String kovOldal = imgSource.get(imagePaths.size()+1).substring(0, pontIndex) + ".html";
                writer.write("<a href="+kovOldal+ ">" + "=></a>\n");
                writer.write("<br>\n<br>\n");
                writer.write("<a href="+ kovOldal +"><img src='" + fileName + "' width=60% height=60%>\n");
                pontIndex = 0;
            }else{
                writer.write("<br>\n<br>\n");
                writer.write("<a href=" + fileName.substring(0,fileName.lastIndexOf(".")) + ".html><img src='" + fileName + "' width=50% height=50%>\n");
            }
            writer.write("</body>\n");
            writer.write("</html>\n");
        }
    }
}
