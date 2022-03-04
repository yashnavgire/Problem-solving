class Solution {
    public List<String> commonChars(String[] words) {
        int flag = -1;
        String start = words[0];
        List<String> list = new ArrayList<>();
        char[] arr = start.toCharArray();
        
        for(char ch : arr) {
            for (int i = 1; i < words.length; i++) {
                int index = words[i].indexOf(ch);
                
                if (index != -1) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(words[i]);
                    sb.replace(index, index+1, "-1");
                    words[i] = sb.toString();
                }
                else {
                    flag = 1;
                    break;
                }
            }
            
            if (flag != 1) {
                list.add(Character.toString(ch));
            }
            flag = 0;
        }
        
        return list;
        
    }
}
