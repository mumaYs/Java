package Event;

import java.util.EventListener;

/**
 * 2.事件监听器
 */
class CusEventListener implements EventListener {
    public void fireCusEvent(CusEvent event) {
        EventSourceObject object = (EventSourceObject) event.getSource();
        System.out.println("Name is Changed!");
        System.out.println("New Name is " + object.getName());
    }
}
