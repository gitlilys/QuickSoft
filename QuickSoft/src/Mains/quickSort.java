package Mains;

import java.io.IOException;


import Utils.baseUtils;

/**
 * 快速排序类
 * @author 罗渊
 *
 * 2017年5月13日
 */
public class quickSort {

	public void qSort(int[] v) {
		quicksort(v, 0, v.length-1);
	}

	 static void quicksort(int n[], int left, int right) {
	        int dp;
	        if (left < right) {
	            dp = partition(n, left, right);
	            quicksort(n, left, dp - 1);
	            quicksort(n, dp + 1, right);
	        }
	    }
	 
	    static int partition(int n[], int left, int right) {
	        int pivot = n[left];
	        while (left < right) {
	            while (left < right && n[right] >= pivot)
	                right--;
	            if (left < right)
	                n[left++] = n[right];
	            while (left < right && n[left] <= pivot)
	                left++;
	            if (left < right)
	                n[right--] = n[left];
	        }
	        n[left] = pivot;
	        return left;
	    }
}
