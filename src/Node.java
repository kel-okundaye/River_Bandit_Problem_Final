import java.util.HashSet;

public class Node {
    // State information
    private int lBandit;
    private int rBandit;
    private int lMerchant;
    private int rMerchant;
    private boolean left;

    private boolean isVisited = false;

    private StringBuilder explanation = new StringBuilder();
    private StringBuilder explainCount = new StringBuilder();

    private StringBuilder moveDescription = new StringBuilder();

    // Child Nodes and Past Nodes
    private HashSet<Node> children = new HashSet<>();
    private HashSet<Node> pastNodes = new HashSet<>();

    private Node parentNode;

    // Initialization
    public Node(int lBandit, int rBandit, int lMerchant, int rMerchant, boolean left) {
        this.lBandit = lBandit;
        this.rBandit = rBandit;
        this.lMerchant = lMerchant;
        this.rMerchant = rMerchant;
        this.left = left;
    }

    // Getter methods
    public int getlBandit() {
        return lBandit;
    }

    public int getrBandit() {
        return rBandit;
    }

    public int getlMerchant() {
        return lMerchant;
    }

    public int getrMerchant() {
        return rMerchant;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node getParentNode() {
        return this.parentNode;
    }

    public void addPastNode(Node node) {
        this.pastNodes.add(node);
    }

    public HashSet<Node> getPastNodes() {
        return this.pastNodes;
    }

    public void addPastNodes(HashSet<Node> nodes) {
        this.pastNodes.addAll(nodes);
    }

    // Method to append move descriptions
    public void addMoveDescription(String description) {
        if (moveDescription.length() > 0) {
            moveDescription.append("\n");
        }
        moveDescription.append(description);
    }

    public StringBuilder getMoveDescription() {
        return moveDescription;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isLeft() {
        return this.left;
    }

    public StringBuilder getExplanation() {
        return this.explanation;
    }

    public StringBuilder getExplainCount() {
        return this.explainCount;
    }

    public boolean isVisited() {
        return this.isVisited;
    }

    public void setVisited() {
        this.isVisited = true;
    }

    // Add child Node to children list
    public void addChild(Node child) {
        children.add(child);
    }

    // Move bandits from left to right with validation and logging
    public void addBanditRight(int howMany) {
        if (lBandit >= howMany) {
            rBandit += howMany;
            lBandit -= howMany;
            System.out.println("Moved " + howMany + " bandit(s) right. New state: " + this);
        } else {
            System.out.println("Attempted to move " + howMany + " bandit(s) right, but only " + lBandit + " available.");
        }
    }

    // Move bandits from right to left with validation and logging
    public void addBanditLeft(int howMany) {
        if (rBandit >= howMany) {
            lBandit += howMany;
            rBandit -= howMany;
            System.out.println("Moved " + howMany + " bandit(s) left. New state: " + this);
        } else {
            System.out.println("Attempted to move " + howMany + " bandit(s) left, but only " + rBandit + " available.");
        }
    }

    // Move merchant from left to right with validation and logging
    public void addMerchantRight(int howMany) {
        if (lMerchant >= howMany) {
            rMerchant += howMany;
            lMerchant -= howMany;
            System.out.println("Moved " + howMany + " merchant(s) right. New state: " + this);
        } else {
            System.out.println("Attempted to move " + howMany + " merchant(s) right, but only " + lMerchant + " available.");
        }
    }

    // Move merchant from right to left with validation and logging
    public void addMerchantLeft(int howMany) {
        if (rMerchant >= howMany) {
            lMerchant += howMany;
            rMerchant -= howMany;
            System.out.println("Moved " + howMany + " merchant(s) left. New state: " + this);
        } else {
            System.out.println("Attempted to move " + howMany + " merchant(s) left, but only " + rMerchant + " available.");
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + lBandit;
        result = 31 * result + rBandit;
        result = 31 * result + lMerchant;
        result = 31 * result + rMerchant;
        result = 31 * result + (left ? 1 : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Node)) return false;

        Node node = (Node) obj;

        return lBandit == node.lBandit &&
                rBandit == node.rBandit &&
                lMerchant == node.lMerchant &&
                rMerchant == node.rMerchant;
    }

    @Override
    public String toString() {
        return String.format("Left Side - Bandits: %d, Merchants: %d | Right Side - Bandits: %d, Merchants: %d | Boat is on the %s",
                lBandit, lMerchant, rBandit, rMerchant, left ? "left" : "right");
    }
}
