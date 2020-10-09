package osr.monsterGenerator.model.npc;

/****** IMPORTANT NOTE ******
 * Always be careful with assigning tags.  One of the virtues of random generation are the
 * unconventional creations that can be born of it.  The tighter the system, the greater the human bias.  In our
 * case, weird is good.  Weird is the goal.
 * */
public enum Tags {
    MACHINE("machine"),
    GONZO("gonzo"),
    COLD("cold"),
    HEAT("heat"),
    MARINE("marine"),
    AIRBORNE("airborne"),
    SPACEBORNE("spaceborne"),
    ABSOLUTE_DARK("absolute dark");

    public final String label;

    Tags(String label) {
        this.label = label;
    }
}
