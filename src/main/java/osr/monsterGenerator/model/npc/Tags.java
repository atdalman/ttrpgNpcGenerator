package osr.monsterGenerator.model.npc;

/****** IMPORTANT NOTE ******
 * Always be careful with assigning tags.  One of the virtues of random generation are the
 * unconventional creations that can be born of it.  The tighter the system, the greater the human bias.  In our
 * case, weird is good.  Weird is the goal.
 * */
public enum Tags {
    BASE("setting independent"),
    MACHINE("related to machinery/technology"),
    GONZO("over the top, pulpy"),
    COLD("cold environments"),
    HOT("hot environments"),
    AQUATIC("aquatic environments"),
    AIRBORNE("airborne"),
    SPACEBORNE("spaceborne"),
    ABSOLUTE_DARK("void, chaos, the absence of anything that makes sense");

    public final String description;

    Tags(String description) {
        this.description = description;
    }
}
