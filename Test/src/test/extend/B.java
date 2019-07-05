/**
 * 
 */
package test.extend;

/**
 * @author PE
 * @date 2019年7月3日 上午11:11:06
 * @explain 
 */
public class B  extends A{
	public String show(B obj) {
		return ("B and B");
	}
	public String show(A obj) {
		return ("B and A");
	}
}
