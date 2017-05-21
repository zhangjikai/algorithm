/**
 * Created by Jikai Zhang on 2017/5/21.
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        char space = ' ';
        char tmp;
        for(int i = 0; i < str.length(); i++) {
            tmp = str.charAt(i);
            if(tmp == space) {
                builder.append("%20");
            } else {
                builder.append(tmp);
            }
        }
        return builder.toString();
    }
}
