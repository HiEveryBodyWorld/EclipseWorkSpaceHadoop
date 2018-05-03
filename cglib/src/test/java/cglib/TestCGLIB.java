package cglib;

import org.junit.Test;

import com.darren.cglib.ProxyFactory;
import com.darren.init.UserDao;

public class TestCGLIB {

	@Test
    public void test(){
        //Ŀ�����
        UserDao target = new UserDao();

        //�������
        UserDao proxy = (UserDao)new ProxyFactory(target).getInstance();

        //ִ�д������ķ���
        proxy.save();
	}
	
}
