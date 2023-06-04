package polymorphism.after;

public class PremiumTierMember extends Member {
    @Override
    public String getContent() {
        return "Premium content.";
    }
}
