package test.test;

import java.util.ArrayList;
import java.util.LinkedList;

public class SelectSort {  
	
	public static void main(String[] args) {
//		selectSort();
//		sort();
//		System.out.println(binarySearch());
		System.out.println(5>>1);
	}
    public static void selectSort(){  
        int a[]={54,6,3,78,34,12,45};  
        int position=0;  
        for(int i=0;i<a.length;i++){  
              
            int j=i+1;  
            position=i;  
            int temp=a[i];  
            for(;j<a.length;j++){  
            if(a[j]<temp){  
                temp=a[j];  
                position=j;  
            }  
            }  
            a[position]=a[i];  
            a[i]=temp;  
        }  
        for(int i=0;i<a.length;i++)  
            System.out.println(a[i]);  
    }  
    
    
    public static void sort(){
    	
    	int[] a = {34,3,1,54,34,23,2};
    	int position = 0; //定义最小值得位置
    	for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			position=i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j]<temp){
					temp = a[j];
					position = j;
				}
			}
			a[position] = a[i];
			a[i]=temp;
		}
    	
    	for(int i=0;i<a.length;i++)  
            System.out.println(a[i]);  
    	LinkedList<Integer> list = new LinkedList<>();
    	ArrayList<String> alist = new ArrayList<>();
    	
    }
    
    public   static int binarySearch(){
    	
    	int[] a = {12,23,34,45,46,47,67,78};
    	int keyWord = 47;
    	int lower = 0;
    	int upper = a.length;
    	while(lower <= upper){
    		int mid = (lower + upper) / 2;
    		if(a[mid] < keyWord){
    			lower = mid + 1;
    		}
    		else if(a[mid] > keyWord){
    			upper = mid - 1;
    		}
    		else{
    			return a[mid];
    		}
    	}
		return -1;
    	
    	
    	
    }
}  