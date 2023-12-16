interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

abstract class RainySeasonConservation implements WaterConservationSystem {
    public abstract int calculateTrappedWater(int[] blockHeights);
}

class CityBlockConservation extends RainySeasonConservation {

    public int calculateTrappedWater(int[] blockHeights) {
        if (blockHeights == null || blockHeights.length <= 2) {
            return 0;
        }

        int waterVolume = 0;
        int n = blockHeights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        for (int i = 0; i < n; i++) {
            waterVolume += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return waterVolume;
    }
}

public class WaterConservation {
    public static void main(String[] args) {
        int[] blockHeights = { 3, 0, 2, 0, 4 };

        CityBlockConservation conservation = new CityBlockConservation();
        int trappedWater = conservation.calculateTrappedWater(blockHeights);

        System.out.println("Total volume of water that can be conserved: " + trappedWater);
    }
}