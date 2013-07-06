package com.gridpoint.energy.domainmodel;


public enum ChannelTotalType {

    UNKNOWN((int)-1), SUBMETERED((int)0), TOTAL((int)1), ALTERNATE_TOTAL((int)2), NON_TOTAL((int)3), GENERATED((int)4);
    
    private final int totalTypeId;
    
    private ChannelTotalType(int totalTypeId){
        this.totalTypeId = totalTypeId;
    }
    
    public int getByteId() {
        return totalTypeId;
    }
    
    public static ChannelTotalType fromByte(int id) {
        switch (id) {
            case 0: return SUBMETERED;
            case 1: return TOTAL;
            case 2: return ALTERNATE_TOTAL;
            case 3: return NON_TOTAL;
            case 4: return GENERATED;
        }
        
        return UNKNOWN;
    }
}
