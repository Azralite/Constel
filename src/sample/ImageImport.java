package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Objects;

public class ImageImport {

    //On commence avec 20 constellations
    private Image[] tabImgLabel = new Image[20];
    private Image[] tabImgEmpty = new Image[20];

    //On a un tableau de Str qui represente les noms possibles
    private String[] tapName = new String[20];


    public ImageImport(){
        final File dir = new File("/home/paul/IdeaProjects/Constel/img/empty");
        final File dir2 = new File("/home/paul/IdeaProjects/Constel/img/labeled");

        final FilenameFilter IMAGE_FILTER = (file, s) -> s.endsWith(".jpg");

        int i =0;
        for (final File f : Objects.requireNonNull(dir.listFiles(IMAGE_FILTER))) {
            try {
                tabImgEmpty[i] = SwingFXUtils.toFXImage(ImageIO.read(f), null); //TODO Ca fait une erreur : faut changer!
                tapName[i] = f.getName();
                tapName[i] = tapName[i].split("_empty")[0];
                i++;
            }
            catch (final IOException e) {
                System.out.println("C'est la merde!");
            }
        }
        i=0;
        for (final File f : Objects.requireNonNull(dir2.listFiles(IMAGE_FILTER))) {
            try {
                tabImgLabel[i] = SwingFXUtils.toFXImage(ImageIO.read(f), null); //TODO Ca fait une erreur : faut changer!
                i++;
            }
            catch (final IOException e) {
                System.out.println("C'est la merde!");
            }
        }
    }


    public Image[] getTabImgLabel(){
        return tabImgLabel;
    }

    public Image[] getTabImgEmpty() {
        return tabImgEmpty;
    }

    public String[] getTapName() {
        return tapName;
    }
}
