package src;

public enum ItemRarity {
    
    MIL_SPEC(79.92f),
    RESTRICTED(19.98f),
    CLASSIFIED(9.99f),
    COVERT(0.01f),
    RARE_SPECIAL_ITEM(0.001f);
    
    private final float dropRate;
    
    ItemRarity(float dropRate) {
        this.dropRate = dropRate;
    }
    
    public float getDropRate() {
        return dropRate;
    }
}
