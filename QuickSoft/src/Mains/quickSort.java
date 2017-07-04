package Mains;

import java.io.IOException;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import Utils.baseUtils;

/**
 * 快速排序类
 * @author 罗渊
 *
 * 2017年5月13日
 */
public class quickSort {

		
	 	public void qSort(int n[],int low,int high)  
	 	{  
	 		if(low > high) return ;
	 		//lowrecord和highrecord记录初始数组左右边界下标
	 	    int lowRecord = low;  
	 	    int highRecord = high;  
	 	    //left和right分别表示左右两边需要保存与key(基准元素)相等元素的位置
	 	    int left = low;  
	 	    int right = high;  
	 	    //左右两边出现与key相等的个数
	 	    int leftLen = 0;  
	 	    int rightLen = 0;  
	 	    
	 	    
	 	    
	 	    //一次分割  
	 	    int key = MedianOfThree(n,low,high);//使用三数取中法选择基准点(默认会将找到的基准元素放到n[low]里面，以满足后面的划分算法)  
	 	    while(low < high)
	 	    {  
	 	    	
	 	    	//第一个使右边的都比key大
	 	        while(high > low && n[high] >= key)  
	 	        {  
	 	            if (n[high] == key)//处理相等元素
	 	            {  
	 	            	//将当前与key相等的(high)与最右边的(right)互换，就是把high放在最后,同时right减一，且right与high并不同步变化，hign小于等于right
	 	                swap(n, right, high); 
	 	                right--;//right只有在出现与key相等元素时才互换
	 	                rightLen++;  //右边出现与key相等元素的个数
	 	            }  
	 	            high--;
	 	        }
	 	        if(low < high) {
	 	        	n[low++] = n[high]; 
	 	        }
	 	        //第二个while使左边的都比key小
	 	        while(high > low && n[low] <= key)  
	 	        {  
	 	            if (n[low] == key)  
	 	            {  
	 	                swap(n, left, low); 
	 	                left++;//left比low走的慢
	 	                leftLen++;//左边出现与key相等元素的个数
	 	            }  
	 	            low++;  
	 	        }  
	 	       if(low < high) {
	 	    	   n[high--] = n[low];
	 	       }
	 	    }  
	 	    n[low] = key;
	 	    
	 	    
	 	    //一次快排结束  
	 	    //把与枢轴key相同的元素移到枢轴最终位置周围
	 	    
	 	    
	 	    //low就是当前基准元素所在的位置
	 	    //先换左边，把前面key相等的元素从low-1依次降序放在low之前
	 	    int i = low - 1;
	 	    int j = lowRecord;  
	 	    while(j < left && n[i] != key)  
	 	    {  
	 	        swap(n, i, j); 
	 	        i--;  
	 	        j++;  
	 	    }
	 	    
	 	    //再换右边，把和key相等的元素从low+1依次升序放在low之后(升序、降序指下标)
	 	    i = low + 1;  
	 	    j = highRecord;
	 	    while(j > right && n[i] != key)  
	 	    {  
	 	    	swap(n, i, j);   
	 	        i++;  
	 	        j--;  
	 	    }  
	 	    
	 	    //防止出现完全重复数组，第一次划分直接使low=0,导致low-1-leftLen=-1,数组越界
	 	    if((low-1-leftLen) > 0){
	 	    	qSort(n,lowRecord,low - 1 - leftLen); 
	 	    }
	 	    
	 	    if((low+1+rightLen) < highRecord){
	 	    	qSort(n,low + 1 + rightLen,highRecord);  
	 	    }
	 	    
	 	}  

	 	
	    
		/*函数作用：取待排序序列中low、mid、high三个位置上数据，选取他们中间的那个数据作为枢轴*/  
		static int MedianOfThree(int n[],int low,int high)  
		{  
			//计算数组中间的元素的下标  
			int mid = (low+high)/2;
			
			//使用三数取中法选择枢轴  
			if (n[mid] > n[high])//目标: n[mid] <= n[high]  
			{  
				swap(n,mid,high);  
			}  
			if (n[low] > n[high])//目标: n[low] <= n[high]  
			{  
				swap(n,low,high); 
			}  
			if (n[mid] > n[low]) //目标: n[low] >= n[mid]  
			{  
				swap(n,mid,low);  
			}  
			//此时，n[mid] <= n[low] <= n[high]  
			return n[low];
			//low的位置上保存这三个位置中间的值  
			//分割时可以直接使用low位置的元素作为枢轴，而不用改变分割函数了  
		}
		
		//交换
		static void swap(int n[],int x,int y){
			
			int t;
			t = n[x] ;
			n[x] = n[y] ;
			n[y] = t ; 
	
		}
	    
}


	
