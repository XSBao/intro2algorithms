'''
insertion sort
Thomas H. Cormen etc., Introduction to Algortithms, Third Editi    on, 2009, p.19
@author X. Bao
@version June 3, 2019
'''

def insertSort(arr):
    for j in range(1, len(arr)):
        key = arr[j]
        i = j - 1
        while i >= 0:
            if arr[i] > key:
                i -= 1
            else:
                break
        whereToInsert = i + 1
        arr.pop(j)
        arr.insert(whereToInsert, key)

originalArr = [2, 4, 1, 8, 10, 32, 2, 6, 8]
print(originalArr)
insertSort(originalArr)
print(originalArr)