import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    public static void run()throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.printf("How many attackers or defenders you want?\n");
        int length = input.nextInt();

        //Make those <public static> , if you want to use them , outside this class
        ArrayList<Attackers> team1 = new ArrayList();
        ArrayList<Defenders> team2 = new ArrayList();

        for (int i = 0; i < length; i++) {//Fill the teams with random guys
            team1.add(new Attackers("attacker no." + i));
            team2.add(new Defenders("defender no." + i));
        }

        //Initialize variables
        int round = 1, soldiernum1, soldiernum2,game = 1;
        Defenders defender;
        Attackers attacker;

        while (!(team1.size() == 0 || team2.size() == 0)) {//Cycle till one of teams gets empty MEANS DEFEATED !

            soldiernum1 = RandomHelper.nextInt(team1.size());
            soldiernum2 = RandomHelper.nextInt(team2.size());

            //Move attacker to variable
            attacker = team1.get(soldiernum1);
            team1.remove(soldiernum1);

            //Move defender to variable
            defender = team2.get(soldiernum2);
            team2.remove(soldiernum2);
            System.out.printf("Game : %d\n",game);
            while (attacker.getHealth() > 0 && defender.getHealth() > 0) {//Cycle till one of soliders gets killed MEANS DEFEATED !
                System.out.printf("Round %d\n",round);
                Thread.sleep(1000);
                System.out.printf("Attacker Shoots!\n");
                int r2 = RandomHelper.nextInt() % 10;
                if(r2 < 0){
                    r2 = r2 * -1;
                }
                if(r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5){
                    int h2 = defender.getHealth();
                    int h4 = h2 - 20;
                    defender.setHealth(h4);
                }
                Thread.sleep(1000);
                if(defender.getHealth() != 100){
                    System.out.printf("Attacker succesfully shooted the target!\n");
                    System.out.printf("enemies Health : %d\n",defender.getHealth());
                }else{
                    System.out.printf("Attacker missed!\n");
                }
                if(defender.getHealth() == 0){
                    System.out.printf("Defender died in the Battlefield!\n");
                }
                Thread.sleep(1000);
                System.out.printf("Defender Shoots!\n");
                Thread.sleep(1000);
                int r1 = RandomHelper.nextInt() % 10;
                if(r1 < 0){
                    r1 = r1 * -1;
                }
                if(r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5){
                    int h1 = attacker.getHealth();
                    int h3 = h1 - 20;
                    attacker.setHealth(h3);
                }
                if(attacker.getHealth() != 100){
                    System.out.printf("Defender succesfully shooted the target!\n");
                    System.out.printf("enemies Health : %d\n",attacker.getHealth());
                }else{
                    System.out.printf("Defender missed!\n");
                }
                if(attacker.getHealth() == 0){
                    System.out.printf("Attacker died in the Battlefield!\n");
                }
                round++;
            }
            game++;
            //Return the solider to his team if he is already alive !
            if(attacker.getHealth() > 0)
                team1.add(attacker);

            //Same as previous
            if (defender.getHealth() > 0)
                team2.add(defender);
        }
    }


}
