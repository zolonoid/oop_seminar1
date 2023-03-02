import java.util.Date;

public class Human
{
    protected String _name;
    protected String _sex;
    protected Date _birthDay;
    protected Date _deathDay;

    Human(String name, String sex, Date birthDay)
    {
        _name = name;
        _sex = sex;
        _birthDay = birthDay;
        _deathDay = null;
    }

    public String Name() { return _name; }
    public String Sex() { return _sex; }
    public Date BirthDay() { return _birthDay; }
    public Date DeathDay() { return _deathDay; }
    public void DeathDay(Date deathDay) { _deathDay = deathDay; }
}
