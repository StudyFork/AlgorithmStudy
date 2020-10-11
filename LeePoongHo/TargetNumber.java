class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int index = 0;
        int number = 0;
        
        return tcount(index, numbers, number, target); 
    }
    
    public int tcount(int index, int[] numbers, int number, int target) {
        int length = numbers.length-1;
        
        if(index == length) {
            if(number+numbers[index] == target) {
                return 1;
            } else if(number-numbers[index] == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return tcount(index+1, numbers, number+numbers[index], target)+tcount(index+1, numbers, number-numbers[index], target);
        }
    }
}