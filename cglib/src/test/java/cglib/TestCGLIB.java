package cglib;

import org.junit.Test;

import com.darren.cglib.ProxyFactory;
import com.darren.init.UserDao;

public class TestCGLIB {

	@Test
    public void test(){
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getInstance();

        //执行代理对象的方法
        proxy.save();
	}
	
}
