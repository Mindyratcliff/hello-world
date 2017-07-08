var img = new SimpleImage("duke_blue_devil.png");
function swapRedGreen(pixel) {
    var pixelR = pixel.getRed();
    var pixelG = pixel.getGreen();
    var pixelB = pixel.getBlue();
    pixel.setRed(255);
    pixel.setGreen(255);
    pixel.setBlue(0);
    
}

for (var pixelswap of img.values()) {
    var rValue = pixelswap.getRed();
    if (rValue == 0) {
		swapRedGreen(pixelswap);
	} else {
	    
	}
}

print(img);