package Event;

import java.util.*;

/**
 * 事件监听机制-观察者模式
 *
 * @author ys 2019/12/16 2:18 下午
 */

/**
 * 3.事件源
 */
public class EventSourceObject {
    private String name;
    private Set<CusEventListener> listeners;

    public EventSourceObject() {
        this.listeners = new HashSet<>();
        this.name = "defalutName";
    }

    /**
     * 给事件源注册监听器
     *
     * @param listener
     */
    public void addCusListener(CusEventListener listener) {
        this.listeners.add(listener);
    }

    /**
     * 当事件发生时，通知注册在该事件源上的所有监听器作出相应反应(调用回调方法)
     */
    protected void notifies() {
        CusEventListener cell;
        for (CusEventListener listener : listeners) {
            listener.fireCusEvent(new CusEvent(this));
        }
    }

    /**
     * 触发事件方法:改名字
     */
    public void trigger(String name) {
        if (!this.name.equals(name)) {
            this.name = name;
            notifies();
        }
    }

    public String getName() {
        return name;
    }
}