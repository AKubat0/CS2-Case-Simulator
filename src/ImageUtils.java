package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class ImageUtils {
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        int width = img.getWidth(null);
        int height = img.getHeight(null);
        if (width <= 0 || height <= 0) {
            return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        }

        BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bimage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setComposite(AlphaComposite.Src);
        g2d.drawImage(img, 0, 0, width, height, null);
        g2d.dispose();
        return bimage;
    }

    public static Image getScaledImage(Image srcImg, int maxWidth, int maxHeight, boolean allowUpscale) {
        int originalWidth = srcImg.getWidth(null);
        int originalHeight = srcImg.getHeight(null);

        if (originalWidth <= 0 || originalHeight <= 0) {
            return srcImg;
        }

        double widthRatio = (double) maxWidth / originalWidth;
        double heightRatio = (double) maxHeight / originalHeight;
        double ratio = Math.min(widthRatio, heightRatio);
        if (!allowUpscale) {
            ratio = Math.min(1.0, ratio);
        }

        int newWidth = Math.max(1, (int) Math.round(originalWidth * ratio));
        int newHeight = Math.max(1, (int) Math.round(originalHeight * ratio));

        if (newWidth == originalWidth && newHeight == originalHeight) {
            return toBufferedImage(srcImg);
        }

        BufferedImage scaledImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImg.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(srcImg, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return scaledImg;
    }

    public static ImageIcon getScaledIcon(ImageIcon srcIcon, int maxWidth, int maxHeight, boolean allowUpscale) {
        return new ImageIcon(getScaledImage(srcIcon.getImage(), maxWidth, maxHeight, allowUpscale));
    }
}
