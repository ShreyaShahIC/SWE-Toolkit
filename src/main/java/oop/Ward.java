package oop;

// Week 2: static (class) field and static method vs instance fields and methods.
public class Ward {
    public static int count = 0;      // one copy shared by every Ward
    protected String name;            // one per object; protected so subclasses can use it

    public Ward(String name) {
        count++;
        this.name = name;             // "this" separates the field from the parameter
    }

    public String getName() {
        return name;
    }

    public static String[] getAllWardTypes() {   // static: call as Ward.getAllWardTypes()
        return new String[]{"General", "Maternity"};
    }
}
