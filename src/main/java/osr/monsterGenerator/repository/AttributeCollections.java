package osr.monsterGenerator.repository;

public enum AttributeCollections {
    BODY_SHAPE("bodyShape"),
    BODY_SURFACE("bodySurface"),
    COMBAT_STRATEGY("combatStrategy"),
    DISTINCTIVE_FEATURE("distinctiveFeature"),
    MOTIVATION("motivation"),
    PHYSICAL_ATTACK("physicalAttack"),
    SAVING_THROW("savingThrow"),
    MOVEMENT("movement"),
    SIZE("size");

    public final String label;

    AttributeCollections(String label) {
        this.label = label;
    }
}
