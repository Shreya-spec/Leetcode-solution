class ParkingSystem {
    int[] size = new int[3];
    public ParkingSystem(int big, int medium, int small) {
     size[0] = big;
        size[1] = medium;
        size[2] = small;
        
    }
    
    public boolean addCar(int carType) {
        return size[carType-1]-- > 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */