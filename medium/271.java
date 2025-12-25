class Solution {

    public String encode(List<String> strs) {
        String output = "";
        for (String s : strs) {
            output += "" + s.length() + "." + s; 
        }
        return output;
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int index = 0; 
        while (index < str.length()) {
            int end = 0;
            for (int i = index; i < str.length(); i++) {
                if (str.charAt(i) == '.') {
                    end = i;
                    break;
                }
            }
            int size = Integer.parseInt(str.substring(index, end));
            output.add(str.substring(end+1, end+size+1));
            index=end+size+1;
        }
        return output;
    }
}
