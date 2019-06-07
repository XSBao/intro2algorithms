'''
Merge sort
Thomas H. Cormen etc., Introduction to Algortithms, Third Edition, 2009, p.31-34
@author X. Bao
@version June 6, 2019
'''
 
 
'''
This method sorts an arry using merge sort method. It merges two sorted subarray arr[p,..,q] and arr[q+1,..,r] recursively
@param arr the original array, and its subarray arr[p,..,r] will be sorted
@param p the start index of the subarray to be sorted
@param r the end index of the subarray to be sorted
@return int[] the array after sorting
'''
import sys
def mergeSort(arr, p, r):
    if(p < r):
        q = (p + r) // 2
        mergeSort(arr, p, q)
        mergeSort(arr, q + 1, r)
        merge(arr, p, q, r)
    return arr
 
'''
This method merges two sorted subarrays
@param arr the original arrary
@param p the start index of the first subarray to be merged
@param q the end index of the first subarray to be merged 
@param r the end index of the second subarray to be merged, and its start index is q+1
@return int[] the array after merging the two subarrays
'''
def merge(arr, p, q, r):
    n1 = q - p + 2
    n2 = r - q + 1
    L = arr[p : q + 1]
    L.append(sys.maxsize)
    R = arr[q + 1 : r + 1]
    R.append(sys.maxsize)
 
    i = 0
    j = 0
    for k in range(p, r + 1):
        if(L[i] < R[j]):
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
    return arr

#main method entry
arr = [21, 2, 3, 1, 9, 6, 4, 8, 7, 12, 14]
print(arr)
arr = mergeSort(arr, 0, len(arr) - 1)
print(arr)
