package MatthewTrash.EulerTemp1.main;

public class EulerTemp
{
    public static void main(String[] args)
    {
        for (long m = 1; m <= Math.pow(10,8); m++)
        {
            if (fact(m) % Math.pow(10,8) == 0)
            {
                System.out.println(m + " " + fact(m));
                break;
            }
        }
    }
    public static long fact(long m)
    {
        long l = 1;
        for (long n = m; n > 0; n--)
        {
            l = n * l;
        }
        return l;
    }
}