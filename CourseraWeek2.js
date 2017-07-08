
var img = new SimpleImage("duke_blue_devil.png");
var w = img.getWidth();

for (var pixel of img.values()) {
	var xcoordinate = pixel.getX();
    if (xcoordinate <= (w/3)) {
		pixel.setRed(255);
	} else if(xcoordinate >= (w/3) && xcoordinate <= (w/3)*2){
		pixel.setGreen(255);
	} else {
		pixel.setBlue(255);
	}
}

print(img);