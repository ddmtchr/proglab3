package entities;

import utilities.Human;
import utilities.Job;
import utilities.LoseAll;
import utilities.JobChanger;

import java.util.Objects;

public class Scooperfield extends Human implements LoseAll, JobChanger {
    private Job workPlace;
    private int money = 2000000;
    private Manufacture property;

    public Scooperfield(String name) {
        super(name);
        System.out.println("Создан персонаж " + name + ".");
    }

    public void setProperty(Manufacture p) {
        this.property = p;
        System.out.println("Персонаж " + this.getName() + " владеет " + p.getName());
    }

    @Override
    public void changeJob(Job job) {
        this.workPlace = Job.WORKER;
        System.out.println("Персонаж " + this.getName() + " меняет профессию на " + job.translate());
    }

    @Override
    public void loseProperty() {
        System.out.println("Персонаж " + this.getName() + " потерял имущество " + this.property.getName());
        this.property = null;
    }

    @Override
    public void loseMoney(int m) {
        this.money -= m;
        System.out.println("Персонаж " + this.getName() + " растерял свои капиталы. Баланс: " + this.money);
    }

    @Override
    public String toString() {
        return "Scooperfield";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooperfield that = (Scooperfield) o;
        return that.getName() == this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(workPlace, money, property);
    }
}
