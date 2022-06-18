import java.time.ZonedDateTime;

/**
 * @auther zzyy
 * @create 2020-02-21 15:50
 */
public class T2
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

       //2020-02-21T15:51:37.485+08:00[Asia/Shanghai]
    }
}
