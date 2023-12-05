package dev.knodeln.chuddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chuddyUsers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuddyUser {

    @Id
    private ObjectId id;

    private String name;

    private int age;

    private List<Integer> prefAges;

    private String userDescription;

    private Programme programme;

    private List<Programme> prefProgrammes;

    private int year;

    private List<Integer> prefYears;

    private Gender gender;

    private ProfilePicture profilePicture;

    private List<Interest> interests;

    public ChuddyUser(
            String name,
            int age,
            List<Integer> prefAges,
            Programme programme,
            List<Programme> prefProgrammes,
            int year,
            List<Integer> prefYears,
            Gender gender,
            List<Interest> interests) {
        this.name = name;
        this.age = age;
        this.prefAges = prefAges;
        this.programme = programme;
        this.prefProgrammes = null;
        this.year = year;
        this.prefYears = prefYears;
        this.gender = gender;
        this.interests = interests;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    public void setPrefAges(List<Integer> prefAges) {
        this.prefAges = prefAges;
    }

    public void setProgramme(Programme p) {
        this.programme = p;
    }

    public void setPrefProgrammes(List<Programme> p) {
        this.prefProgrammes = p;
    }

    public void setYear(int year) {
        if (year < 0 || year > 5)
            throw new IllegalArgumentException("Year has to be in [0, 5]!");
        this.year = year;
    }

    public void setPrefYears(List<Integer> prefYears) {
        for (int year : prefYears) {
            if (year < 0 || year > 5)
                throw new IllegalArgumentException("Year has to be in [0, 5]!");
        }

        this.prefYears = prefYears;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public int getAge() {
        return this.age;
    }

    public List<Integer> getPrefAges() {
        return this.prefAges;
    }

    public Programme getProgramme() {
        return this.programme;
    }

    public List<Programme> getPrefProgrammes() {
        return this.prefProgrammes;
    }

    public int getYear() {
        return this.year;
    }

    public List<Integer> getPrefYears() {
        return this.prefYears;
    }

    public List<Interest> getInterests() {
        return this.interests;
    }
}
