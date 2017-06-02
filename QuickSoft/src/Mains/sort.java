package Mains;

import org.junit.Test;

public class sort {
	
	public void qSort(int[] v) {
		quickSort(v, 0, v.length-1);
	}
		
	public void quickSort(int[] n, int p, int q) {
		if((q-p) > 1)
			while(p < q) {
				int m = partition(n, p, q);
				quickSort(n, p, m-1);
				p = m + 1;
			}
		else
			insertSort(n, p, q);
	}


	public int partition(int[] n, int p, int q) 
	{
		int x = select_pivot(n, p, q);
		int i = p;
		int j = q;
		while(i < j) 
		{
			while(i < j && n[j] > x) {
				--j;
			}
			n[i] = n[j];
			while(i < j && n[i] < x) {
				++i;
			}
			if(i<j)
				break;
			n[j] = n[i];
		}
		n[i] = x;
		return i;
	}


	private int select_pivot(int[] n, int p, int q) {
		int m = (p + q) / 2;
		if(n[p] < n[m])
			swap(n[p], n[m]);
		if(n[q] < n[m])
			swap(n[q], n[m]);
		if(n[q] < n[p])
			swap(n[q], n[p]);
		return n[p];
	}


	private void swap(int i, int j) {
		int temp = 0;
		temp = i;
		i = j; 
		j = temp;
	}


	private void insertSort(int[] n, int p, int q) {
		
	}
}
