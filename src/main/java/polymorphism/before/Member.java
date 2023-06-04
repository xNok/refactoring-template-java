package polymorphism.before;

public class Member {
    private Type type;

    public Member(Type type) {
        this.type = type;
    }

    public String getContent() {
        switch (type) {
            case FREE:
                return "No content available.";
            case BASIC:
                return "Basic content.";
            case PREMIUM:
                return "Premium content.";
        }
        throw new RuntimeException("Member type not known for " + type);
    }

    public enum Type {
        PREMIUM,
        BASIC,
        FREE
    }
}
