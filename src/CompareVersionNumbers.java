/*Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
1.1<1 1.0=1
*/
public class CompareVersionNumbers {

	public static int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int i=0,j=0;
        for(;i<v1.length && j<v2.length;i++,j++){
            int a1=Integer.parseInt(v1[i]);
            int a2=Integer.parseInt(v2[j]);
            if(a1<a2) return -1;
            if(a1>a2) return 1;
        }
        if(j<v2.length){
        	for(;j<v2.length;j++){
        		int a2=Integer.parseInt(v2[j]);
        		if (a2!=0) {
					return -1;
				}
        	}
        	return 0;
        } 
        if(i<v1.length){
        	for(;i<v1.length;i++){
        		int a1=Integer.parseInt(v1[i]);
        		if (a1!=0) {
					return 1;
				}
        	}
        	return 0;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("1.0.0", "1"));
	}

}
