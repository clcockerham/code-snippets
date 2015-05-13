//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public class MaximumContiguousSubsequenceSum {

	//checks all possible subsequence sums to find the max
	public int maxSubsequence(int[] array){
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++){
			for(int j = i; j <array.length; j++){
				int sum = 0;
				for(int k = i; k < j; k++){
					sum += array[k];
					if(sum > maxSum){
						maxSum = sum;
					}
				}
			}
		}
		return maxSum;
	}
	
	//Iterate through the array once assuming that if the sum becomes negative it will never be the max
	public int maxSubsequenceOnePass(int[] array){
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++){
			sum += array[i];
			maxSum = Math.max(maxSum, sum);
			//if the number becomes negative, reset sum
			if(sum < 0){
				sum = 0;
			}
		}
		
		return maxSum;
	}
	
	
	public static void main(String [ ] args){
		
		int[] testArray = {-2,1,-3,4,-1,2,1,-5,4}; //[4,−1,2,1] has the largest sum = 6
		int[] testArray2 = {1, -2, 3, -2, 4, -5, 3}; // [3, -2, 4] has the largest sum = 5
		MaximumContiguousSubsequenceSum maxSubSum = new MaximumContiguousSubsequenceSum();
		int answer1 = maxSubSum.maxSubsequence(testArray); //expected answer is 6
		int answer2 = maxSubSum.maxSubsequenceOnePass(testArray); //expected answer is 6
		int answer3 = maxSubSum.maxSubsequence(testArray2); //expected answer is 5
		int answer4 = maxSubSum.maxSubsequenceOnePass(testArray2); //expected answer is 5
		
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
		System.out.println(answer4);
	}
	
}
