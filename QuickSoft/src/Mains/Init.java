package Mains;

import java.io.IOException;

import Utils.baseUtils;

/**
 * 
 * @author ��Ԩ
 *
 * 2017��6��1��
 */
public class Init {


	public static String creatRandomText(int n) {
		String output = "";
		try {
			//����һ������Ϊn���������
			int[] v = baseUtils.getRandomIntArray(n);
			//������������һ���ļ�
			String URL = baseUtils.save2File(v);
			output = "���ɳɹ�������" + v.length + "���������" + "\n" +
					"·����" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
}
