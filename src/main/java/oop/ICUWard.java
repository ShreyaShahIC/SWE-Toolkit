package oop;

// Week 2: inheritance. super(...) first, @Override replaces a method, super.method() calls the parent's.
public class ICUWard extends Ward {

    public ICUWard(String name) {
        super(name);                              // must be the first line
    }

    @Override
    public String getName() {                     // override: same signature as Ward.getName()
        return "ICU Ward:" + super.getName();
    }

    public String getName(boolean shout) {        // overload: same name, different parameters
        return shout ? getName().toUpperCase() : getName();
    }
}
