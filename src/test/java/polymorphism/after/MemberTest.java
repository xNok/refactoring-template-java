package polymorphism.after;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import polymorphism.before.Member;

class MemberTest {

    @Test
    void before_getContent() {

        Member freeMember = new Member(Member.Type.FREE);
        Assertions.assertEquals(freeMember.getContent(), "No content available.");
        Member basicMember = new Member(Member.Type.BASIC);
        Assertions.assertEquals(basicMember.getContent(), "Basic content.");
        Member premiumMember = new Member(Member.Type.PREMIUM);
        Assertions.assertEquals(premiumMember.getContent(), "Premium content.");
    }

    @Test
    void after_getContent() {
        FreeTierMember freeTierMember = new FreeTierMember();
        Assertions.assertEquals(freeTierMember.getContent(), "No content available.");
        BasicTierMember basicTierMember = new BasicTierMember();
        Assertions.assertEquals(basicTierMember.getContent(), "Basic content.");
        PremiumTierMember premiumTierMember = new PremiumTierMember();
        Assertions.assertEquals(premiumTierMember.getContent(), "Premium content.");
    }
}