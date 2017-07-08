var img = new SimpleImage("usain.jpg");
function swapRedGreen(pixel) {
    var pixelR = pixel.getRed();
    var pixelG = pixel.getGreen();
        pixel.setRed(pixelG);
        pixel.setGreen(pixelR);
}

for (var pixelswap of img.values()) {
    swapRedGreen(pixelswap);
}

print(img);