package glyphPack;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;

public class ShowGlypths {
	private static String hexToBin(String s) {
		  return new BigInteger(s, 16).toString(2);
		}
	private static String addHexToBinString(String s, int hex) {
		int temp = Integer.parseInt(s, 2) + hex;
		return Integer.toHexString(temp);
	}
	public static String getRandomGlyph() {
		String hex_lead;
		String hex_tail;
		Random rand = new Random();
		hex_lead = Integer.toHexString(rand.nextInt(0x13000,0x13111) - 0x10000);		
		hex_lead = hexToBin(hex_lead);
		hex_tail = hex_lead.substring(hex_lead.length()-10,hex_lead.length());
		hex_lead = hex_lead.substring(0,hex_lead.length()-10);
		hex_tail = addHexToBinString(hex_tail, 0xDC00);
		hex_lead = addHexToBinString(hex_lead, 0xD800);
		char[] glyph_left = Character.toChars(Integer.decode("0x" + hex_lead));
		char[] glyph_right = Character.toChars(Integer.decode("0x" + hex_tail));
		String gs_left = new String(glyph_left);
		String gs_right = new String(glyph_right);
		//System.out.println(hex_tail);
		//System.out.println(hex_lead);

		String glyph = gs_left + gs_right;
		return glyph;
	}
	  
	public static void main(String[] args) {
		int height = 10;
		int width = 20;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				System.out.print(getRandomGlyph());
			}
			System.out.println();
		}

		
	}

}
