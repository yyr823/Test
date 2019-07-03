/**
 * 
 */
package com.hutool.filetool;

import java.util.List;

import org.junit.Test;

import com.hutool.Comment;
import com.hutool.CommentTool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午10:27:33
 * @explain  区分概念:
 *.csv是一种电子表格的文档形式，可以用Excel 办公软件打开
 * .cvs 是包含由逗号与每个新行分隔的纯文本数据集
 */
public class TestCVS  extends CommentTool{
	 @Test
	    @Comment("读写CVS")
	    public void test1() {
	        //写数据
	        CsvWriter writer = CsvUtil.getWriter("D:\\test.cvs", CharsetUtil.CHARSET_UTF_8);
	        writer.write(
	            new String[] {"a1", "b1", "c1"},
	            new String[] {"a2", "b2", "c2"},
	            new String[] {"a3", "b3", "c3"}
	        );
	        //读数据
	        CsvReader reader = CsvUtil.getReader();
	        //从文件中读取CSV数据
	        CsvData data = reader.read(FileUtil.file("D:\\test.cvs"));
	        List<CsvRow> rows = data.getRows();
	        //遍历行
	        for (CsvRow csvRow : rows) {
	            //getRawList返回一个List列表，列表的每一项为CSV中的一个单元格（既逗号分隔部分）
	            System.out.println(csvRow.getRawList());
	        }
	         
	    }
}
