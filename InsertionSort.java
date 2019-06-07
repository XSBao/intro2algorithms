/**
 * insertion sort with rate of growth of running time Θ(n²)
 * Thomas H. Cormen etc., Introduction to Algortithms, Third Edition, 2009, p.19
 * @author X. Bao
 * @version June 3, 2019
 */

public class InsertionSort{
  public static void main(String[] args){
    int[] arr = {2, 4, 1, 8, 10, 32, 2, 6, 8};
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    int[] sortedArr = insertionSort(arr);
    for(int i = 0; i < sortedArr.length; i++){
      System.out.print(sortedArr[i] + " ");
    }
    System.out.println();
  }

  /**
   * This method sorts an integer array by insertion-sort method
   * @param the integer array to sorted
   * @return the sorted array
   */ 
  private static int[] insertionSort(int[] arr){
    for(int j = 1; j < arr.length; j++){
      int key = arr[j];//the value to be inserted
      int i = j - 1;
      while(i >= 0 && arr[i] > key){//loop through the sorted subarray arr[0,...,j-1] to find the proper positon where the arr[j] can be inserted, such that arr[0,...,j] is in sorted order.
        i--;
      }
      int startInd = i + 1;
      int endInd = j - 1;
      arr = shiftRightOnePosition(arr, startInd, endInd);//in order to insert a new element, each element after the insertion location should be shifted one position to the right.
      arr[startInd] = key;
    }
    return arr;
  }

  /**
   * This methods shifts elements one position to the right, and the index range of the elements is specified.
   * @param arr the original array. A subarray whithin it will be shifted.
   * @param startInd, the index of the first element of the subarray.
   * @param endInd the index of the last element of the subarray. 
   * @return int[] the new array after shift operation
   */
  private static int[] shiftRightOnePosition(int[] arr, int startInd, int endInd){
    for(int i = endInd; i >= startInd; i--){
      arr[i + 1] = arr[i];
    }
    return arr;
  }

}
