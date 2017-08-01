import edu.duke.*;
import java.io.*;

public class Invert {
    
    public ImageResource invertImage(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage);
        for (Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int number = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen());
            pixel.setRed(255 - number);
            pixel.setGreen(255 - number);
            pixel.setBlue(255 - number);
        }
        return outImage;
    
            

}
public void selectAndConvert(){
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()){
        ImageResource inImage = new ImageResource(f);
        ImageResource invert = invertImage(inImage);
        invert.draw();
        doSave(invert);
    }
}
public void doSave(ImageResource image){
    String fname = image.getFileName();
    String newName = "invert-" + fname;
    image.setFileName(newName);
    image.save();
}
}