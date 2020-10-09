package osr.monsterGenerator.repository;

public enum AttributeCollection {
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

    AttributeCollection(String label) {
        this.label = label;
    }
}
