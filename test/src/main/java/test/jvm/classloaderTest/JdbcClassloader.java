package test.jvm.classloaderTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * SPI接口中的代码经常需要加载具体的第三方实现类并调用其相关方法，但SPI的核心接口类是由引导类加载器来加载的，
 * 而Bootstrap类加载器无法直接加载SPI的实现类，同时由于双亲委派模式的存在，Bootstrap类加载器也无法反向委托AppClassLoader加载器SPI的实现类。
 * 在这种情况下，我们就需要一种特殊的类加载器来加载第三方的类库，而线程上下文类加载器就是很好的选择。
 * @author Administrator
 *
 */
public class JdbcClassloader {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/jiuzhenbao?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
			// 通过java库获取数据库连接
			Connection conn = java.sql.DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
