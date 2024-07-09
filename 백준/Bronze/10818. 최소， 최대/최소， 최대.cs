using System;
 
//10818번: 최소 최대
class Program {
 
    /*문제 : N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.*/
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
 
        string inputs = Console.ReadLine();
        string[] input = inputs.Split();
        int[] nums = Array.ConvertAll(input, int.Parse);
 
        int max = nums[0];
        int min = nums[0];
 
        for (int i = 0; i < n; i++)
        {
            if(nums[i] > max)
            {
                max = nums[i];
            }
            if(nums[i] < min)
            {
                min = nums[i];
            }
        }
 
        Console.WriteLine(min + " " + max);
    }
}