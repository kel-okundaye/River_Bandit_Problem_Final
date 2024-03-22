import java.util.*;

public class Main {

    // Construct our tree and set our default root;
    public static Queue<Node> constructTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> listOfPossibleRoutes = Problem.getPossibleStates(root);

        for (Node node : listOfPossibleRoutes) {
            node.setParentNode(root);
            node.addPastNode(root);
            node.setLeft(false);
            queue.add(node);
        }
        return queue;
    }

    public static StringBuilder constructTree_(Node parentNode, Node goalNode) {
        StringBuilder noSolutionFound = new StringBuilder("No Solution Found");
        Queue<Node> queue = constructTree(parentNode);
        HashSet<Node> visited = new HashSet<>(); // Set to keep track of visited nodes

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println("Processing node: " + currentNode);
            currentNode.getExplanation().insert(0, currentNode.getParentNode().getExplanation() + "\n");
            currentNode.getExplainCount().append(currentNode.toString() + "\n" + currentNode.getParentNode().getExplainCount());

            boolean goalReached = currentNode.equals(goalNode);

            // Check if the current node has been visited before
            if (!visited.contains(currentNode)) {
                visited.add(currentNode); // Mark the current node as visited
                currentNode.setVisited();
                if (goalReached) {
                    System.out.println("Goal reached: " + currentNode);
                    System.out.println(currentNode.getExplanation());
                    return currentNode.getMoveDescription();
                } else {
                    HashSet<Node> listOfPossibleRoutes = Problem.getPossibleStates(currentNode);
                    for (Node node : listOfPossibleRoutes) {
                        if (!visited.contains(node)) { // Add only if the node hasn't been visited
                            node.addPastNodes(currentNode.getPastNodes());
                            node.addPastNode(currentNode);
                            node.setParentNode(currentNode);
                            node.setLeft(!currentNode.isLeft());
                            queue.add(node);
                        }
                    }
                }
            }
        }

        return noSolutionFound;
    }
}
