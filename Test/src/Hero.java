/**
 * 
 */

/**
 * @author PE
 * @date 2019年6月24日 上午9:28:55
 * @explain
 */
class Hero {
	String name;

	float hp;

	float armor;

	int moveSpeed;

	public Hero() {

	}

	public void revive(Hero h) {
		h = new Hero("提莫", 38);
		System.out.println(h.hp);// 38

	}

	public Hero(String name, float hp) {
		this.name = name;
		this.hp = hp;
	}

}