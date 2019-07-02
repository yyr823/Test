import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 */

/**
 * @author PE
 * @date 2019年6月25日 下午2:53:13
 * @explain
 */
public class Test {
	public static void main(String[] args) throws IOException {

		File f = new File("D:/testcode/tt.txt");

		try {
			System.out.println("试图打开 d:/LOL.exe");
			FileInputStream file = new FileInputStream(f);
			System.out.println("成功打开");
			file.close();

		} catch (FileNotFoundException e) {
			System.out.println("d:/LOL.exe不存在");
			e.printStackTrace();
		}

	}
}
