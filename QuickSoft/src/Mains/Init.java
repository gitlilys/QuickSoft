package Mains;

import java.io.IOException;

import Utils.baseUtils;

public class Init {

	public static String creatText(int n) {
		String output = "";
		try {
			//����һ������Ϊn���������
			int[] v = baseUtils.getRandomIntArray(n);
			//������������һ���ļ�
			String URL = baseUtils.save2File(v);
			output = "���ɳɹ�������" + v.length + "���������" + "\n" +
					"·����" + URL;
			
			//ִ�п�������
//			int[] sortV = qSort(v);
			//�����������д���ļ�
//			String sortURL = baseUtils.save2File(sortV);
//			System.out.println("����ɹ���");
//			System.out.println("·����" + URL);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
}
