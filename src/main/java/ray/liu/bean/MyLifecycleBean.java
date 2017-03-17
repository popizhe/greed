package ray.liu.bean;

import org.apache.ignite.IgniteException;
import org.apache.ignite.lifecycle.LifecycleBean;
import org.apache.ignite.lifecycle.LifecycleEventType;

public class MyLifecycleBean implements LifecycleBean {
	@Override
	public void onLifecycleEvent(LifecycleEventType evt) throws IgniteException {
		// TODO Auto-generated method stub
		if (evt == LifecycleEventType.BEFORE_NODE_START) {
			// Do something.
			System.out.println("!!!");
		}
		
	}
}
