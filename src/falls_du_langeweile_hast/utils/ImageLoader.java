package falls_du_langeweile_hast.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class ImageLoader {
    public static Image getImage(String path, String image) {
        Image img = null;
        try {
            img = ImageIO.read(Objects.requireNonNull(ImageLoader.class.getResource(path + image)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }
    public static Icon getIcon(String path, String image) {
        return new ImageIcon(getImage(path,image));
    }
}
