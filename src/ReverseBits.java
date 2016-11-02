/*Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?*/
public class ReverseBits {

	public long reverseBits(long n) {
        return rev(n,32);
    }
    
    public long rev(long n,int k){
        long a;
        a=n&1;
        n=n>>1;
        k--;
        while(k>=1){
            a=(a<<1)|(n&1);
            n=n>>1;
            k--;
        }
        return a;
    }
	
    
    public long getUnsignedIntt (int data){     //将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
        
    	return ((long)data)&0xFFFFFFFF;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits r=new ReverseBits();
		System.out.println(Integer.MIN_VALUE%2);
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println(r.reverseBits(2147483648L));

//		System.out.println(r.getUnsignedIntt(Integer.MIN_VALUE));
	}

}
