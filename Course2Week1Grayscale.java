import edu.duke.*;
import java.io.*;

public class Grayscale {
    
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage);
        for (Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    
            

}
public void selectAndConvert(){
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()){
        ImageResource inImage = new ImageResource(f);
        ImageResource gray = makeGray(inImage);
        gray.draw();
        doSave(gray);
    }
}
public void doSave(ImageResource image){
    String fname = image.getFileName();
    String newName = "gray-" + fname;
    image.setFileName(newName);
    image.save();