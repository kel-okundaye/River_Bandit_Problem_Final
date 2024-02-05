import java.util.*;

public class Problem {
    //Should return all possible states of a Node
    static HashSet<Node> getPossibleStates(Node currentState) {
        HashSet<Node> myHashSet = new HashSet<>();


        //Create original Node so that we can go back to original Node when doing operations later on.
        Node original = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, currentState.left);

//        There are 5 operations for each side.
//        *Two (Same)Merchants use the boat
//        *One Merchant uses the boat
//        *One Merchant and One Bandit use the boat(Dif)
//        *Two (Same)Bandits use the boat
//        *One Merchant uses the boat


        //Left Side of River
        //If left is true(Should eventually alternate)
        if (currentState.left == true){

            //Same Merchant + 2M(if amount of merchants on the left is bigger/equal to 2 then do....)
            if (currentState.lMerchant >= 2) {

                //Operation that adds to Merchants to the right
                currentState.AddMerchantRight(2);

                //Stores current value in this object to avoid pointer issues
                //(Not currently working and seems to be taking the values from original Node)
                Node lSameMerchant = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, currentState.left);;
                lSameMerchant.explanation.append("\nMove two Merchants RIGHT");

                if( (!(currentState.pastNodes.contains(lSameMerchant))) && ((currentState.lBandit < currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 ) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 )) {
                    //Adds to HashSet of possible states
                    myHashSet.add(lSameMerchant);
                }


                //Resets current state to original so when we go to the next if we can start again
                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;

            }

            // Different +1M +1B
            if (currentState.lMerchant >= 1 && currentState.lBandit >= 1){

                currentState.AddMerchantRight(1);
                currentState.AddBanditRight(1);

                Node lDif = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, false);
                lDif.explanation.append("\nMove one Bandit and one Merchant RIGHT");


                if((!(currentState.pastNodes.contains(lDif))) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 ) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 )) {
                    myHashSet.add(lDif);
                }
                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;
            }

            //Same Bandit +2B
            if (currentState.lBandit >= 2) {
                currentState.AddBanditRight(2);

                Node lSameBandit = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, false);
                lSameBandit.explanation.append("\nMove two Bandit RIGHT");


                if((!(currentState.pastNodes.contains(lSameBandit))) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 ) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 )) {
                    myHashSet.add(lSameBandit);
                }


                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;

            }

            //One Bandit +1B
            if (currentState.lBandit >= 1) {

                currentState.AddBanditRight(1);


                Node lOneBandit = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, false);
                lOneBandit.explanation.append("\nMove one Bandit RIGHT");


                if((!(currentState.pastNodes.contains(lOneBandit))) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 ) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 )) {
                    myHashSet.add(lOneBandit);
                }

                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;

            }

            //One Merchant +1M
            if (currentState.lMerchant >= 1) {

                currentState.AddBanditRight(1);

                Node lOneMerchant = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, false);
                lOneMerchant.explanation.append("\nMove one Merchants RIGHT");


                if((!(currentState.pastNodes.contains(lOneMerchant))) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 ) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 )) {
                    myHashSet.add(lOneMerchant);
                }
                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;

            }
        }


        //Right Side
        else {
            //Same Merchant + 2M
            if (currentState.rMerchant >= 2) {

                currentState.AddMerchantLeft(2);

                Node rSameMerchant = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, true);
                rSameMerchant.explanation.append("\nMove two Merchants LEFT");

                if((!(currentState.pastNodes.contains(rSameMerchant))) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 ) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 )){
                    myHashSet.add(rSameMerchant);
                }


                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;
            }

            // Different +1M +1B
            if (currentState.rMerchant >= 1 && currentState.rBandit >= 1){

                currentState.AddMerchantLeft(1);
                currentState.AddBanditLeft(1);

                Node rDif = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, true);
                rDif.explanation.append("\nMove one Bandit and one Merchant LEFT");

                if((!(currentState.pastNodes.contains(rDif))) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 ) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 )) {
                    myHashSet.add(rDif);
                }

                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;
            }

            //Same Bandit +2B
            if (currentState.rBandit >= 2) {

                currentState.AddBanditLeft(2);

                Node rSameBandit = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, true);
                rSameBandit.explanation.append("\nMove two Bandit LEFT");

                if((!(currentState.pastNodes.contains(rSameBandit))) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 ) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 )) {
                    myHashSet.add(rSameBandit);
                }


                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;
            }

            //One Bandit +1B
            if (currentState.rBandit >= 1) {

                currentState.AddBanditLeft(1);


                Node rOneBandit = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, true);
                rOneBandit.explanation.append("\nMove one Bandit LEFT");

                if((!(currentState.pastNodes.contains(rOneBandit))) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 ) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 )) {
                    myHashSet.add(rOneBandit);
                }

                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;

            }

            //One Merchant +1M
            if (currentState.rMerchant >= 1) {

                currentState.AddMerchantLeft(1);

                Node rOneMerchant = new Node(currentState.lBandit,currentState.rBandit,currentState.lMerchant,currentState.rMerchant, true);
                rOneMerchant.explanation.append("\nMove one Merchants LEFT");

                if((!(currentState.pastNodes.contains(rOneMerchant))) && ((currentState.rBandit <= currentState.rMerchant)|| currentState.rBandit == 0 || currentState.rMerchant == 0 ) && ((currentState.lBandit <= currentState.lMerchant)|| currentState.lBandit == 0 || currentState.lMerchant == 0 )) {
                    myHashSet.add(rOneMerchant);
                }

                currentState.lBandit = original.lBandit;
                currentState.rBandit = original.rBandit;
                currentState.lMerchant = original.lMerchant;
                currentState.rMerchant = original.rMerchant;
                currentState.left = original.left;

            }
        }

        return myHashSet;
    }


}
