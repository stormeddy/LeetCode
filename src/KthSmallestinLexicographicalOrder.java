
public class KthSmallestinLexicographicalOrder {

	public int findKthNumber(int n, int k) {
        long curr = 1;
        int i = 2;
        
        String s=n+"";
        int p=s.length()-1;
        for (; i <= k; ) {
            
            if (curr * 10 <= n) {
            	long t=(long) (curr*Math.pow(10, p));
            	if (t<=n) {
					curr=t;
					i+=p;
				}else {
					curr *= 10;
	                ++i;
				}
                
            } else if (curr % 10 != 9 && curr + 1 <= n) {
            	long t=curr/10*10+9;
            	long diff=t-curr;
                if(curr+diff<=n && i+diff<=k){
                    curr=t;;
                    i+=diff;
                }else{
                    curr++;
                    ++i;
                }
                
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
                ++i;
            }
            System.out.println(curr+" "+(i-1));
        }
        
        return (int)curr;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestinLexicographicalOrder p=new KthSmallestinLexicographicalOrder();
		int n=100,k=90;
		p.findKthNumber(n, k);
	}

}
