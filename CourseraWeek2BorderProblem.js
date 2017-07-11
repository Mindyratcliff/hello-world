var img = new SimpleImage ("smallpanda.png");
function setBlack (pixel) {
    pixel.setRed(0);
    pixel.setGreen(0);
    pixel.setBlue(0);
}
function addBorder (image, border) {
    
    for (var pixel of image.values()) {
        if (pixel.getX() <= border ) {
        setBlack (pixel);
            
        }
        if (pixel.getX () >= (image.getWidth() - border)) {
            setBlack (pixel);
        } 
        if (pixel.getY() <= border){
        setBlack (pixel);
        }
        if (pixel.getY () >= (image.getHeight() - border)) {
            setBlack (pixel);
        }
        
    }
}
addBorder (img, 10);
print (img);