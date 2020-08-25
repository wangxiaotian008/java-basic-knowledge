package test.basic.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * inputstream类的skip方法测试
 * @author wangjq
 *
 */
public class IOSkipMethodTest {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Administrator\\Desktop\\skip.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			
			fis.skip(5);
			int length = fis.available();
			byte[] b = new byte[length];
			while(fis.read(b) !=-1){
				
			}
			System.out.println(new String(b));
			
			System.out.println("mark方法");
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("mark".getBytes());
			if(!byteArrayInputStream.markSupported()){
				throw new Exception("不支持mark方法");
			}
			int temp = 0;
			// mark方法标记该输入流，然后调用reset方法就会从该标记位置的下个位置开始读。
			while((temp = byteArrayInputStream.read()) != -1){
				if((char)temp == 'r'){
					byteArrayInputStream.mark(1);
					byteArrayInputStream.reset();
					break;
				}
			}
//			byte[] b1 = new byte[length];
//			while(byteArrayInputStream.read(b1) !=-1){
//				
//			}
//			System.out.println(new String(b1));
			while((temp = byteArrayInputStream.read()) != -1){
				System.out.println(temp);
			}
			System.out.println(System.getProperty("user.dir"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
