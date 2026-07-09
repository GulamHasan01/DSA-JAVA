class Solution {
    class Pair implements Comparable<Pair> {
        Integer first , second;

        Pair(Integer first , Integer second) {
            this.first = first; this.second = second;
        }

        @Override
        public String toString() {
            return "{ " + this.first + " , " + this.second + " }";
        }

        @Override
        public int compareTo(Pair that) {
            if(this.first.compareTo(that.first) == 0)
                return this.second.compareTo(that.second);

            return this.first.compareTo(that.first);
        }
    }

    public double[] medianSlidingWindow(int[] arr, int k) {
        TreeSet<Pair> ts = new TreeSet<>();
        int n = arr.length;

        double [] ans = new double[n - k + 1];

        if(k == 1) {
            for(int i = 0; i < n; ++i)
               ans[i] = arr[i];

            return ans;
        }

        for(int i = 0; i < k; ++i)
           ts.add(new Pair( arr[i] , i ));

        Iterator<Pair> it = ts.iterator();
        Pair curr = new Pair(0 , 0);

        for(int i = 0; i < k / 2; ++i)
           curr = it.next();

        if(k % 2 == 1)
           curr = it.next();

        int l = 0;

        if(k % 2 == 0) {
            Pair curr2 = new Pair(0 , 0);

            Iterator<Pair> it1 = ts.tailSet(new Pair(curr.first , curr.second) , true).iterator();
            it1.next(); curr2 = it1.next();

            ans[l] = ((1L * curr.first) + (1L * curr2.first)) / 2.0;
        } else {
            ans[l] = curr.first;
        }

        for(int i = k; i < n; ++i) {
            if((curr.first < arr[l]) || ((curr.first == arr[l]) && (l > curr.second))) {
                ts.add(new Pair( arr[i] , i ));
                ts.remove(new Pair(arr[l] , l));

                if(arr[i] >= curr.first) {
                    // do nothing
                } else {
                    Iterator<Pair> it1 = ts.headSet( new Pair(curr.first , curr.second) , true).descendingIterator();
                    it1.next(); curr = it1.next();
                }
            } else if((curr.first > arr[l]) || ((curr.first == arr[l]) && (l < curr.second))) {
                ts.add(new Pair( arr[i] , i ));
                ts.remove(new Pair(arr[l] , l));

                if(arr[i] < curr.first) {
                    // do nothing
                } else {
                    Iterator<Pair> it1 = ts.tailSet(new Pair(curr.first , curr.second) , true).iterator();
                    it1.next(); curr = it1.next();
                }
            } else {
                Iterator<Pair> it1 = ts.tailSet(new Pair(curr.first , curr.second) , true).iterator();
                it1.next(); curr = it1.next();
                ts.remove(new Pair(arr[l] , l));
                ts.add(new Pair(arr[i] , i));

                if(arr[i] < curr.first) {
                    Iterator<Pair> it2 = ts.headSet( new Pair(curr.first , curr.second) , true).descendingIterator();
                    it2.next(); curr = it2.next();
                }
            }

            ++l;

            if(k % 2 == 0) {
                Pair curr2 = new Pair(0 , 0);

                Iterator<Pair> it1 = ts.tailSet(new Pair(curr.first , curr.second) , true).iterator();
                it1.next(); curr2 = it1.next();

                ans[l] = ((1L * curr.first) + (1L * curr2.first)) / 2.0;
            } else {
                ans[l] = curr.first;
            }
        }

        return ans;

    }
}