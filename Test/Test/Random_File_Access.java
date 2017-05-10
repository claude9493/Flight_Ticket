package Test;

/**
 * I use this class to test the use of RandomAccessFile:
 * writeChars will write String in a SBC case(quanjiao)
 * writeBytes write String in a DBC case(banjiao)
 * and in the write method, you need \r\n to make a general "\n"
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Random_File_Access {
	
	public static void main(String[] a) throws Exception{
		RandomAccessFile w = new RandomAccessFile("Test.txt","rw");
		w.seek(w.length());
		w.writeBytes(String.format("%s %d %f\r\n", "Hello", 100, 0.001));
	}

}
