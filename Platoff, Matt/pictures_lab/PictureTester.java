import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("blue-mark.jpg");
		beach.explore();

	}

	public static Picture encode(String message) {
		Picture p = new Picture("arch.jpg");
p.show();
		int count = 0, blueCount;
		char toEncode;
		Pixel[] pAray = p.getPixels();
		for (int k = 0; k < message.length(); k++) {
			toEncode = message.charAt(k);
			blueCount = pAray[(count * 256) + toEncode].getBlue();
			pAray[(count * 256) + toEncode].setBlue(blueCount + 1);
			count++;
		}
		p.explore();
		return p;

	}

	public static String decode(Picture p) {
		Picture orig = new Picture("arch.jpg");
		Pixel[] pAray = p.getPixels();
		Pixel[] origAray = orig.getPixels();
		char[] c = new char[675];
		int count = 0;
		String rs;
		char letter;
		for (int k = 0; k < pAray.length; k++)
			if (pAray[k].getBlue() != origAray[k].getBlue()) {
				letter = (char) (k % 256);
				c[count++] = letter;
			}
		rs = new String(c);

		
		return rs;

	}

	public static void redCupRemove() {
      Picture orig=new Picture("rsc.jpg");
      Picture rpic;
      Pixel[] pArray= orig.getPixels();
      orig.explore();
      Color c = new Color(124, 22, 17);
      for (int p=0;p<pArray.length;p++){
    	  if (Pixel.colorDistance(c, pArray[p].getColor())>40);
    	  p.
      }

	}

	public static void testChromakey() {

		Picture bg = new Picture("beach.jpg");
		Picture original = new Picture("blue-mark.jpg");

		Color c = new Color(19, 38, 80);

		for (int h = 0; h < original.getHeight(); h++) {
			for (int w = 0; w < original.getWidth(); w++) {
				if (Pixel.colorDistance(c, original.getPixel(w, h).getColor()) < 40)
					original.setBasicPixel(w, h, bg.getBasicPixel(w, h));
			}
		}

		original.explore();

	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		// testChromakey();
		//System.out.println(decode(encode("ayyyyyyyyyy lmaoooooo")));
		redCupRemove();
		// testZeroBlue();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		// testMirrorVertical();
		// testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		// testCollage();
		// testCopy();
		// testEdgeDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
	}
}