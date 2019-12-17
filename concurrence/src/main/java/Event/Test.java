package Event;

/**
 * @author ys 2019/12/16 2:59 下午
 */
public class Test {
    public static void main(String[] args) {
        EventSourceObject eventObjectDemo = new EventSourceObject();
        eventObjectDemo.addCusListener(new CusEventListener());
        eventObjectDemo.trigger("name2");
    }
}
