package csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CsvReader {
	private static String filepath;
	private static String filepath2;
	private static String filepath3;
	//private static String c_filepath;
	private DbOperation db;

	public CsvReader() {
		filepath = "H:\\マイドライブ\\SQL\\言葉テーブルall.txt";
		filepath2 = "H:\\マイドライブ\\SQL\\カクテルレシピtext.csv";
		filepath3 = "H:\\マイドライブ\\SQL\\カクテル製法の用語.csv";
		db = new DbOperation();
	}

	public void csvWordsReader() {//カクテル言葉読み込み
		try {
			File file = new File(filepath);
			//ファイルが存在する場合は処理をする。
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					//CSVファイルは「,」でsplitする
					String[] str = line.split(",");
					//クラス配列に入れる等その他の処理に繋げていく
					db.dbWordsIn(str[0],str[1],str[2]);
				}
				br.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void csvrecipeReader() {//レシピ読み込み
		try {
			File file = new File(filepath2);
			//ファイルが存在する場合は処理をする。
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					//ファイルから1行読み込んだ内容を処理する
					//CSVファイルは「,」でsplitする
					String[] str = line.split(",");
					//クラス配列に入れる等その他の処理に繋げていく

					db.dbRecipeIn(str[0],str[1],str[2],str[3],str[4]);
				}
				br.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void csvyougoReader() {//レシピ読み込み
		try {
			File file = new File(filepath3);
			//ファイルが存在する場合は処理をする。
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					//ファイルから1行読み込んだ内容を処理する
					//CSVファイルは「,」でsplitする
					String[] str = line.split(",");
					//クラス配列に入れる等その他の処理に繋げていく

					db.dbYougoIn(str[0],str[1]);
				}
				br.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
