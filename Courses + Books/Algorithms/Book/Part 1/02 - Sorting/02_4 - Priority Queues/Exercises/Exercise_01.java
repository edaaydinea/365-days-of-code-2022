public class Exercise_01 {
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>();
        String[] input = "P R I O * R * * I * T * Y * * * Q U E * * * E".split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String s : input)
        {
            if(s.equals("s"))
                sb.append(pq.delMax()).append(" ");
            else
                pq.insert(s);
        }
        System.out.println(sb.toString());
    }

}
