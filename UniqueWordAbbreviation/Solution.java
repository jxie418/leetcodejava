
public class ValidWordAbbr {

    public ValidWordAbbr(String[] dictionary) {
        for(String s: dictionary) {
            String key = s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
            if(d.containsKey(key)) {
                d.get(key).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                d.put(key, l);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        if(!d.containsKey(key))
            return true;
        else if(d.get(key).size() < 2  && d.get(key).get(0).equals(word))
            return true;
        return false;
    }
    
    private HashMap<String, List<String>> d = new HashMap<>();
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
