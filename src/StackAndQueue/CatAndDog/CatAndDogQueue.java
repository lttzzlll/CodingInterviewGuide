package StackAndQueue.CatAndDog;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 10609 on 2017/3/27.
 */
public class CatAndDogQueue {
    private Queue<CatAndDog> dogQueue;
    private Queue<CatAndDog> catQueue;
    private int count;

    public CatAndDogQueue() {
        this.catQueue = new LinkedList<CatAndDog>();
        this.dogQueue = new LinkedList<CatAndDog>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQueue.add(new CatAndDog(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQueue.add(new CatAndDog(pet, this.count++));
        } else {
            throw new RuntimeException("Only cat and dog supported!");
        }
    }

    public Pet pollAll() {
        if (!this.catQueue.isEmpty() && !this.dogQueue.isEmpty()) {
            if (this.catQueue.peek().getCount() < this.dogQueue.peek().getCount()) {
                return this.catQueue.poll().getPet();
            } else {
                return this.dogQueue.poll().getPet();
            }
        } else if (this.catQueue.isEmpty()) {
            return this.dogQueue.poll().getPet();
        } else if (this.dogQueue.isEmpty()) {
            return this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("Queue is empty!");
        }
    }

    public Dog pollDog() {
        if (this.dogQueue.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return (Dog) this.dogQueue.poll().getPet();
    }

    public Cat pollCat() {
        if (this.catQueue.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return (Cat) this.catQueue.poll().getPet();
    }

    public boolean isEmpty() {
        return this.catQueue.isEmpty() && this.dogQueue.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQueue.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQueue.isEmpty();
    }

    public static void test() {
        CatAndDogQueue catAndDogQueue = new CatAndDogQueue();
        catAndDogQueue.add(new Dog());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Dog());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Dog());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Dog());
        while (!catAndDogQueue.isEmpty()) {
            Pet pet = catAndDogQueue.pollAll();
            System.out.print(pet.getPetType() + "\t");
        }
        System.out.println();

        catAndDogQueue.add(new Dog());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Dog());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Dog());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Cat());
        catAndDogQueue.add(new Dog());
        while (!catAndDogQueue.isCatQueueEmpty()) {
            Pet pet = catAndDogQueue.pollCat();
            System.out.print(pet.getPetType() + "\t");
        }
        System.out.println();

        while (!catAndDogQueue.isDogQueueEmpty()) {
            Pet pet = catAndDogQueue.pollDog();
            System.out.print(pet.getPetType() + "\t");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        test();
    }
}
