package StackAndQueue.CatAndDog;

/**
 * Created by 10609 on 2017/3/27.
 */
public class CatAndDog {
    private Pet pet;
    private int count;

    public CatAndDog(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public String getPetType() {
        return this.pet.getPetType();
    }

    public int getCount() {
        return this.count;
    }
}
