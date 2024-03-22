import java.util.HashSet;

public class Problem {

    public static HashSet<Node> getPossibleStates(Node currentState) {
        HashSet<Node> possibleStates = new HashSet<>();

        // Generate all possible state transitions based on current state
        if (currentState.isLeft()) {
            moveEntities(currentState, possibleStates, true); // Move entities from left to right
        } else {
            moveEntities(currentState, possibleStates, false); // Move entities from right to left
        }

        return possibleStates;
    }

    private static void moveEntities(Node currentState, HashSet<Node> possibleStates, boolean leftToRight) {
        // Two merchants move
        generateStateIfValid(currentState, possibleStates, 2, 0, leftToRight);

        // One merchant, one bandit move
        generateStateIfValid(currentState, possibleStates, 1, 1, leftToRight);

        // Two bandits move
        generateStateIfValid(currentState, possibleStates, 0, 2, leftToRight);

        // One bandit moves
        generateStateIfValid(currentState, possibleStates, 0, 1, leftToRight);

        // One merchant moves
        generateStateIfValid(currentState, possibleStates, 1, 0, leftToRight);
    }

    private static void generateStateIfValid(Node currentState, HashSet<Node> possibleStates, int merchants, int bandits, boolean leftToRight) {
        if ((leftToRight && currentState.getlMerchant() >= merchants && currentState.getlBandit() >= bandits) ||
                (!leftToRight && currentState.getrMerchant() >= merchants && currentState.getrBandit() >= bandits)) {

            Node newState = new Node(currentState.getlBandit(), currentState.getrBandit(), currentState.getlMerchant(), currentState.getrMerchant(), !currentState.isLeft());

            // Apply the movement
            if (leftToRight) {
                newState.addMerchantRight(merchants);
                newState.addBanditRight(bandits);
            } else {
                newState.addMerchantLeft(merchants);
                newState.addBanditLeft(bandits);
            }

            // Validate the new state
            if (isValidState(newState)) {
                newState.addMoveDescription(currentState.getMoveDescription().toString()); // Copy parent descriptions
                String moveDesc = (leftToRight ? "RIGHT" : "LEFT") + ": Move " + merchants + " Merchant(s) and " + bandits + " Bandit(s)";
                newState.addMoveDescription(moveDesc); // Add new move description

                possibleStates.add(newState);

                System.out.println("Generated valid state: " + newState);
            } else {
                System.out.println("Invalid state prevented: " + newState);
            }
        } else {
            System.out.println("Invalid move attempted from " + (leftToRight ? "left" : "right") + ": merchants=" + merchants + ", bandits=" + bandits);
        }
    }

    private static boolean isValidState(Node state) {
        // Ensure merchants are not outnumbered by bandits on either side, unless there are no merchants
        return (state.getlMerchant() == 0 || state.getlMerchant() >= state.getlBandit()) &&
                (state.getrMerchant() == 0 || state.getrMerchant() >= state.getrBandit()) &&
                // Ensure no negative numbers
                state.getlMerchant() >= 0 && state.getlBandit() >= 0 &&
                state.getrMerchant() >= 0 && state.getrBandit() >= 0;
    }
}
