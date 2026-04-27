package src;

public enum ItemRarity {
    
    MIL_SPEC(79.92f),
    RESTRICTED(15.98f),
    CLASSIFIED(3.2f),
    COVERT(0.64f),
    RARE_SPECIAL_ITEM(0.26f);
    
    private final float dropRate;
    
    ItemRarity(float dropRate) {
        this.dropRate = dropRate;
    }
    
    public float getDropRate() {
        return dropRate;
    }
}
