package DAL.Model;

public class Exercise {

    private int _id;
    private String _name;
    private String _description;
    private ExerciseGroupType _groupType;

    public Exercise(int id, String name, String description, ExerciseGroupType groupType) {
        SetId(id);
        SetName(name);
        SetDescription(description);
        SetGroupType(groupType);
    }

    public int GetId() {
        return _id;
    }

    public void SetId(int value) {
        _id = value;
    }

    public String GetName() {
        return _name;
    }

    public void SetName(String value) {
        _name = value;
    }

    public String GetDescription() {
        return _description;
    }

    public void SetDescription(String value) {
        _description = value;
    }

    public ExerciseGroupType GetGroupType() {
        return _groupType;
    }

    public void SetGroupType(ExerciseGroupType value) {
        _groupType = value;
    }

}

// create table exercise (
// exerciseid serial primary key,
// exercisename varchar(64) not null,
// exercisedescription text not null,
// exercisegroup ExerciseGroupType not null
// );
