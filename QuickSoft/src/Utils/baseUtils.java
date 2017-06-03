package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;
import org.junit.Test;



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
	
	//得到一个随机数数组
	public static int[] getRandomIntArray(int n) {
		int[] a = new int[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(1000000);
		}
		return a;
	}
	
	
	//得到升序数组
	public static int[] getAscendIntArray(int n) {
		int[] a = new int[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = i+1;
		}
		return a;
	}
	
	
	//得到降序数组
	public static int[] getDescendIntArray(int n) {
		int[] a = new int[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = a.length-i;
		}
		return a;
	}

	
	//得到重复数组
	public static int[] getRepeatIntArray(int n) {
		int[] a = new int[n];
		int temp = random.nextInt(10000);
		for(int i = 0; i < a.length; ) {
			a[i] = temp;
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
		String fileName = "d:\\" + "\\" + n.length  + ".txt";
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
		File file = new File(url);
		FileReader fr;
		int[] n = null;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<Integer> ar = new ArrayList<Integer>();
			String str = "";
			while((str=br.readLine()) != null) {
				ar.add(Integer.parseInt(str));
			}
			Integer[] it = new Integer[ar.size()];
			ar.toArray(it);
			n = ArrayUtils.toPrimitive(it);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//得到一个UUID
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	//将纳秒转化为毫秒
	public static double nanoTime2MillsTime(long time) {
		int length = 0;
		long temp = time;
		while(temp > 0) {
			length++;
			temp /= 10;
		}
		long z = time / 1000000;
		long x = time % 1000000;
		x = Long.parseLong(Long.toString(x).substring(0, 3));
		String str = z + "." + x;
		return Double.parseDouble(str);
	}
	
	
}
