package polymorphism;

public class MemberBefore {

    private Type type;

    public String getContent() {
        switch (type) {
            case FREE:
                return "No content available.";
            case BASIC:
                return "Basic content.";
            case PREMIUM:
                return "Premium content";
        }
        throw new RuntimeException("Member type not known for " + type);
    }

    enum Type {
        PREMIUM,
        BASIC,
        FREE
    }
}
