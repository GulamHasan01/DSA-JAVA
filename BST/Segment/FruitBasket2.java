package BST.Segment;

public class FruitBasket2 {

        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int ans=0;
            for(int fruit:fruits)
            {
                boolean placed = false;

                for(int i=0;i< baskets.length;i++)
                {
                    // Can this basket hold the fruit?
                    if (baskets[i]>=fruit){
                        placed=true;
                        baskets[i]=0;
                        break;

                    }
                }

                if(!placed)
                {
                   ans++;
                }
            }
            return ans;

    }
}
