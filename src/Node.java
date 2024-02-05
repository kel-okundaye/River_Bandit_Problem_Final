import java.util.ArrayList;
import java.util.HashSet;


public class Node{
    //State information
    public int lBandit;
    public int rBandit;
    public int lMerchant;
    public int rMerchant;
    boolean left;

    boolean isVisited = false;

    StringBuilder explanation = new StringBuilder();
    StringBuilder explainCount = new StringBuilder();

    //Child Nodes
    HashSet<Node> children;
    HashSet<Node> pastNodes;

    Node parentNode;
    //Initialization
    public Node(int lBandit,int rBandit, int lMerchant, int rMerchant, boolean left){
        this.lBandit = lBandit;
        this.rBandit = rBandit;
        this.lMerchant = lMerchant;
        this.rMerchant = rMerchant;
        this.left = left;
        this.children = new HashSet<>();
        this.pastNodes = new HashSet<>();
    }

    public boolean isVisited(){
        if(isVisited == true){
            return true;
        }
        return false;
    }

    public void setVisited(){
        isVisited = true;
    }
    //Add child Node to children list
    public void addChild(Node child) {
        children.add(child);
    }

    //Move bandits from left to right
    public void AddBanditRight(int howMany){
        rBandit =   rBandit + howMany;
        lBandit = lBandit - howMany;
    }
    //Move bandits from right to left
    public void AddBanditLeft(int howMany){
        lBandit =   lBandit + howMany;
        rBandit = rBandit - howMany;
    }

    //Move merchant from left to right
    public void AddMerchantRight(int howMany){
        rMerchant = rMerchant + howMany;
        lMerchant = lMerchant - howMany;

    }

    //Move merchant from right to left
    public void AddMerchantLeft(int howMany){
        lMerchant = lMerchant + howMany;
        rMerchant = rMerchant - howMany;
    }

    @Override
    public int hashCode() {
        return (this.lBandit +2) + (this.lMerchant *3 )+ (this.rBandit * 2) + (this.rMerchant/2) % 10;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        Node n = (Node)obj;

        return this.lMerchant == n.lMerchant &&
                this.rMerchant == n.rMerchant &&
                this.lBandit == n.lBandit &&
                this.rBandit == n.rBandit;



//        if(this.toString().equals(obj.toString())){
//            return true;
//        }

    }

    //Print the state info
    @Override
    public String toString(){
        return "lMerchant: " + lMerchant+", rMerchant: "+rMerchant+", lBandit: "+ lBandit+", rBandit: "+ rBandit;
    }


}