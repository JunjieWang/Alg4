package sort;

public class InsertionSort {
	public static void sort(int[] a){
		int N = a.length;
		for( int i=0; i<N;i++){
			for(int j=i;j>0&& (a[j]<a[j-1]);j--){
				int tmp=a[j-1];
				a[j-1]=a[j];
				a[j]=tmp;
			}
		}
	}
	
	public static void main(String[] args){
		int[] a ={5,4,3,7,2,1};
		sort(a);
		for(int i:a)
			System.out.println(i);
	}

}
