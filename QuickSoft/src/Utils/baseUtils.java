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
 * ������
 * @author ��Ԩ
 *
 * 2017��5��12��
 */
public class baseUtils {

	static Scanner sc = new Scanner(System.in);
	static Random random = new Random();

	//�õ�һ���ַ���
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

	//��ӡ����
	public static void print(int[] n) {
		String str = "";
		for(int i : n) {
			str = str + i + ",";
		}
		str = str.substring(0, str.length()-1);
	}
	
	//��int����ת��Ϊchar����
	public static char[] IntArray2CharArray(int[] a) {
		char[] ch = new char[a.length];
		for(int i = 0; i < a.length; i++) {
			ch[i] = String.valueOf(a[i]).charAt(0);
		}
		return ch;
	}

	//�洢���鵽�ļ�
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
	
	//���ļ���һ��int����
	public static int[] read2Array(String url) {
		
		return null;
	}
	
	
}
