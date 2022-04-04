package application;

import java.awt.Color;

import picture.Picture;

public class Filter {
	private Picture picture;

	public Filter(Picture picture) {
		this.picture = picture;
	}

	/**
	 * The input picture should be converted to a grey scale. To achieve a grey
	 * image we need to sum up the red, green and blue value and divide it by 3.
	 * 
	 * @return converted picture
	 */
	public Picture greyScaleFilter() {
		/*
			your code here
		*/
		for (int col = 0; col < picture.width(); col++){
			for (int row = 0; row < picture.height(); row++) {
				int value = picture.get(col, row).getRed()+picture.get(col,row).getBlue() + picture.get(col,row).getGreen();
				picture.set(col,row,new Color(value/3,value/3,value/3));
			}
		}




		return picture;
	}

	/**
	 * As we have a range until 255 inclusive getting the inverted image is easy.
	 * Just subtract the color value from 255.
	 * 
	 * @return converted picture
	 */
	public Picture revertColorFilter() {
		/*
			your code here
		*/
		int r,g,b;
		for (int col = 0; col < picture.width(); col++){
			for (int row = 0; row < picture.height(); row++) {
				r = 255-picture.get(col,row).getRed();
				g = 255-picture.get(col,row).getGreen();
				b = 255-picture.get(col,row).getBlue();
				picture.set(col,row,new Color(r, g, b));
			}

		}
		return picture;
	}

	//@formatter:off
	/**
	 * A sepia filter is a little more difficult to calculate.
	 * to get the
	 * 
	 * sepia red: (current red * 0.393) + (current green * 0.769) + (current blue * 0.189)
	 * sepia green: (current red * 0.349) + (current green * 0.686) + (current blue * 0.168)
	 * sepia blue: (current red * 0.292) + (current green * 0.534) + (current blue * 0.131)
	 * 
	 * the new value is then Math.min(sepia red, 255) and so on.
	 * 
	 * @return converted picture
	 */
	//@formatter:on

	public Picture sepiaFilter() {
		/*
			your code here
		*/

		int r,g,b, sepR, sepG, sepB;
		for (int col = 0; col < picture.width(); col++){
			for (int row = 0; row < picture.height(); row++) {
				r = picture.get(col,row).getRed();
				g = picture.get(col,row).getGreen();
				b = picture.get(col,row).getBlue();

				sepR = (int)((r * 0.393) + (g * 0.769) + (b * 0.189));
				sepG = (int)((r * 0.349) + (g * 0.686) + (b * 0.168));
				sepB = (int)((r * 0.292) + (g * 0.534) + (b * 0.131));

				picture.set(col,row,new Color(Math.min(sepR, 255), Math.min(sepG, 255),Math.min(sepB, 255)));
			}

		}

		return picture;
	}
}
