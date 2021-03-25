import java.sql.*;

public class QueryConsole {

	Public static void main (String[] args){
	try{
	Class.forName(“oracle.jbdc.OracleDriver”);
	} catch (ClassNotFoundException e){
	               e.printStackTrace();
	}
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try{
	conn = DriveManager.getConnection(“jdbc:oracle:thin:scott/triger@localhostAddress:1521:orcl”);
	stmt = conn.createStatement();
	stmt.execute(“ SELECT count(distinct Product_T. ProductID) AS OrderFrequency, Product_T. ProductID, Product_T. ProductDescription, Product_T. ProductFinish 
     FROM Product_t
	GROUP BY Product_T.ProductFinish
	Order BY  OrderFrequency ”)
	rs = stmt.getresultSet();
	while(rs.next()){
	System.out.println(String.format(“%s %s %s %s %s”,) rs.getInt(OrderFrequenct), 
	                                                          rs.getInt(ProductID)
	                                              rs.getString(ProductDescription)
	                                                  re.getString(ProductFinish));
	} 
	}catch (SQLException e) {
	e.printStackTrace();
	} finally {
	             try{
	     rs.close();
	     stmt.close();
	     conn.close();
	     } catch (SQLException e){}
	}
	}

}
