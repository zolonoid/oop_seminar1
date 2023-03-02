import java.util.ArrayList;
import java.util.Date;

public class FamilyMemeber extends Human
{
    private int _id;
    private FamilyMemeber _parent;
    private Human _spouse;
    private  ArrayList<FamilyMemeber> _children;
    
    FamilyMemeber(int id, String name, String sex, Date birthDay, FamilyMemeber parent)
    {
        super(name, sex, birthDay);
        _id = id;
        _parent = parent;
        _children = new ArrayList<FamilyMemeber>();
        if(parent != null)
            parent._children.add(this);
    }

    @Override
    public String toString()
    {
        var str = new StringBuilder();
        var base = "ID: %d\n" +
                   "Имя: %s\n" +
                   "Пол: %s\n" +
                   "Дата рождения: %s\n" +
                   "Дата смерти: %s\n";
        str.append(String.format(base, _id + 1, _name, _sex, _birthDay, _deathDay));
        str.append("Родители:\n");
        if(_parent != null)
        {
            var parents = "  %s (ID: %s)\n" +
                          "  %s (ID: %s)\n";
            str.append(String.format(parents, _parent._name, _parent._id + 1, _parent._spouse._name, "-"));
        }
        else str.append("  Неизвестно\n");
        str.append("Дети:\n");
        if(_children.size() > 0)
        {
            for(FamilyMemeber child : _children)
                str.append(String.format("  %s (ID: %s)\n", child._name, child._id + 1));
        }
        else str.append("  Нет\n");
        return str.toString();
    }
    
    public int Id() { return _id; }
    public FamilyMemeber Parent() { return _parent; }
    public Human Spouse() { return _spouse; }
    public void Spouse(Human spouse) { _spouse = spouse; }
    public FamilyMemeber[] Children() { return _children.toArray(new FamilyMemeber[0]); }
}
