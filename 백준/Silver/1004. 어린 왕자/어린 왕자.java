import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        for (int i = 0; i < length; i++)
        {
            // 출발점과 도착점 좌표 입력
            int x_start = scanner.nextInt();
            int y_start = scanner.nextInt();
            int x_end = scanner.nextInt();
            int y_end = scanner.nextInt();

            int through = 0;  // 행성계를 통과하는 횟수

            int count = scanner.nextInt();  // 행성계의 수

            for (int j = 0; j < count; j++)
            {
                // 행성의 중심 좌표와 반지름 입력
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int r = scanner.nextInt();

                // 반지름의 제곱
                int rSquared = r * r;

                // 출발점과 도착점이 행성 내에 포함되는지 확인
                boolean hasStartContain = isWithinCircle(x_start, y_start, x, y, rSquared);
                boolean hasEndContain = isWithinCircle(x_end, y_end, x, y, rSquared);

                // 출발점과 도착점 중 하나만 포함되면 through 증가
                if (hasStartContain != hasEndContain)
                {
                    through++;
                }
            }

            System.out.println(through);  // 결과 출력
        }

        scanner.close();
    }

    // 점이 행성 내에 포함되는지 확인
    private static boolean isWithinCircle(int xo, int yo, int x, int y, int rSquared)
    {
        return (Math.pow(xo - x, 2) + Math.pow(yo - y, 2)) < rSquared;
    }
}
