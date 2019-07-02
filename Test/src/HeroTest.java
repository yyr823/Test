/**
 * 
 */

/**
 * @author PE
 * @date 2019年6月24日 上午9:31:04
 * @explain
 */
public class HeroTest {
	public static void main(String[] args) {
		Hero h = new Hero("提莫", 383);
		h.hp = h.hp - 400;
		h.revive(h);
		System.out.println(h.hp);// -17

	}
}
