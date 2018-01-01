package com.robbin.algorithm.sort;
/**
 * Java排序算法（三）：堆排序
 * @author robbin
 * @see http://blog.csdn.net/apei830/article/details/6584645
 *
 */
public class HeapSortTest {

	public static void main(String[] args) {
		int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		print(data5);
		heapSort(data5);
		System.out.println("排序后的数组：");
		print(data5);
	}

	public static void swap(int[] data, int i, int j) {
		if (i == j) {
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}

	public static void heapSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			createMaxdHeap(data, data.length - 1 - i);
			// 交换0和8
			// 交换0和7
			// 交换0和6
			swap(data, 0, data.length - 1 - i);
			print(data);
		}
	}

	public static void createMaxdHeap(int[] data, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// 保存当前正在判断的节点
			int k = i;
			// 若当前节点的子节点存在
			while (2 * k + 1 <= lastIndex) {
				// biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex) {
					// 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						// 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
						biggerIndex++;
					}
				}
				if (data[k] < data[biggerIndex]) {
					// 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
					swap(data, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "\t");
		}
		System.out.println();
	}

	
//	5	3	6	2	1	9	4	8	7	
//	3	8	6	7	1	5	4	2	9	
//	2	7	6	3	1	5	4	8	9	
//	4	3	6	2	1	5	7	8	9	
//	4	3	5	2	1	6	7	8	9	
//	1	3	4	2	5	6	7	8	9	
//	2	3	1	4	5	6	7	8	9	
//	1	2	3	4	5	6	7	8	9	
//	1	2	3	4	5	6	7	8	9	
//	1	2	3	4	5	6	7	8	9	
//	排序后的数组：
//	1	2	3	4	5	6	7	8	9	
//	
}