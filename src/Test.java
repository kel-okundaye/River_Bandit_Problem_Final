import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        Node testRoot1 = new Node(3,0,0,3, true);

        Node testRoot2 = new Node(1,2,2,1, false);

        Node testRoot3 = new Node(1,2,2,1, false);

        Node testRoot4 = new Node(3,0,2,1, false);

        HashSet<Node> testSet = new HashSet<>();

        testSet.add(testRoot1);
        testSet.add(testRoot2);
        testSet.add(testRoot4);

        System.out.println(testRoot2.toString());
        System.out.println(testRoot3.toString());
        System.out.println("Humanity \nErected");

//        System.out.println(theTest(testRoot2,testRoot3));
        if(testSet.contains(testRoot3)){
            System.out.println("Eureka");
        }
        else{
            System.out.println("Sigh");
        }

        System.out.println(theTest(testRoot2,testRoot3));
    }

    public static boolean theTest(Node a, Node b){
        if(a.equals(b)){
            return true;
        }
        return false;
    }
}
