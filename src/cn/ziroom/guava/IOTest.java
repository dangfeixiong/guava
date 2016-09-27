package cn.ziroom.guava;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

/**
 * 
* @ClassName IOTest 
* @Description guava IO 操作测试类	Files
* @author dfx
* @date 2015年12月22日 下午3:45:51 
*
 */
public class IOTest {

	//向文件中写内容
	public static void writeFile(String fileName,String contents){
		Preconditions.checkNotNull(fileName, "Provided file name for writing must NOT be null.");
		Preconditions.checkNotNull(contents, "Unable to write null contents.");
		File file = new File(fileName);
		try {
			Files.write(contents.getBytes(),file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//从文件中读取内容(少量)
	public static void readFile(String fileName){
		Preconditions.checkNotNull(fileName, "Provided file name for writing must NOT be null.");
		File file = new File(fileName);
		try {
			List<String> strList = Files.readLines(file, Charsets.UTF_8);
			for (String line : strList) {
				System.out.println("结果:" + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//=================================================
	
	public static class CounterLine implements LineProcessor<Integer> {
        private int rowNum = 0;
       @Override
        public boolean processLine(String line) throws IOException {
            rowNum ++;
            return true;
        }

        @Override
        public Integer getResult() {
            return rowNum;
        }
    }
	
	//从文件读取内容
	public static void readBigFile(String fileName){
		Preconditions.checkNotNull(fileName, "Provided file name for writing must NOT be null.");
		File file = new File(fileName);
		CounterLine CounterLine = new CounterLine();
		try {
			Files.readLines(file, Charsets.UTF_8, CounterLine);
			Files.touch(file);//touch方法创建或者更新文件的时间戳
			String nameWithOut = Files.getNameWithoutExtension(fileName);//获得不带扩展名的文件名
			String nameWith = Files.getFileExtension(fileName);//获得文件的扩展名
			System.out.println("无后缀文件名:" + nameWithOut);
			System.out.println("有后缀文件名:" + nameWith);
			System.out.println("结果:" + CounterLine.getResult());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//移动文件
	public static void moveFile(String sourceFileName,String targetFileName){
		Preconditions.checkNotNull(sourceFileName, "Copy source file name must NOT be null.");
		Preconditions.checkNotNull(targetFileName, "Copy target file name must NOT be null.");
		File sourceFile = new File(sourceFileName);
		File targetFile = new File(targetFileName);
		
		try {
			//Files.createParentDirs(targetFile);//创建父级目录
			Files.copy(sourceFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//比较文件内容
	public static void compareFile(String fileName1, String fileName2){
		Preconditions.checkNotNull(fileName1, "Compare file fileName1 must NOT be null.");
		Preconditions.checkNotNull(fileName2, "Compare file fileName2 must NOT be null.");
		File file1 = new File(fileName1);
		File file2 = new File(fileName2);
		try {
			System.out.println(Files.equal(file1, file2) ? "IS" : "is NOT");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//测试写
	@Test
	public void writeFileTest(){
		String fileName = "config/file.txt";
		String contents = "guava工具类写文件操作";
		writeFile(fileName,contents);
	}
	
	//测试读
	@Test
	public void readFileTest(){
		String fileName = "config/file.txt";
		readFile(fileName);
	}
	
	//测试读
	@Test
	public void readBigFileTest(){
		String fileName = "config/file.txt";
		readBigFile(fileName);
	}
	
	//测试copy
	@Test
	public void moveFileTest(){
		String sourceFileName = "D:\\test.txt";
		String targetFileName = "config/test.txt";
		//String targetFileName = null;
		moveFile(sourceFileName,targetFileName);
	}
	
	//测试Equal
	@Test
	public void compareFileTest(){
		//String fileName1 = "config/test.txt";
		String fileName1 = "config/file.txt";
		String fileName2 = "config/test.txt";
		compareFile(fileName1, fileName2);
	}
}
