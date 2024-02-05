import java.util.*;
public class Main {

   //Construct our tree and set our default root;
    public static Queue<Node>  constructTree(Node root){

//        Tree tree = new Tree();

//        root.pastNodes.add(root);
//        root.parentNode.left = false;


        Queue<Node> queue = new LinkedList<>();
        HashSet<Node>listOfPossibleRoutes = Problem.getPossibleStates(root);


        for(Node node : listOfPossibleRoutes){
            node.parentNode = root;
            node.pastNodes.add(root);

            node.left = false;
            queue.add(node);

        }
//        tree.setRoot(root);
//        constructTree_(root);

        return queue;
    }



//    List<Node> allPossibleNodes = new ArrayList<>();
    public static StringBuilder constructTree_(Node parentNode, Node goalNode){
        StringBuilder noSolutionFound = new StringBuilder("No Solution Found");
        StringBuilder theBestOption = new StringBuilder();
        Queue<Node> queue = constructTree(parentNode);

//        Queue<Node> queue = new LinkedList<>();
//        queue.add(parentNode);

        //Define the goal nodes
//        Node goalNode1 = new Node(0,3,3,0, true);
//
//
        Node root =parentNode;


        //HashSet<Node>listOfPossibleRoutes = Problem.getPossibleStates(parentNode);

        while (!queue.isEmpty()){


            Node currentNode = queue.poll();

            currentNode.explanation.insert(0,currentNode.parentNode.explanation+"\n");
            currentNode.explainCount.append(currentNode.toString()+"\n"+currentNode.parentNode.explainCount);

//            System.out.println(currentNode.explainCount);

            boolean goalReached = currentNode.equals(goalNode);



            if(currentNode.left == true ) {
                    if (!currentNode.pastNodes.contains(currentNode)) {
                        if (!currentNode.isVisited) {
                            currentNode.setVisited();
                            if (goalReached) {
                                currentNode.explainCount.append("\n"+root);


                                //Attempt
                                //.explanation.insert(0,root+"\n");

                                System.out.println(currentNode.explainCount);
//                                System.out.println(currentNode.explanation);
                                theBestOption = currentNode.explanation;
                                return theBestOption;
                            } else {
                                HashSet<Node> listOfPossibleRoutes = Problem.getPossibleStates(currentNode);
                                for (Node node : listOfPossibleRoutes) {
                                    node.pastNodes.addAll(currentNode.pastNodes);
                                    node.pastNodes.add(currentNode);
                                    node.parentNode = currentNode;
                                    node.left = false;
                                    queue.add(node);
                                }
                            }

                        }

                    } else {
                        currentNode.setVisited();
                    }
                }
                else{
                    if (!currentNode.pastNodes.contains(currentNode)) {
                        if (!currentNode.isVisited) {
                            currentNode.setVisited();
                            if (goalReached) {
//                                currentNode.explainCount.append(root);
                                //Attempt
                                //currentNode.explanation.insert(0,root+"\n");

                                System.out.println(currentNode.explainCount);
//                                System.out.println(currentNode.explanation);
                                theBestOption = currentNode.explanation;
                                return theBestOption;
                            } else {
                                HashSet<Node> listOfPossibleRoutes = Problem.getPossibleStates(currentNode);
                                for (Node node : listOfPossibleRoutes) {
                                    node.pastNodes.addAll(currentNode.pastNodes);
                                    node.pastNodes.add(currentNode);
                                    node.parentNode = currentNode;
                                    node.left = true;

                                    queue.add(node);
                                }
                            }

                        }

                    } else {
                        currentNode.setVisited();
                    }
                }
        }


        return noSolutionFound;
    }

}

