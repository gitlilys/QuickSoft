package DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Utils.baseUtils;
import entity.Entity;

public class DataOperation {

	public static void saveEntity(String type, int size, double time) {
		Entity t = new Entity(baseUtils.getUUID(), type, size, time);
		save2DB(t);
	}
	
	public static void save2DB(Entity t) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into result values(?,?,?,?)";
		try {
			int update = runner.update(sql, t.getId(), t.getType(), t.getSize(), t.getTime());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List serachFromDB() {
		List<Entity> list = null;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from result";
		try {
			list=(List<Entity>)runner.query(sql,new BeanListHandler(Entity.class));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}
}
