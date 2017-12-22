package cyou.bike.com.live.module.live.danmu;

/**
 * Created by：anlonglong
 * on 2017/12/5 15:35
 * Email: anlonglong0721@gmail.com
 */

public class FormatTransfer {
    public   static   byte [] toLH( int  n)
    {
        byte [] b =  new   byte [ 4 ];
        b[0 ] = ( byte ) (n &  0xff );
        b[1 ] = ( byte ) (n >>  8  &  0xff );
        b[2 ] = ( byte ) (n >>  16  &  0xff );
        b[3 ] = ( byte ) (n >>  24  &  0xff );
        return  b;
    }

    public   static   byte [] toHH( int  n)
    {
        byte [] b =  new   byte [ 4 ];
        b[3 ] = ( byte ) (n &  0xff );
        b[2 ] = ( byte ) (n >>  8  &  0xff );
        b[1 ] = ( byte ) (n >>  16  &  0xff );
        b[0 ] = ( byte ) (n >>  24  &  0xff );
        return  b;
    }

    public   static   byte [] toLH( short  n)
    {
        byte [] b =  new   byte [ 2 ];
        b[0 ] = ( byte ) (n &  0xff );
        b[1 ] = ( byte ) (n >>  8  &  0xff );
        return  b;
    }

    public   static   byte [] toHH( short  n)
    {
        byte [] b =  new   byte [ 2 ];
        b[1 ] = ( byte ) (n &  0xff );
        b[0 ] = ( byte ) (n >>  8  &  0xff );
        return  b;
    }
}
