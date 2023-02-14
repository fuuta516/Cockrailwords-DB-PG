package csv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DbOperation {
	String url = "jdbc:postgresql://localhost:5432/postgres";	//DBのURL
	String user = "postgres";		//DBのユーザー名
	String password = "postgrestest";	//DBのパスワード

	public void dbWordsIn(String wordscate,String coctail,String words) {//カクテル言葉

		String sql = "insert into カクテル言葉(言葉カテゴリ,カクテル名,言葉) values (?,?,?)";

		try(Connection con=DriverManager.getConnection(url, user, password );
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			pstmt.setString(1,wordscate);
			pstmt.setString(2,coctail);
			pstmt.setString(3,words);

			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void dbRecipeIn(String wordscate,String coctail,String words,String imageURL,String howto,String material) {//レシピ

		String sql = "insert into カクテルレシピ(言葉カテゴリ,カクテル名,言葉,URL,作り方,材料) values (?,?,?,?,?,?)";

		try(Connection con=DriverManager.getConnection(url, user, password );
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			pstmt.setString(1,wordscate);
			pstmt.setString(2,coctail);
			pstmt.setString(3,words);
			pstmt.setString(4,imageURL);
			pstmt.setString(5,howto);
			pstmt.setString(6,material);

			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public ArrayList<InfoData> dbWordsInfo(){
		ArrayList<InfoData> a = new ArrayList<InfoData>();

		String sql = "select 言葉カテゴリ,カクテル名,言葉 from カクテル言葉";

		try(Connection con=DriverManager.getConnection(url, user, password );
				PreparedStatement pstmt = con.prepareStatement(sql); )
		{
				ResultSet result = pstmt.executeQuery ();

			while ( result.next() ) {
				String col1 = result.getString (1) ; //費目
				String col2 = result.getString (2) ; //メモ
				String col3 = result.getString (3) ;

				a.add(new InfoData(col1,col2,col3));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}
}
