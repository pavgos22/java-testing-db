package com.patterns.strategy.social;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        User millenial = new Millenials("millenial_user");
        User xGen = new XGeneration("xgen_user");
        User zGen = new ZGeneration("zgen_user");

        assertEquals("Using Facebook", millenial.sharePost());
        assertEquals("Using Twitter", xGen.sharePost());
        assertEquals("Using Snapchat", zGen.sharePost());
    }

    @Test
    public void testIndividualSharingStrategy() {
        User millenial = new Millenials("millenial_user");

        String millenialDefaultShare = millenial.sharePost();
        millenial.setSocialPublisher(new TwitterPublisher());
        String millenialNewShare = millenial.sharePost();

        assertEquals("Using Facebook", millenialDefaultShare);
        assertEquals("Using Twitter", millenialNewShare);
    }
}
