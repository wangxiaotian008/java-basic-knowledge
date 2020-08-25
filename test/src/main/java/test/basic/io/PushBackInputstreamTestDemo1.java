package test.basic.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;

public class PushBackInputstreamTestDemo1 {

	public static void main(String[] args) {
		String s = "abcdefg";
        /*
         * PushbackInputStream pbin = new PushbackInputStream(in)
         * 这个构造函数创建的对象一次只能回推一个字节
         */
        try {
        	ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
            PushbackInputStream pbin = new PushbackInputStream(in);
            int n;
            while ((n = pbin.read()) != -1) {
                System.out.println((char) n);
                if('b' == n) pbin.unread('U');
            }
            /**
             * 回推之后再读该输入流读不到东西
             */
//            int count = pbin.available();
//            byte[] b = new byte[100];
//            int len = 0;
//            while((len=pbin.read(b)) != -1){
//            }
//            System.out.println(new String(b));
            
            /**
             * 一次回推多个字节
             */
            System.out.println("一次回推多个字节");
            ByteArrayInputStream in1 = new ByteArrayInputStream(s.getBytes());
            PushbackInputStream pbin1 = new PushbackInputStream(in1,3);
            int n1;
            byte[] b = new byte[3];
            while ((n1 = pbin1.read(b)) != -1) {
                System.out.println(new String(b));
                if(new String(b).equals("abc"))
                 pbin1.unread(new byte[]{'m','n','o'});
                b = new byte[3];
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
