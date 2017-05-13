package Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;


/**
 * 工具类
 * @author 罗渊
 *
 * 2017年5月12日
 */
public class baseUtils {

	static Scanner sc = new Scanner(System.in);
	static Random random = new Random();

	//得到一个字符串
	public static int getIntNumber() {
		return sc.nextInt(); 
	}
	
	public static int[] getRandomIntArray(int n) {
		int[] a = new int[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(10000);
		}
		return a;
	}

	//打印数组
	public static void print(int[] n) {
		String str = "";
		for(int i : n) {
			str = str + i + ",";
		}
		str = str.substring(0, str.length()-1);
	}
	
	//将int数组转化为char数组
	public static char[] IntArray2CharArray(int[] a) {
		char[] ch = new char[a.length];
		for(int i = 0; i < a.length; i++) {
			ch[i] = String.valueOf(a[i]).charAt(0);
		}
		return ch;
	}

	//存储数组到文件
	public static String save2File(int[] n) throws IOException {
		String fileName = "d:\\" + n.length  + ".txt";
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i < n.length; i++) {
			bw.write(String.valueOf(n[i]) + "\r\n");
		}
		bw.close();
		fw.close();
		return fileName;
	}
	
	//读文件到一个int数组
	public static int[] read2Array(String url) {
		
		return null;
	}
	
	
}
