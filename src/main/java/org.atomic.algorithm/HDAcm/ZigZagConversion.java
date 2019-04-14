package org.atomic.algorithm.HDAcm;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like
 *  this: (you may want to display this pattern in a fixed font for better legibility)
 *
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(s==null || s.length()<=2 || numRows==1)
            return s;

        int len=s.length();
        int i=0,index=0,j=0;
        int dir=1;
        String[][] strArr;
        if(numRows<=2){
            strArr=new String[len/numRows + 1][numRows];
        }else{
            strArr=new String[len/(numRows-1) + numRows][numRows];
        }
        while(index<len) {
            strArr[i][j]=String.valueOf(s.charAt(index));

            if(dir==1) {
                j++;
                if (j % numRows == 0) {
                    i++;
                    j=j-2;
                    if(j>0) dir = -1;
                }
            } else {
                j--;
                if (j==0) {
                    dir = 1;
                    i++;
                }
            }

            index++;
            if(index==len) break;
        }

        StringBuffer sb=new StringBuffer();

        int tempCol=(len/(numRows+numRows-2)+1)*(numRows-1);
        int colMax=tempCol>strArr.length?strArr.length:tempCol;
        for(int col=0;col<numRows;col++) {
            for (int k = 0; k < colMax; k++) {
                if (strArr[k][col] != null && !strArr[k][col].equals(""))
                    sb.append(strArr[k][col]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String str="PAYPALISHIRING";
//        String str="ABCD";
//        System.out.println(convert(str, 2));
        String str="PAYPALISHIRING";
        System.out.println(convert(str, 4));
    }

}
