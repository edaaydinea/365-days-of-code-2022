public class Exercise_09 {
    /*
     * Answer:
     *     Assume union assigns id[q] = id[p] when weights are equal
     *     id[8] is a child of id[4] -> union(4, 8);
     *     id[4] is a child of id[5] -> id[5] must have at least 1 child before union(5, 4) [union(5, 9)]
     *     id[5] is a child of id[6] -> id[6] must have at least 2 child before union(6, 5) [union(6, ?)] -> Impossible
     */
}
