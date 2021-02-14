//Program Name: Lab01
//Author: Nathaniel Armogan
//Description: This program simulates a battle between krogg and the boss
public class battle{
	//stats for characters
	static float kroggAttack = 38.5f;
	static float kroggDefense = 20.0f;
	static float kroggHP = 200f;
	static float bossAttack = 25f;
	static float bossDefense = 12.5f;
	static float bossHP = 200f;
	static int round = 1;
	//param constuctor
	public battle(float kroggAttack, float kroggDefense, float kroggHP, float bossAttack, float bossDefense, float bossHP){}
	///modifies the hp values of both characters
	public static void attackFunction(){
		float damageFromKrogg = kroggAttack - bossDefense;
		float damageFromBoss = bossAttack - kroggDefense;
		bossHP -= damageFromKrogg;
		System.out.println("Krogg does " + damageFromKrogg + " points of damage to boss");
		kroggHP -= damageFromBoss;
		System.out.println("Krogg does " + damageFromBoss + " points of damage to krogg");
	}
	public static void main(String[] args) {
		while(kroggHP >= 0 || bossHP >= 0){
			System.out.println("Round #" + round);
			attackFunction();
			System.out.println("Boss: " + bossHP);
			System.out.println("Krogg: " + kroggHP);
			System.out.println("-------------------------------------------------------------------");
			//catchs for if they are less than zero due to math to stop the loop
			if(kroggHP < 0)
				break;
			else if(bossHP < 0)
				break;
			round++;
		}
		if (kroggHP > bossHP) {
			System.out.println("Krogg has won. You are victorious");
		}else{
			System.out.println("Boss has won. You are victorious");
		}
	}
}