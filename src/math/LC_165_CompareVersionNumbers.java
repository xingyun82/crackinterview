package math;

/**
 *
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37


 * Created by xingyun on 15/6/6.
 */
public class LC_165_CompareVersionNumbers {

    public String trimZeros(String str) {
        int num = 0;
        for(int i=0;i<str.length();++i) {
            if(str.charAt(i) != '0') break;
            num++;
        }
        if(num == 0) return str;
        return str.substring(num, str.length());
    }


    public int compareVersion(String version1, String version2) {
        int res = 0;
        String[] versionStrs1 = version1.split("\\.");
        String[] versionStrs2 = version2.split("\\.");
        int i = 0;
        while(i < versionStrs1.length && i < versionStrs2.length) {
            String str1 = trimZeros(versionStrs1[i]);
            String str2 = trimZeros(versionStrs2[i]);
            if(str1.length() > str2.length())return 1;
            else if(str1.length() < str2.length()) return -1;
            else if(str1.length() == str2.length()) {
                int comp = str1.compareTo(str2);
                if(comp != 0) {
                    return comp>0?1:-1;
                }

            }
            i++;
        }
        if(i == versionStrs1.length && i == versionStrs2.length) return 0;
        if(i < versionStrs2.length) {
            for(int j=i;j<versionStrs2.length;++j) {
                if(trimZeros(versionStrs2[j]).length()!=0) return -1;
            }
            return 0;
        }
        if(i < versionStrs1.length) {
            for (int j=i;j<versionStrs1.length;++j) {
                if(trimZeros(versionStrs1[j]).length()!=0) return 1;
            }
            return 0;
        }


        return res;
    }

    public static void main(String[] args) {
        LC_165_CompareVersionNumbers inst = new LC_165_CompareVersionNumbers();
        System.out.println(inst.compareVersion(
                "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000",
                "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"));
    }
}
