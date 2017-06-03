package Mains;

import java.io.IOException;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import Utils.baseUtils;

/**
 * ����������
 * @author ��Ԩ
 *
 * 2017��5��13��
 */
public class quickSort {

		
	 	public void qSort(int n[],int low,int high)  
	 	{  
	 		if(low > high) return ;
	 		//lowrecord��highrecord��¼��ʼ�������ұ߽��±�
	 	    int lowRecord = low;  
	 	    int highRecord = high;  
	 	    //left��right�ֱ��ʾ����������Ҫ������key(��׼Ԫ��)���Ԫ�ص�λ��
	 	    int left = low;  
	 	    int right = high;  
	 	    //�������߳�����key��ȵĸ���
	 	    int leftLen = 0;  
	 	    int rightLen = 0;  
	 	    
	 	    
	 	    
	 	    //һ�ηָ�  
	 	    int key = MedianOfThree(n,low,high);//ʹ������ȡ�з�ѡ���׼��(Ĭ�ϻὫ�ҵ��Ļ�׼Ԫ�طŵ�n[low]���棬���������Ļ����㷨)  
	 	    while(low < high)
	 	    {  
	 	    	
	 	    	//��һ��ʹ�ұߵĶ���key��
	 	        while(high > low && n[high] >= key)  
	 	        {  
	 	            if (n[high] == key)//�������Ԫ��
	 	            {  
	 	            	//����ǰ��key��ȵ�(high)�����ұߵ�(right)���������ǰ�high�������,ͬʱright��һ����right��high����ͬ���仯��hignС�ڵ���right
	 	                swap(n, right, high); 
	 	                right--;//rightֻ���ڳ�����key���Ԫ��ʱ�Ż���
	 	                rightLen++;  //�ұ߳�����key���Ԫ�صĸ���
	 	            }  
	 	            high--;
	 	        }
	 	        if(low < high) {
	 	        	n[low++] = n[high]; 
	 	        }
	 	        //�ڶ���whileʹ��ߵĶ���keyС
	 	        while(high > low && n[low] <= key)  
	 	        {  
	 	            if (n[low] == key)  
	 	            {  
	 	                swap(n, left, low); 
	 	                left++;//left��low�ߵ���
	 	                leftLen++;//��߳�����key���Ԫ�صĸ���
	 	            }  
	 	            low++;  
	 	        }  
	 	       if(low < high) {
	 	    	   n[high--] = n[low];
	 	       }
	 	    }  
	 	    n[low] = key;
	 	    
	 	    
	 	    //һ�ο��Ž���  
	 	    //��������key��ͬ��Ԫ���Ƶ���������λ����Χ
	 	    
	 	    
	 	    //low���ǵ�ǰ��׼Ԫ�����ڵ�λ��
	 	    //�Ȼ���ߣ���ǰ��key��ȵ�Ԫ�ش�low-1���ν������low֮ǰ
	 	    int i = low - 1;
	 	    int j = lowRecord;  
	 	    while(j < leftLen && n[i] == key)  
	 	    {  
	 	        swap(n, i, j); 
	 	        i--;  
	 	        j++;  
	 	    }
	 	    
	 	    //�ٻ��ұߣ��Ѻ�key��ȵ�Ԫ�ش�low+1�����������low֮��(���򡢽���ָ�±�)
	 	    i = low + 1;  
	 	    j = highRecord;
	 	    while(j < rightLen && n[i] == key)  
	 	    {  
	 	    	swap(n, i, j);   
	 	        i++;  
	 	        j--;  
	 	    }  
	 	    
	 	    //��ֹ������ȫ�ظ����飬��һ�λ���ֱ��ʹlow=0,����low-1-leftLen=-1,����Խ��
	 	    if((low-1-leftLen) > 0){
	 	    	qSort(n,lowRecord,low - 1 - leftLen); 
	 	    }
	 	    
	 	    if((low+1+rightLen) < highRecord){
	 	    	qSort(n,low + 1 + rightLen,highRecord);  
	 	    }
	 	    
	 	}  

	 	
	    
		/*�������ã�ȡ������������low��mid��high����λ�������ݣ�ѡȡ�����м���Ǹ�������Ϊ����*/  
		static int MedianOfThree(int n[],int low,int high)  
		{  
			//���������м��Ԫ�ص��±�  
			int mid = (low+high)/2;
			
			//ʹ������ȡ�з�ѡ������  
			if (n[mid] > n[high])//Ŀ��: n[mid] <= n[high]  
			{  
				swap(n,mid,high);  
			}  
			if (n[low] > n[high])//Ŀ��: n[low] <= n[high]  
			{  
				swap(n,low,high); 
			}  
			if (n[mid] > n[low]) //Ŀ��: n[low] >= n[mid]  
			{  
				swap(n,mid,low);  
			}  
			//��ʱ��n[mid] <= n[low] <= n[high]  
			return n[low];
			//low��λ���ϱ���������λ���м��ֵ  
			//�ָ�ʱ����ֱ��ʹ��lowλ�õ�Ԫ����Ϊ���ᣬ�����øı�ָ����  
		}
		
		//����
		static void swap(int n[],int x,int y){
			
			int t;
			t = n[x] ;
			n[x] = n[y] ;
			n[y] = t ; 
	
		}
	    
}


	
