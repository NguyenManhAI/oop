import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        if(str=="")
        {
            return 0;
        }
        else
        {
            char a=str.charAt(0);
            int max=1;
            int cnt=1;
            for(int i=0;i<str.length()-1;i++)
            {
                if(Objects.equals(str.charAt(i+1),a))
                {
                    cnt++;
                    if(max<cnt)
                    {
                        max=cnt;
                    }
                }
                else
                {
                    cnt=1;
                    a=str.charAt(i+1);
                }
            }
            return max;
        }
         // YOUR CODE HERE
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        String cpystr = new String();
        cpystr="";
        if(str.length()>0)
        {
            for(int i=0;i<str.length()-1;i++)
            {
                switch (str.charAt(i))
                {
                    case '0' :
                        break;
                    case '1':
                        cpystr+=str.charAt(i+1);
                        break;
                    case '2':
                        for(int j=0;j<2;j++)
                        {
                            cpystr+=str.charAt(i+1);
                        }
                        break;
                    case '3':
                        for(int j=0;j<3;j++)
                        {
                            cpystr+=str.charAt(i+1);
                        }
                        break;
                    case '4':
                        for(int j=0;j<4;j++)
                        {
                            cpystr+=str.charAt(i+1);
                        }
                        break;
                    case '5':
                        for(int j=0;j<5;j++)
                        {
                            cpystr+=str.charAt(i+1);
                        }
                        break;
                    case '6':
                        for(int j=0;j<6;j++)
                        {
                            cpystr+=str.charAt(i+1);
                        }
                        break;
                    case '7':
                        for(int j=0;j<7;j++)
                        {
                            cpystr+=str.charAt(i+1);
                        }
                        break;
                    case '8':
                        for(int j=0;j<8;j++)
                        {
                            cpystr+=str.charAt(i+1);
                        }
                        break;
                    case '9':
                        for(int j=0;j<9;j++)
                        {
                            cpystr+=str.charAt(i+1);
                        }
                        break;
                    default:
                        cpystr+=str.charAt(i);
                        break;
                }
            }
            switch (str.charAt(str.length()-1))
            {
                case '0': case '1' : case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9': break;
                default:
                    cpystr+=str.charAt(str.length()-1);
            }
        }
        return cpystr; // YOUR CODE HERE
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> hasha = new HashSet<>();
        HashSet<String> hashb = new HashSet<>();
        for(int i=0;i<a.length();i++)
        {
            for(int j=i;j<a.length();j++)
            {
                hasha.add(a.substring(i,j));
            }
        }
        for(int i=0;i<b.length();i++)
        {
            for(int j=i;j<b.length();j++)
            {
                hashb.add(b.substring(i,j));
            }
        }
        for(String i : hasha)
        {
            if(hashb.contains(i))
            {
                if(Objects.equals(i.length(),len))
                {
                    return true;
                }
            }
        }
        return false; // YOUR CODE HERE
    }
}
