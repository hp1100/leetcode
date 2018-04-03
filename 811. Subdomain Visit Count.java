class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        for(String cpdomain : cpdomains) {
            int idx = cpdomain.indexOf(' ');
            int times = Integer.parseInt(cpdomain.substring(0, idx));
            String domain = cpdomain.substring(idx + 1);
            String[] subDomains = domain.split("\\.");
            StringBuilder sb = new StringBuilder();
            for(int i = subDomains.length - 1; i >= 0; i--) {
                sb.insert(0, sb.length() == 0 ? subDomains[i] : subDomains[i] + ".");
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + times);
            }
        }
        for(String domain: map.keySet()) {
            res.add(map.get(domain) + " " + domain);
        }
        return res;
    }
}
