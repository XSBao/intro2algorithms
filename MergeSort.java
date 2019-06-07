/**
 * Merge sort
 * Thomas H. Cormen etc., Introduction to Algortithms, Third Edition, 2009, p.19
 * @author X. Bao
 * @version June 6, 2019
 */

public class MergeSort{
  public static void main(String[] args){
    int[] arr = {21, 2, 3, 1, 9, 6, 4, 8, 7, 12, 14};
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    arr = mergeSort(arr, 0, arr.length - 1);
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  /**
   * This method sorts an arry using merge sort method. It merges two sorted subarray arr[p,..,q] and arr[q+1,..,r] recursively
   * @param arr the original array, and its subarray arr[p,..,r] will be sorted
   * @param p the start index of the subarray to be sorted
   * @param r the end index of the subarray to be sorted
   * @return int[] the array after sorting
   */
  private static int[] mergeSort(int[] arr, int p, int r){
    if(p < r){
      int q = (p + r) / 2;
      mergeSort(arr, p, q);
      mergeSort(arr, q + 1, r);
      merge(arr, p, q, r);
    }
    return arr;
  }

  /**
   * This method merges two sorted subarrays
   * @param arr the original arrary
   * @param p the start index of the first subarray to be merged
   * @param q the end index of the first subarray to be merged 
   * @param r the end index of the second subarray to be merged, and its start index is q+1
   * @return int[] the array after merging the two subarrays
   */
  private static int[] merge(int[] arr, int p, int q, int r){
    int n1 = q - p + 2;
    int n2 = r - q + 1;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for(int i = 0; i < n1 - 1; i++){
      L[i] = arr[p + i];
    }
    L[n1 - 1] = Integer.MAX_VALUE;
    for(int i = 0; i < n2 - 1; i++){
      R[i] = arr[q + 1 + i];
    }
    R[n2 - 1] = Integer.MAX_VALUE;

    int i = 0;
    int j = 0;
    for(int k = p; k <= r; k++){
      if(L[i] < R[j]){
        arr[k] = L[i];
        i++;
      }
      else{
        arr[k] = R[j];
        j++;
      }
    }
    return arr;
  }
}

