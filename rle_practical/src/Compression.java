public class Compression {
    public static String printRLE(final String input){
        StringBuffer output= new StringBuffer();
        int l=input.length();
        int i;
        for(i=0;i<l-1;i++){
            int count = 1;
            while(i+1<l && input.charAt(i)==input.charAt(i+1)){
                count++;
                i++;
            }
            output.append(input.charAt(i));
            output.append(count);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String input="aaaabbbbb";
        System.out.println(printRLE(input));
    }
}
