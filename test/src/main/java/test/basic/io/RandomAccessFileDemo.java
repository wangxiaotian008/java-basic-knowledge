package test.basic.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile是Java中输入，输出流体系中功能最丰富的文件内容访问类，
 * 它提供很多方法来操作文件，包括读写支持，与普通的IO流相比，它最大的特别之处就是支持任意访问的方式，程序可以直接跳到任意地方来读写数据。
 * @author wangjq
 *
 */
public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(new File("C:\\Users\\Administrator\\Desktop\\skip.txt"), "rw");
		randomAccessFile.seek(randomAccessFile.length());
//		randomAccessFile.write("追加".getBytes());
		randomAccessFile.seek(3); // seek方法的参数是以字节记录的
		System.out.println((char)randomAccessFile.read());
		/**
		 *  可以在任意位置插入内容
		 *  1.首先通过seek方法找到位置，然后通过read方法来读取后面的数据存到一个临时文件里，然后开始写要插入的数据。最后再把存到临时文件里的数据写到原文件
		 */
		

		byte[] s = "输出流体系中功能最丰富的文件内容访问类".getBytes();
		File f = new File("C:\\Users\\Administrator\\Desktop\\skip.txt");
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(s);
		fos.flush();
		fos.close();
	}

}
