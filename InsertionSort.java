/**
 * insertion sort
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
      int key = arr[j];
      int i = j - 1;
      while(i >= 0){//loop through the sorted subarray arr[0,...,j-1] to find the proper positon where the arr[j] can be inserted, such that arr[0,...,j] is in order.
        if(arr[i] > key){
          i--;
        }
        else{
          break;
        }
      }
      int startInd = i + 1;
      int endInd = j - 1;
      arr = shiftRightOneBit(arr, startInd, endInd);//in order to insert the element arr[j] to the positon with index of startInd, the subarray arr[startInd,...,j-1] should be shifted one position to the right. 
      arr[startInd] = key;
    }
    return arr;
  }

  /**
   * This methods shifts elements from index startInd to the endInd of the array arr to the righ one positon.
   * @param arr, the original array whose subarray is shifted
   * @param startInd, the index of the first element to be shifted
   * @param endInd the index of the last element to be shifted 
   * @return int[] the array whose elements have been partly shifted 
   */
  private static int[] shiftRightOneBit(int[] arr, int startInd, int endInd){
    for(int i = endInd; i >= startInd; i--){
      arr[i + 1] = arr[i];
    }
    return arr;
  }

}
